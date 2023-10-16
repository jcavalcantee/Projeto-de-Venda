/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author jeffe
 */
public class RelatorioSintetico {
    
    private int cliente;
    private String dataCompra;
    private double subTotal;

    public RelatorioSintetico() {
        
    }

    public RelatorioSintetico(int cliente, String dataCompra, double subTotal) {
        this.cliente = cliente;
        this.dataCompra = dataCompra;
        this.subTotal = subTotal;
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

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
    
    
}
