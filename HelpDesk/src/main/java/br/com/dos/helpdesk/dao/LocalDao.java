/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dos.helpdesk.dao;


import br.com.dos.helpdesk.modelo.Local;
import java.util.List;

/**
 *
 * @author sala302b
 */
public class LocalDao extends AppDao<Local>{
    
    public LocalDao(){
        super (Local.class);
    }
    
     public void salvarLista(List<Local> listaLocals) {
        for (Local local : listaLocals) {
            System.out.println("Local: " + local.getNome());
            if (local.getNome()== null || local.getNome().isEmpty()) {
                continue;
            }
            if (local.getId() != null && local.getId() > 0) {
//atualizar
                System.out.println("inseriu");
                super.atualizar(local);
            } else {
                System.out.println("inseriu");
                super.inserir(local);
            }
        }
    }
    
}
