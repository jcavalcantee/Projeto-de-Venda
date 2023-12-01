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
public class ClientesDAO {

    static String url = "jdbc:mysql://localhost:3306/StreetClothing";
    static String login = "StreetClothing";
    static String senha = "psc@2*";

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
            if (novoCliente.getDataNascimento() != null) {
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
        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Esse CPF já foi cadastrado!", "CPF CADASTRADO", JOptionPane.WARNING_MESSAGE);
            Logger.getLogger("CPF Duplicado");
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
            if (clienteAlterar.getDataNascimento() != null) {
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
    
    public static ArrayList<Cliente> buscarPorCPFCliente(String buscaCliente){
        ArrayList<Cliente> lista = new ArrayList<>();
        
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        ResultSet rs = null;
        
        try {
            // Passo 1: Carregar o Drive
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Passo 2: Abri a conexão com o mySQL
            conexao = DriverManager.getConnection(url, login, senha);
            
            //Prepara o comando SQL
            comandoSQL= conexao.prepareStatement("SELECT * FROM Clientes WHERE CPF = ?");
            comandoSQL.setString(1, buscaCliente);
            //Executa Comando SQL
            rs = comandoSQL.executeQuery();
            
            if (rs != null){
                // Percorres as linhas do result set
                while(rs.next()){
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

}
