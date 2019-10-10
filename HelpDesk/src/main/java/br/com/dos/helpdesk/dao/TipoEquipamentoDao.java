/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dos.helpdesk.dao;


import br.com.dos.helpdesk.modelo.TipoEquipamento;
import java.util.List;

/**
 *
 * @author sala302b
 */
public class TipoEquipamentoDao extends AppDao<TipoEquipamento>{
    
    public TipoEquipamentoDao(){
        super (TipoEquipamento.class);
    }
    
     public void salvarLista(List<TipoEquipamento> listaTipoEquipamentos) {
        for (TipoEquipamento tipoEquipamento : listaTipoEquipamentos) {
            System.out.println("TipoEquipamento: " + tipoEquipamento.getNome());
            if (tipoEquipamento.getNome()== null || tipoEquipamento.getNome().isEmpty()) {
                continue;
            }
            if (tipoEquipamento.getId() != null && tipoEquipamento.getId() > 0) {
//atualizar
                System.out.println("inseriu");
                super.atualizar(tipoEquipamento);
            } else {
                System.out.println("inseriu");
                super.inserir(tipoEquipamento);
            }
        }
    }
    
}
