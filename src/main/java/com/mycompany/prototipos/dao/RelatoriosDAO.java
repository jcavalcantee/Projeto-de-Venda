
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prototipos.dao;

import classes.Venda;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jeffe
 */
public class RelatoriosDAO {

    static String url = "jdbc:mysql://localhost:3306/StreetClothing";
    static String login = "StreetClothing";
    static String senha = "psc@2*";

    public static ArrayList<Venda> gerarRelatorioSintetico(LocalDate dataInicial, LocalDate dataFinal) {
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
            comandoSQL = connection.prepareStatement("SELECT "
                    + "CLIENTES.ID AS idcliente, "
                    + "CLIENTES.Nome AS nomecliente, "
                    + "PEDIDO.ID_Pedido AS idpedido, "
                    + "PEDIDO.DataPedido AS datapedido, "
                    + "COALESCE(SUM(ROUND(ITEMPEDIDO.Quantidade * PRODUTOS.PrecoUnitario, 2)), 0) AS total_pedido "
                    + "FROM "
                    + "CLIENTES "
                    + "INNER JOIN "
                    + "PEDIDO ON CLIENTES.ID = PEDIDO.FK_CLIENTES_ID "
                    + "INNER JOIN "
                    + "ITEMPEDIDO ON PEDIDO.ID_Pedido = ITEMPEDIDO.FK_PEDIDO_ID_Pedido "
                    + "INNER JOIN "
                    + "PRODUTOS ON ITEMPEDIDO.FK_PRODUTOS_ID = PRODUTOS.ID "
                    + "WHERE "
                    + "PEDIDO.DataPedido BETWEEN ? AND ? "
                    + "GROUP BY "
                    + "CLIENTES.ID, "
                    + "PEDIDO.ID_Pedido, "
                    + "PEDIDO.DataPedido;");

            //passa as datas selecionas em "LocalDate" para o formato "java.sql.Date" aceito pelo JDBC
            java.sql.Date sqlDataInicial = java.sql.Date.valueOf(dataInicial);
            java.sql.Date sqlDataFinal = java.sql.Date.valueOf(dataFinal);

            comandoSQL.setDate(1, sqlDataInicial);
            comandoSQL.setDate(2, sqlDataFinal);

            //executar comando sql
            rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Venda relatorio = new Venda();

                    relatorio.setCodCliente(rs.getInt("idcliente"));
                    relatorio.setNomeCliente(rs.getString("nomecliente"));
                    relatorio.setIdPedido(rs.getInt("idpedido"));
                    relatorio.setDataVenda(rs.getString("datapedido"));
                    double totalVenda = rs.getDouble("total_pedido");
                    double totalVendaArredondado = Math.round(totalVenda * Math.pow(10, 2)) / Math.pow(10, 2);
                    relatorio.setTotalVenda(totalVendaArredondado);

                    list.add(relatorio);
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

    public static ArrayList<Venda> gerarRelatorioAnalitico(Venda dadosVenda) {
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
            comandoSQL = connection.prepareStatement("SELECT "
                    + "PRODUTOS.NomeProduto AS nomeproduto, "
                    + "ITEMPEDIDO.Quantidade AS quantidade, "
                    + "PRODUTOS.PrecoUnitario AS precounitario, "
                    + "PEDIDO.FormaPagamento AS formapagamento "
                    + "FROM "
                    + "CLIENTES "
                    + "INNER JOIN "
                    + "PEDIDO ON CLIENTES.ID = PEDIDO.FK_CLIENTES_ID "
                    + "INNER JOIN "
                    + "ITEMPEDIDO ON PEDIDO.ID_Pedido = ITEMPEDIDO.FK_PEDIDO_ID_Pedido "
                    + "INNER JOIN "
                    + "PRODUTOS ON ITEMPEDIDO.FK_PRODUTOS_ID = PRODUTOS.ID "
                    + "WHERE "
                    + "CLIENTES.ID = ? AND PEDIDO.ID_Pedido = ?;");

            comandoSQL.setInt(1, dadosVenda.getCodCliente());
            comandoSQL.setInt(2, dadosVenda.getIdPedido());

            //executar comando sql
            rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Venda relatorioAnalitico = new Venda();

                    relatorioAnalitico.setNomeProduto(rs.getString("nomeproduto"));
                    relatorioAnalitico.setQtdeProduto(rs.getInt("quantidade"));
                    relatorioAnalitico.setPrecoProduto(rs.getDouble("precounitario"));
                    relatorioAnalitico.setPagamento(rs.getString("formapagamento"));

                    list.add(relatorioAnalitico);
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
