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

/**
 *
 * @author Lucas Gouveia
 */
public class StreetClothingDAO {

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

    /**
     * Metódo responsável por cadastrar um cliente no Banco de Dados.
     *
     * @param novoCliente Objeto do tipo Cliente
     * @return boolean - true: sucesso no cadastro, false: falha no cadastro
     * @throws SQLException Se ocorrer um erro durante a execução da operação no
     * banco de dados.
     * @throws ClassNotFoundException Se o driver JDBC não puder ser carregado.
     */
    public static boolean cadastrarCliente(Cliente novoCliente) { //Metódo para Cadastrar cliente no banco.

        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        boolean retorno = false;

        try {
            //Carregando o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Abrir conexão com o banco
            conexao = DriverManager.getConnection(url, login, senha);

            //Preparar o comando a ser executado
            comandoSQL = conexao.prepareStatement("INSERT INTO Clientes (CPF, Nome, DataNascimento, Sexo, Telefone, E_mail, Estado_Civil, Logradouro, Numero,"
                    + "Cidade, UF) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            comandoSQL.setString(1, novoCliente.getCpf());
            comandoSQL.setString(2, novoCliente.getNome());
            if(novoCliente.getDataNascimento() != null) {
                comandoSQL.setDate(3, new java.sql.Date(novoCliente.getDataNascimento().getTime()));
            } else {
                comandoSQL.setDate(3, null);
            }
            comandoSQL.setString(4, Character.toString(novoCliente.getSexo()));
            comandoSQL.setString(5, novoCliente.getTelefone());
            comandoSQL.setString(6, novoCliente.getEmail());
            comandoSQL.setString(7, novoCliente.getEstCivil());
            comandoSQL.setString(8, novoCliente.getLogradouro());
            comandoSQL.setString(9, String.valueOf(novoCliente.getNumero()));
            comandoSQL.setString(10, novoCliente.getCidade());
            comandoSQL.setString(11, novoCliente.getUf());

            //Executando o comando preparado
            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StreetClothingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  catch (SQLIntegrityConstraintViolationException e) {
          e.printStackTrace();
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

    /**
     * Método responsável por Excluir um cliente cadastrado do Banco de Dados.
     *
     * @param excCliente O ID do cliente a ser excluído
     * @return boolean - true: sucesso na exclusão, false: falha na exclusão
     * @throws SQLException Se ocorrer um erro durante a execução da operação no
     * banco de dados.
     * @throws ClassNotFoundException Se o driver JDBC não puder ser carregado.
     */
    public static boolean excluirCliente(int excCliente) { //Metódo para Excluir cliente do banco.
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        boolean retorno = false;

        try {
            //Carregando o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Abrindo conexão com o Banco
            conexao = DriverManager.getConnection(url, login, senha);

            //Preparar o comando SQL
            comandoSQL = conexao.prepareStatement("DELETE FROM Clientes WHERE ID = ?");
            comandoSQL.setInt(1, excCliente);

            //Executar o comando SQL preparado
            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StreetClothingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLIntegrityConstraintViolationException e) {
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

    public static ArrayList<Cliente> listarCliente() {

        ArrayList<Cliente> lista = new ArrayList<>();

        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        ResultSet rs = null;

        try {
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Passo 2 - Abrir a conexao com o mysql
            conexao = DriverManager.getConnection(url, login, senha);

            //Passo 3 - Preparar o comando SQL
            comandoSQL = conexao.prepareStatement("SELECT * FROM Clientes");

            //Passo 4 - Executar o comando SQL
            rs = comandoSQL.executeQuery();

            if (rs != null) {

                //Percorrer as linhas do result set
                while (rs.next()) {
                    Cliente item = new Cliente();
                    item.setIdCliente(rs.getInt("ID"));
                    item.setCpf(rs.getString("CPF"));
                    item.setNome(rs.getString("Nome"));
                    item.setEmail(rs.getString("E_mail"));
                    item.setLogradouro(rs.getString("Logradouro"));

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

    public static Cliente buscarCliente(Cliente busca, int idCliente) {

        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        ResultSet rs = null;

        try {
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Passo 2 - Abrir a conexao com o mysql
            conexao = DriverManager.getConnection(url, login, senha);

            //Passo 3 - Preparar o comando SQL
            comandoSQL = conexao.prepareStatement("SELECT * FROM Clientes WHERE id = ?");
            comandoSQL.setInt(1, idCliente);

            //Passo 4 - Executar o comando SQL
            rs = comandoSQL.executeQuery();

            if (rs != null) {

                //Percorrer as linhas do result set
                while (rs.next()) {
                    busca.setIdCliente(rs.getInt("ID"));
                    busca.setCpf(rs.getString("CPF"));
                    busca.setNome(rs.getString("Nome"));
                    busca.setEmail(rs.getString("E_mail"));
                    busca.setLogradouro(rs.getString("Logradouro"));
                    busca.setDataNascimento(rs.getDate("DataNascimento"));
                    busca.setSexo(rs.getString("Sexo").charAt(0));
                    busca.setTelefone(rs.getString("Telefone"));
                    busca.setEstCivil(rs.getString("Estado_Civil"));
                    busca.setNumero(rs.getInt("Numero"));
                    busca.setCidade(rs.getString("Cidade"));
                    busca.setUf(rs.getString("UF"));

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
     public static Produto buscarProduto (Produto busca, int idProduto) {

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

     public static boolean alterarCliente(Cliente clienteAlterar) {

        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement comandoSQL = null;

        try {
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Passo 2 - Abrir a conexão com o banco
            conexao = DriverManager.getConnection(url, login, senha);

            //Passo 3 - Preparar o comando SQL a ser executado
            comandoSQL = conexao.prepareStatement("UPDATE Clientes SET CPF = ?, Nome = ?, DataNascimento = ?, Sexo = ?, Telefone = ?,"
                    + " E_mail = ?, Estado_Civil = ?, Logradouro = ?, Numero = ?, Cidade = ?, UF = ? WHERE ID = ? ");

            comandoSQL.setString(1, clienteAlterar.getCpf());
            comandoSQL.setString(2, clienteAlterar.getNome());
            if(clienteAlterar.getDataNascimento() != null) {
                comandoSQL.setDate(3, new java.sql.Date(clienteAlterar.getDataNascimento().getTime()));
            } else {
                comandoSQL.setDate(3, null);
            }
            comandoSQL.setString(4, Character.toString(clienteAlterar.getSexo()));
            comandoSQL.setString(5, clienteAlterar.getTelefone());
            comandoSQL.setString(6, clienteAlterar.getEmail());
            comandoSQL.setString(7, clienteAlterar.getEstCivil());
            comandoSQL.setString(8, clienteAlterar.getLogradouro());
            comandoSQL.setInt(9, clienteAlterar.getNumero());
            comandoSQL.setString(10, clienteAlterar.getCidade());
            comandoSQL.setString(11, clienteAlterar.getUf());
            comandoSQL.setInt(12, clienteAlterar.getIdCliente());

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

    public static Cliente pesquisarClientes(Cliente pesquisar) {
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Passo 2 - Abrir a conexão com o banco
            conexao = DriverManager.getConnection(url, login, senha);

            //Passo 3 - Preparar o comando SQL a ser executado
            comandoSQL = conexao.prepareStatement("SELECT Nome, ID FROM Clientes WHERE cpf = ?");
            comandoSQL.setString(1, pesquisar.getCpf());

            rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    pesquisar.setNome(rs.getString("Nome"));
                    pesquisar.setIdCliente(rs.getInt("ID"));
                }

            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StreetClothingDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StreetClothingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pesquisar;
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
    //Método Alterar
   

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
     public static ArrayList<Produto> buscarPorCodigoProd(String buscaProcessador){
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
            comandoSQL= conexao.prepareStatement("SELECT  * FROM produtos WHERE ID = ?");
            comandoSQL.setString(1, buscaProcessador);
            //Executa Comando SQL
            rs = comandoSQL.executeQuery();
            
            if(rs != null){
                // Percorres as linhas do result set
                while(rs.next()){
                    Produto item = new Produto();
                    item.setId(rs.getInt("ID"));
                    item.setNome(rs.getString("NomeProduto"));
                    item.setCategoria(rs.getString("Categoria"));
                    item.setTamanho(rs.getString("Tamanho"));
                     item.setEstoqueInicial(rs.getInt("Estoque"));
                    item.setUnidade(rs.getString("UnidadeMedida"));
                    item.setPrecoUnit(rs.getFloat("PrecoUnitario"));
                    item.setMarca(rs.getString("Marca"));
                    
                    lista.add(item);
                }
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StreetClothingDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StreetClothingDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexao != null){
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StreetClothingDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return lista;
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
    
    public static ArrayList<Venda> gerarRelatorio(LocalDate dataInicial, LocalDate dataFinal) {
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
             comandoSQL = connection.prepareStatement("SELECT " +
                                                                                               "PEDIDO.ID_Pedido AS idpedido, " +
                                                                                               "CLIENTES.ID AS idcliente, " +
                                                                                               "CLIENTES.Nome AS nomecliente, " +
                                                                                               "PRODUTOS.NomeProduto AS nomeproduto, " +
                                                                                               "MAX(ITEMPEDIDO.Quantidade) AS quantidade, " +
                                                                                               "PRODUTOS.PrecoUnitario AS precounitario, " +
//                                                                                               "COALESCE(ROUND(SUM(CAST(quantidade AS DECIMAL(10,2)) * CAST(precounitario AS DECIMAL(10,2))), 2), 0) AS subtotal, " +
//                                                                                               "COALESCE(ROUND(SUM(ITEMPEDIDO.Quantidade * PRODUTOS.PrecoUnitario), 2), 0) AS subtotal, " +
//                                                                                               "ROUND(SUM(quantidade * precounitario), 2) AS subtotal, " +
                                                                                               "PEDIDO.DataPedido AS datapedido, " +
                                                                                               "PEDIDO.FormaPagamento AS formapagamento " +
                                                                                            "FROM " +
                                                                                                "CLIENTES " +
                                                                                            "INNER JOIN " +
                                                                                                "PEDIDO ON CLIENTES.ID = PEDIDO.FK_CLIENTES_ID " +
                                                                                            "INNER JOIN " +
                                                                                                "ITEMPEDIDO ON PEDIDO.ID_Pedido = ITEMPEDIDO.FK_PEDIDO_ID_Pedido " +
                                                                                            "INNER JOIN " +
                                                                                                "PRODUTOS ON ITEMPEDIDO.FK_PRODUTOS_ID = PRODUTOS.ID " +
                                                                                            "WHERE " +
                                                                                                "PEDIDO.DataPedido BETWEEN ? AND ? " +
                                                                                            "GROUP BY " +
                                                                                                "CLIENTES.ID, " +
                                                                                                "PEDIDO.ID_Pedido, " +
                                                                                                "PRODUTOS.ID;");

            //passa as datas selecionas em "LocalDate" para o formato "java.sql.Date" aceito pelo JDBC
            java.sql.Date sqlDataInicial = java.sql.Date.valueOf(dataInicial);
            java.sql.Date sqlDataFinal = java.sql.Date.valueOf(dataFinal);
            
            comandoSQL.setDate(1, sqlDataInicial);
            comandoSQL.setDate(2, sqlDataFinal);
            
            //executar comando sql
            rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Venda itemVenda = new Venda(
                            rs.getInt("idpedido"), 
                            rs.getInt("idcliente"), 
                            rs.getString("nomecliente"), 
                            rs.getString("nomeproduto"),
                            rs.getInt("quantidade"),
                            rs.getDouble("precounitario"),
//                            rs.getDouble("subtotal"),
                            rs.getString("datapedido"),
                            rs.getString("formapagamento"));
                   
                    list.add(itemVenda);
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
}
