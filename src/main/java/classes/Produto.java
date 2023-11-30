/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author jeffe
 */
public class Produto {
    
    private int id;
    private String nome;
    private String categoria;
    private String tamanho;
    private String unidade;
    private int estoqueInicial;
    private String marca;
    private float precoUnit;
    private double subtotal;

    public Produto() {

    }

    //Construtor com os dados obrigatórios para cadastro de cliente.
    public Produto(String nome, String categoria, String unidade, float precoUnit) {
        this.nome = nome;
        this.categoria = categoria;
        this.unidade = unidade;
        this.precoUnit = precoUnit;
    }

    //Construtor com os demais atributos "não obrigatórios".
    public Produto(int estoqueInicial, String marca) {
        this.estoqueInicial = estoqueInicial;
        this.marca = marca;
    }

    public Produto(String nome, String categoria, String tamanho, String unidade, int estoqueInicial, String marca, float precoUnit) {
        this.nome = nome;
        this.categoria = categoria;
        this.tamanho = tamanho;
        this.unidade = unidade;
        this.estoqueInicial = estoqueInicial;
        this.marca = marca;
        this.precoUnit = precoUnit;
    }
    public Produto(String nome, String categoria, String tamanho, String unidade, int estoqueInicial, String marca, float precoUnit, int id) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.tamanho = tamanho;
        this.unidade = unidade;
        this.estoqueInicial = estoqueInicial;
        this.marca = marca;
        this.precoUnit = precoUnit;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public int getEstoqueInicial() {
        return estoqueInicial;
    }

    public void setEstoqueInicial(int estoqueInicial) {
        this.estoqueInicial = estoqueInicial;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getPrecoUnit() {
        return precoUnit;
    }

    public void setPrecoUnit(float precoUnit) {
        this.precoUnit = precoUnit;
    }
}
