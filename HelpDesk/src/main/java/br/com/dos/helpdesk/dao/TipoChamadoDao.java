/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dos.helpdesk.dao;

import br.com.dos.helpdesk.modelo.TipoChamado;

import java.util.List;

/**
 *
 * @author sala302b
 */
public class TipoChamadoDao extends AppDao<TipoChamado>{
    
    public TipoChamadoDao(){
        super (TipoChamado.class);
    }
    
    public void salvarLista(List<TipoChamado> listaTipoChamados) {
        for (TipoChamado tipoChamado : listaTipoChamados) {
            System.out.println("TipoChamado: " + tipoChamado.getNome());
            if (tipoChamado.getNome()== null || tipoChamado.getNome().isEmpty()) {
                continue;
            }
            if (tipoChamado.getId() != null && tipoChamado.getId() > 0) {
//atualizar
                System.out.println("inseriu");
                super.atualizar(tipoChamado);
            } else {
                System.out.println("inseriu");
                super.inserir(tipoChamado);
            }
        }
    }
    
    
}
