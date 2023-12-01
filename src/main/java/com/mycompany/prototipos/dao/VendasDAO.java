/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prototipos.dao;

import classes.Produto;
import classes.Venda;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jeffe
 */
public class VendasDAO {
    
     static String url = "jdbc:mysql://localhost:3306/StreetClothing";
    static String login = "StreetClothing";
    static String senha = "psc@2*";
    
    public static ArrayList<Venda> listarProdutosVenda(int idPedido) {
        ArrayList<Venda> list = new ArrayList<>();

        Connection connection = null;
        PreparedStatement comandoSQL = null;
        ResultSet rs = null;

        try {
            //carregar o drive
            Class.forName("com.mysql.cj.jdbc.Driver");
            //abrir conexão com o mysql
            connection = DriverManager.getConnection(url, login, senha);
            //preparar comando sql
            comandoSQL = connection.prepareStatement("SELECT Produtos.ID, Produtos.NomeProduto, Produtos.PrecoUnitario,"
                    + " ITEMPEDIDO.Quantidade, ItemPedido.FK_PEDIDO_ID_Pedido, "
                    + " ROUND(SUM(ITEMPEDIDO.Quantidade * Produtos.PrecoUnitario), 2) AS subtotal"
                    + " FROM PRODUTOS INNER JOIN ITEMPEDIDO ON PRODUTOS.ID = FK_PRODUTOS_ID"
                    + " WHERE ItemPedido.FK_PEDIDO_ID_Pedido = ?"
                    + " GROUP BY ItemPedido.PK_ITEMPEDIDO");

            comandoSQL.setInt(1, idPedido);
            //executar comando sql
            rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Venda item = new Venda();
                    item.setCodProduto(rs.getInt("ID"));
                    item.setNomeProduto(rs.getString("NomeProduto"));
                    item.setQtdeProduto(rs.getInt("Quantidade"));
                    item.setPrecoProduto(rs.getDouble("PrecoUnitario"));
                    item.setSubTotal(rs.getDouble("subtotal"));
                    list.add(item);
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StreetClothingDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StreetClothingDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StreetClothingDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    public static boolean cadastrarPedido(Venda vendas, int idCliente) {

        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        boolean retorno = false;

        try {
            //Carregando o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Abrir conexão com o Banco
            conexao = DriverManager.getConnection(url, login, senha);

            //Preparar comando SQL
            comandoSQL = conexao.prepareStatement("INSERT INTO Pedido (FormaPagamento, FK_CLIENTES_ID) "
                    + "VALUES(?, ?)");
            comandoSQL.setString(1, vendas.getPagamento());
            comandoSQL.setInt(2, idCliente);

            //Executando o comando preparado
            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StreetClothingDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StreetClothingDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StreetClothingDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return retorno;
    }

    public static Venda listarPedido(Venda retornoPedido) {
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Passo 2 - Abrir a conexão com o banco
            conexao = DriverManager.getConnection(url, login, senha);

            //Passo 3 - Preparar o comando SQL a ser executado
            comandoSQL = conexao.prepareStatement("SELECT * FROM Pedido");

            rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    retornoPedido.setIdPedido(rs.getInt("ID_PEDIDO"));
                }

            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StreetClothingDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StreetClothingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retornoPedido;
    }

    public static boolean cadastrarItemPedido(Venda vendas) {

        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        boolean retorno = false;

        try {
            //Carregando o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Abrir conexão com o Banco
            conexao = DriverManager.getConnection(url, login, senha);

            //Preparar comando SQL
            comandoSQL = conexao.prepareStatement("INSERT INTO ITEMPEDIDO (FK_PRODUTOS_ID, FK_PEDIDO_ID_Pedido, Quantidade)"
                    + "VALUES (?, ?, ?)");
            comandoSQL.setInt(1, vendas.getCodProduto());
            comandoSQL.setInt(2, vendas.getIdPedido());
            comandoSQL.setInt(3, vendas.getQtdeProduto());

            //Executando o comando preparado
            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StreetClothingDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StreetClothingDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StreetClothingDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return retorno;
    }
    
    public static Produto verifcaQuantidade(Produto codProduto, int idProduto) {

        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        ResultSet rs = null;

        try {
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Passo 2 - Abrir a conexao com o mysql
            conexao = DriverManager.getConnection(url, login, senha);

            //Passo 3 - Preparar o comando SQL
            comandoSQL = conexao.prepareStatement("SELECT Estoque FROM Produtos WHERE ID = ?");
            comandoSQL.setInt(1, idProduto);
            //Passo 4 - Executar o comando SQL
            rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    codProduto.setEstoqueInicial(rs.getInt("Estoque"));
                }
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StreetClothingDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StreetClothingDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StreetClothingDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return codProduto;
    }
    
    public static double somaSubTotal(Venda itemPedido) {
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        ResultSet rs = null;
        double subtotal = 0;

        try {
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Passo 2 - Abrir a conexao com o mysql
            conexao = DriverManager.getConnection(url, login, senha);

            //Passo 3 - Preparar o comando SQL
            comandoSQL = conexao.prepareStatement("SELECT ItemPedido.Quantidade, Produtos.PrecoUnitario "
                    + "FROM ItemPedido "
                    + "INNER JOIN Produtos"
                    + "ON ItemPedido.FK_PRODUTOS_ID = Produtos.ID"
                    + "WHERE ItemPedido.PK_ITEMPEDIDO = ?");
            rs = comandoSQL.executeQuery();
            int qtd = 0;
            double precoUnit = 0;

            if (rs != null) {
                while (rs.next()) {
                    qtd = (rs.getInt("Quantidade"));
                    precoUnit = (rs.getDouble("PrecoUnitario"));
                    subtotal = qtd * precoUnit;
                }
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StreetClothingDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StreetClothingDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StreetClothingDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return subtotal;
    }

    public static boolean excluirItemVenda(int excVenda) {
        Connection conexao = null;
        boolean retorno = false;
        PreparedStatement comandoSQL;

        try {
            //Carregando o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Abrindo conexão com o Banco
            conexao = DriverManager.getConnection(url, login, senha);

            //Preparando o comando SQL
            comandoSQL = conexao.prepareStatement("DELETE FROM itemPedido WHERE FK_PEDIDO_ID_Pedido = ?");
            comandoSQL.setInt(1, excVenda);

            //Executar o comando SQL preparado
            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StreetClothingDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StreetClothingDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StreetClothingDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return retorno;

    }
    
    

    

    public static boolean excluirVenda(int excPedido) {
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        boolean retorno = false;

        try {
            //Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Abrir conexão com o Banco
            conexao = DriverManager.getConnection(url, login, senha);

            //Preparando comando SQL
            comandoSQL = conexao.prepareStatement("DELETE FROM Pedido WHERE ID_PEDIDO = ?");
            comandoSQL.setInt(1, excPedido);

            //Executando o comando SQL preparado
            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StreetClothingDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StreetClothingDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StreetClothingDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return retorno;
    }
}
