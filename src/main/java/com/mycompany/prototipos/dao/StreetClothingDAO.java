/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prototipos.dao;

import classes.Cliente;
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
 * @author Lucas Gouveia
 */
public class StreetClothingDAO {

    static String url = "jdbc:mysql://localhost:3306/StreetClothing";
    static String login = "StreetClothing";
    static String senha = "psc@2*";

    public static boolean cadastrarCliente(Cliente novoCliente) {

        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        boolean retorno = false;

        try {
            //Carregando o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Abrir conexão com o banco
            conexao = DriverManager.getConnection(url, login, senha);

            //Preparar o comando a ser executado
            comandoSQL = conexao.prepareStatement("INSERT INTO Clientes (CPF, Nome, E_mail, Rua, DataNascimento, Sexo, Telefone, "
                    + "Estado_Civil, numero, Cidade, UF) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            comandoSQL.setString(1, novoCliente.getCpf());
            comandoSQL.setString(2, novoCliente.getNome());
            comandoSQL.setString(3, novoCliente.getDataNascimento());
            comandoSQL.setString(4, Character.toString(novoCliente.getSexo()));
            comandoSQL.setInt(5, novoCliente.getTelefone());
            comandoSQL.setString(6, novoCliente.getEmail());
            comandoSQL.setString(7, novoCliente.getEstCivil());
            comandoSQL.setString(8, novoCliente.getLogradouro());
            comandoSQL.setString(9, novoCliente.getCidade());
            comandoSQL.setString(10, novoCliente.getUf());

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
                    item.setCpf(rs.getString("CPF"));
                    item.setNome(rs.getString("Nome"));
                    item.setEmail(rs.getString("E_mail"));
                    item.setLogradouro(rs.getString("Rua"));

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

    //Método Alterar
    public static boolean alterarCliente(Cliente clienteAlterar) {

        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        ResultSet rs = null;

        try {
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Passo 2 - Abrir a conexão com o banco
            conexao = DriverManager.getConnection(url, login, senha);

            //Passo 3 - Preparar o comando SQL a ser executado
            comandoSQL = conexao.prepareStatement("UPDATE Clientes SET CPF = ?, Nome = ?, E_mail = ?, Rua = ? WHERE ID = ? ");

            comandoSQL.setString(1, clienteAlterar.getCpf());
            comandoSQL.setString(2, clienteAlterar.getNome());
            comandoSQL.setString(3, clienteAlterar.getEmail());
            comandoSQL.setString(4, clienteAlterar.getLogradouro());
            comandoSQL.setInt(5, clienteAlterar.getIdCliente());

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
}
