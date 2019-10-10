/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dos.helpdesk.modelo;

/**
 *
 * @author sala302b
 */
public enum Status {
    
    ABT("Aberto"),
    PED("Pendente"),
    ATD("Em atendimento"),
    FCH("fechado");

    private String valor;  
      
    private Status(String valor) {  
        this.valor = valor;  
    }  

    @Override
    public String toString() {
        return valor;
    }
    
}
