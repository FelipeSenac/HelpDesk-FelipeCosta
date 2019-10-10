/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dos.helpdesk.dao;

import br.com.dos.helpdesk.modelo.Fabricante;
import br.com.dos.helpdesk.modelo.Modelo;
import java.util.List;

/**
 *
 * @author sala302b
 */
public class ModeloDao extends AppDao<Modelo>{
    
   
    public ModeloDao(){
        super (Modelo.class);
    }
    
     public void salvarLista(List<Modelo> listaModelos) {
        for (Modelo modelo : listaModelos) {
            System.out.println("Modelo: " + modelo.getNome());
            if (modelo.getNome()== null || modelo.getNome().isEmpty()) {
                continue;
            }
            if (modelo.getId() != null && modelo.getId() > 0) {
//atualizar
                System.out.println("inseriu");
                super.atualizar(modelo);
            } else {
                System.out.println("inseriu");
                super.inserir(modelo);
            }
        }
    }
    
}
