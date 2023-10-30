/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

public class RelatorioAnalitico {
    
    private int cliente;
    private String dataCompra;
    private String produtos;
    private int quantidade;
    private double subtotal;

    public RelatorioAnalitico() {
        
    }

    public RelatorioAnalitico(int cliente, String dataCompra, String produtos, int quantidade, double subtotal) {
        this.cliente = cliente;
        this.dataCompra = dataCompra;
        this.produtos = produtos;
        this.quantidade = quantidade;
        this.subtotal = subtotal;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getProdutos() {
        return produtos;
    }

    public void setProdutos(String produtos) {
        this.produtos = produtos;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
    
    
}
