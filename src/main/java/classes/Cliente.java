/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.util.Date;

/**
 *
 * @author jeffe
 */
public class Cliente {
    
    private String nome;
    private Date dataNascimento;
    private String cpf;
    private char sexo;
    private String telefone;
    private String email;
    private String estCivil;
    private String logradouro;
    private int numero;
    private String cidade;
    private String uf;
    private int idCliente;

    public Cliente() {
        
    }
    
    
    //Construtor com os dados obrigatórios para cadastro de clientes.
    public Cliente(String nome, String cpf, char sexo, String email, String logradouro) {
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.email = email;
        this.logradouro = logradouro;
    }
    //Construtor com os demais atributos "não obrigatórios".
    public Cliente(Date dataNascimento, String telefone, String estCivil, int numero, String cidade, String uf) {
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.estCivil = estCivil;
        this.numero = numero;
        this.cidade = cidade;
        this.uf = uf;
    }

    //Gerado construtor com todos os parametros para utilização no cadastro de cliente;
    public Cliente(String cpf, String nome, Date dataNascimento, char sexo, String telefone, String email, String estCivil, String logradouro, int numero, String cidade, String uf) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.sexo = sexo;
        this.telefone = telefone;
        this.email = email;
        this.estCivil = estCivil;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cidade = cidade;
        this.uf = uf;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstCivil() {
        return estCivil;
    }

    public void setEstCivil(String estCivil) {
        this.estCivil = estCivil;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
