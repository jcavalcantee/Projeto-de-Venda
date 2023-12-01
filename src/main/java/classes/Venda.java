/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author jeffe
 */
public class Venda {
    
    private int idPedido;
    private int codCliente;
    private String nomeCliente;
    private int codProduto;
    private String nomeProduto;
    private int qtdeProduto;
    private double precoProduto;
    private double subTotal;
    private double totalVenda;
    private String dataVenda;
    private String pagamento;
    private int estoqueAtual;
    
    public Venda() {
        
    }


    public Venda(int codProduto, int qtdeProduto, double precoProduto, double subTotal, double totalVenda) {
        this.codProduto = codProduto;
        this.qtdeProduto = qtdeProduto;
        this.precoProduto = precoProduto;
        this.subTotal = subTotal;
        this.totalVenda = totalVenda;
    }

    public Venda(int codProduto, String nomeProduto, int qtdeProduto, double precoProduto, double subTotal, int estoqueAtual) {
        this.codProduto = codProduto;
        this.nomeProduto = nomeProduto;
        this.qtdeProduto = qtdeProduto;
        this.precoProduto = precoProduto;
        this.subTotal = subTotal;
        this.estoqueAtual = estoqueAtual;
    }

    public Venda(int idPedido, int codProduto, int qtdeProduto) {
        this.idPedido = idPedido;
        this.codProduto = codProduto;
        this.qtdeProduto = qtdeProduto;
    }

    public int getEstoqueAtual() {
        return estoqueAtual;
    }

    public void setEstoqueAtual(int estoqueAtual) {
        this.estoqueAtual = estoqueAtual;
    }
    
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    
    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public int getQtdeProduto() {
        return qtdeProduto;
    }

    public void setQtdeProduto(int qtdeProduto) {
        this.qtdeProduto = qtdeProduto;
    }

    public double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTotalVenda() {
        return totalVenda;
    }

    public void setTotalVenda(double totalVenda) {
        this.totalVenda = totalVenda;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }
    
    
}



