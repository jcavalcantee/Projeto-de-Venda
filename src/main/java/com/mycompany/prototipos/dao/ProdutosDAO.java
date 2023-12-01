/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prototipos.dao;

import classes.Cliente;
import classes.Produto;
import classes.Venda;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jeffe
 */
public class ProdutosDAO {

    static String url = "jdbc:mysql://localhost:3306/StreetClothing";
    static String login = "StreetClothing";
    static String senha = "psc@2*";

    public static boolean cadastrarProduto(Produto novoProduto) {

        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        boolean retorno = false;

        try {
            //Carregando o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Abrir conexão com o Banco
            conexao = DriverManager.getConnection(url, login, senha);

            //Preparar comando SQL
            comandoSQL = conexao.prepareStatement("INSERT INTO Produtos(NomeProduto, Categoria, Tamanho, UnidadeMedida, Estoque, PrecoUnitario, Marca)"
                    + "VALUES (?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            comandoSQL.setString(1, novoProduto.getNome());
            comandoSQL.setString(2, novoProduto.getCategoria());
            comandoSQL.setString(3, novoProduto.getTamanho());
            comandoSQL.setString(4, novoProduto.getUnidade());
            comandoSQL.setInt(5, novoProduto.getEstoqueInicial());
            comandoSQL.setFloat(6, novoProduto.getPrecoUnit());
            comandoSQL.setString(7, novoProduto.getMarca());

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

    public static boolean alterarProduto(Produto produtoAlterar) {

        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement comandoSQL = null;

        try {
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Passo 2 - Abrir a conexão com o banco
            conexao = DriverManager.getConnection(url, login, senha);

            //Passo 3 - Preparar o comando SQL a ser executado
            comandoSQL = conexao.prepareStatement("UPDATE Produtos SET NomeProduto = ?, Categoria = ?, Tamanho = ?, UnidadeMedida = ?, Estoque = ?,"
                    + " PrecoUnitario = ?, Marca = ? WHERE ID = ? ");

            comandoSQL.setString(1, produtoAlterar.getNome());
            comandoSQL.setString(2, produtoAlterar.getCategoria());
            comandoSQL.setString(3, produtoAlterar.getTamanho());
            comandoSQL.setString(4, produtoAlterar.getUnidade());
            comandoSQL.setInt(5, produtoAlterar.getEstoqueInicial());
            comandoSQL.setFloat(6, produtoAlterar.getPrecoUnit());
            comandoSQL.setString(7, produtoAlterar.getMarca());
            comandoSQL.setInt(8, produtoAlterar.getId());
            //Finalmente... vamos executar o comando!
            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;

            }

        } catch (ClassNotFoundException ex) {
            retorno = false;
        } catch (SQLException ex) {
            retorno = false;
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

    public static boolean excluirProduto(int excProduto) { //Metódo para Excluir cliente do banco.
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        boolean retorno = false;

        try {
            //Carregando o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Abrindo conexão com o Banco
            conexao = DriverManager.getConnection(url, login, senha);

            //Preparar o comando SQL
            comandoSQL = conexao.prepareStatement("DELETE FROM produtos WHERE ID = ?");
            comandoSQL.setInt(1, excProduto);

            //Executar o comando SQL preparado
            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StreetClothingDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLIntegrityConstraintViolationException e) {
            Logger.getLogger("Ocorreu uma exceção de violação de integridade: " + e.getMessage());
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

    public static Produto buscarProduto(Produto busca, int idProduto) {

        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        ResultSet rs = null;

        try {
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Passo 2 - Abrir a conexao com o mysql
            conexao = DriverManager.getConnection(url, login, senha);

            //Passo 3 - Preparar o comando SQL
            comandoSQL = conexao.prepareStatement("SELECT * FROM Produtos WHERE id = ?");
            comandoSQL.setInt(1, idProduto);

            //Passo 4 - Executar o comando SQL
            rs = comandoSQL.executeQuery();

            if (rs != null) {

                //Percorrer as linhas do result set
                while (rs.next()) {
                    busca.setId(rs.getInt("ID"));
                    busca.setNome(rs.getString("NomeProduto"));
                    busca.setCategoria(rs.getString("Categoria"));
                    busca.setTamanho(rs.getString("Tamanho"));
                    busca.setUnidade(rs.getString("UnidadeMedida"));
                    busca.setEstoqueInicial(rs.getInt("Estoque"));
                    busca.setPrecoUnit(rs.getFloat("PrecoUnitario"));
                    busca.setMarca(rs.getString("Marca"));
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

        return busca;
    }

    public static Produto pesquisarProdutos(Produto pesquisar) {
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Passo 2 - Abrir a conexão com o banco
            conexao = DriverManager.getConnection(url, login, senha);

            //Passo 3 - Preparar o comando SQL a ser executado
            comandoSQL = conexao.prepareStatement("SELECT * FROM Produtos WHERE ID = ?");
            comandoSQL.setInt(1, pesquisar.getId());

            rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    //pesquisar.setNome(rs.getString("Nome"));
                    pesquisar.setNome(rs.getString("NomeProduto"));
                    pesquisar.setPrecoUnit(rs.getFloat("PrecoUnitario"));
                }

            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StreetClothingDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StreetClothingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pesquisar;
    }

    public static ArrayList<Produto> listarProduto() {

        ArrayList<Produto> lista = new ArrayList<>();

        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        ResultSet rs = null;

        try {
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Passo 2 - Abrir a conexao com o mysql
            conexao = DriverManager.getConnection(url, login, senha);

            //Passo 3 - Preparar o comando SQL
            comandoSQL = conexao.prepareStatement("SELECT * FROM Produtos");

            //Passo 4 - Executar o comando SQL
            rs = comandoSQL.executeQuery();

            if (rs != null) {

                //Percorrer as linhas do result set
                while (rs.next()) {
                    Produto item = new Produto();
                    item.setId(rs.getInt("ID"));
                    item.setNome(rs.getString("NomeProduto"));
                    item.setCategoria(rs.getString("Categoria"));
                    item.setEstoqueInicial(rs.getInt("Estoque"));
                    lista.add(item);

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

        return lista;
    }
    
    public static ArrayList<Produto> buscarPorCodigoProd(String buscaProd) {
        ArrayList<Produto> lista = new ArrayList<>();

        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        ResultSet rs = null;

        try {
            // Passo 1: Carregar o Drive
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Passo 2: Abri a conexão com o mySQL
            conexao = DriverManager.getConnection(url, login, senha);

            //Prepara o comando SQL
            comandoSQL = conexao.prepareStatement("SELECT * FROM produtos WHERE ID = ?");
            comandoSQL.setString(1, buscaProd);
            //Executa Comando SQL
            rs = comandoSQL.executeQuery();

            if (rs != null) {
                // Percorres as linhas do result set
                while (rs.next()) {
                    Produto item = new Produto();
                    item.setId(rs.getInt("ID"));
                    item.setNome(rs.getString("NomeProduto"));
                    item.setCategoria(rs.getString("Categoria"));
                    //item.setTamanho(rs.getString("Tamanho"));
                    item.setEstoqueInicial(rs.getInt("Estoque"));
                    //item.setUnidade(rs.getString("UnidadeMedida"));
                    //item.setPrecoUnit(rs.getFloat("PrecoUnitario"));
                    //item.setMarca(rs.getString("Marca"));

                    lista.add(item);
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

        return lista;
    }
    public static ArrayList<Produto> buscarPorNomeProd(String buscaProd) {
        ArrayList<Produto> lista = new ArrayList<>();

        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        ResultSet rs = null;

        try {
            // Passo 1: Carregar o Drive
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Passo 2: Abri a conexão com o mySQL
            conexao = DriverManager.getConnection(url, login, senha);

            //Prepara o comando SQL
            comandoSQL = conexao.prepareStatement("SELECT * FROM produtos WHERE NomeProduto = ?");
            comandoSQL.setString(1, buscaProd);
            //Executa Comando SQL
            rs = comandoSQL.executeQuery();

            if (rs != null) {
                // Percorres as linhas do result set
                while (rs.next()) {
                    Produto item = new Produto();
                    item.setId(rs.getInt("ID"));
                    item.setNome(rs.getString("NomeProduto"));
                    item.setCategoria(rs.getString("Categoria"));
                    item.setEstoqueInicial(rs.getInt("Estoque"));
                    

                    lista.add(item);
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

        return lista;
    }
}
