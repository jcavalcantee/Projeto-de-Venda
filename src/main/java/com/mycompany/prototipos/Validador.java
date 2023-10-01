/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prototipos;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author Lucas Gouveia
 */
public class Validador {
    
    public ArrayList<String> mensagensErro = new ArrayList<>();
    
    public void validarNumero(JTextField txt){
    
        try{
            
            //Verifico se o campo está vazio
            if(txt.getText().trim().equals("")){
                throw new IllegalArgumentException();
            }
            
            int valorConvertido = Integer.parseInt(txt.getText());
            txt.setBackground(Color.WHITE);
            
        }catch(NumberFormatException e){
        
            this.mensagensErro.add("Falha ao converter o valor do campo " + txt.getName() + " em inteiro");
            txt.setText("");
            txt.setBackground(Color.red);
        }catch(IllegalArgumentException e){
            this.mensagensErro.add("Digite um valor para o campo " + txt.getName());
            txt.setBackground(Color.red);
        }
    
    }
    
    public void ValidarTexto(JTextField txt){
    
        try{
            
            //Verifico se o campo está vazio
            if(txt.getText().replace(".","").replaceAll("-", "").trim().equals("")){
                throw new IllegalArgumentException();
            }
             
            txt.setBackground(Color.white);
            
        }catch(IllegalArgumentException e){
            this.mensagensErro.add("Digite um valor para o campo " + txt.getName());
            txt.setBackground(Color.red);
        }

    }
    
    public void limparMensagens(){
     
         this.mensagensErro.clear();
     }
    
    public void limparMensagens(JTextField txt){
        txt.setText("15");
    }
    
    public String getMensagensErro(){
         
        String errosFormulario = "";
        
        //Percorro o arrayList e concateno na variável errosFormulario
        for (String msg : this.mensagensErro) {
            errosFormulario += msg + "\n";
        }
        
        if(!errosFormulario.equals("")){
            this.limparMensagens();
        }     
        
        return errosFormulario;
        
     }
    
    public boolean hasErro(){
     
         if(this.mensagensErro.size()>0){
            return true;    
         }else{
             return false;
         }
     }
}
