/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prototipos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author Lucas Gouveia
 */
public class Validador {

    public ArrayList<String> mensagensErro = new ArrayList<>();

    public void validarNumero(JTextField txt) {

        try {

            //Verifico se o campo está vazio
            if (txt.getText().replace(".", "").replaceAll("-", "").trim().equals("")) {
                throw new IllegalArgumentException();
            }
            int number = Integer.parseInt(txt.getText());

        } catch (NumberFormatException e) {
            this.mensagensErro.add("Falha ao converter o valor do campo " + txt.getName() + " em inteiro");
            txt.setText("");
            txt.setBackground(Color.red);

        } catch (IllegalArgumentException e) {
            this.mensagensErro.add("O campo " + txt.getName() + " não deve ficar em branco!");
            txt.setBackground(Color.red);
        }

    }

    public void validarTexto(JTextField txt) {

        try {

            //Verifico se o campo está vazio
            if (txt.getText().replace(".", "").replaceAll("-", "").trim().equals("")) {
                throw new IllegalArgumentException();
            }

            txt.setBackground(Color.white);

        } catch (IllegalArgumentException e) {
            this.mensagensErro.add("O campo " + txt.getName() + " não deve ficar em branco!");
            txt.setBackground(Color.red);
        }

    }

    public void limparMensagens() {

        this.mensagensErro.clear();
    }

    public void limparMensagens(JTextField txt) {
        txt.setText("");
    }

    public String getMensagensErro() {

        String errosFormulario = "";

        //Percorro o arrayList e concateno na variável errosFormulario
        for (String msg : this.mensagensErro) {
            errosFormulario += msg + "\n";
        }

        if (!errosFormulario.equals("")) {
            this.limparMensagens();
        }

        return errosFormulario;

    }

    public boolean hasErro() {

        if (this.mensagensErro.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void limiteTexto(JTextField txt, java.awt.event.KeyEvent evt, int x) {
        //Limitando caracteres;
        try {
            if (txt.getText().length() >= x) {
                evt.consume();
            }
        } catch (Exception e) {
            this.mensagensErro.add("O limite de caracteres para este campo é de " + x + " caracteres.");
            txt.setBackground(Color.red);
        }
    }

    public void textoSemNumeros(JTextField txt, java.awt.event.KeyEvent evt) {
        //Restringindo números no preenchimento do campo
        try {
            char c = evt.getKeyChar();
            if (c >= '0' && c <= '9') {
                evt.consume();
            }
        } catch (Exception e) {
            this.mensagensErro.add("Este campo não aceita números, digite novamente!");
            txt.setBackground(Color.red);
        }
    }
    public void MinNumero(KeyEvent e) {
        char c = e.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            e.consume(); // Isso impede que caracteres não numéricos sejam digitados
        }
    }
    public void validarCPF(JTextField txt) {
        try {

            //Verifico se o campo está vazio
            if (txt.getText().replace(".", "").replaceAll("-", "").trim().equals("")) {
                throw new IllegalArgumentException();
            }

            txt.setBackground(Color.white);

        } catch (IllegalArgumentException e) {
            this.mensagensErro.add("O campo " + txt.getName() + " não deve ficar em branco e deve conter 11 números!");
            txt.setBackground(Color.red);
        }
    }

    void limiteTexto(JTextField txtNome, ActionEvent evt, int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void textoSemNumeros(JTextField txtNome, ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    void comboBox(JComboBox<String> jcb) {
        int index = jcb.getSelectedIndex();
        if (index == 0){
           this.mensagensErro.add("Selecione uma opção valida no campo: " + jcb.getName());
        }
    }
}
