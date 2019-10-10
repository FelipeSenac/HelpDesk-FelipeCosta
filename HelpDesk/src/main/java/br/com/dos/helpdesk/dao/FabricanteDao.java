/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dos.helpdesk.dao;

import br.com.dos.helpdesk.modelo.Fabricante;
import java.util.List;

/**
 *
 * @author sala302b
 */
public class FabricanteDao extends AppDao<Fabricante> {

    public FabricanteDao() {
        super(Fabricante.class);
    }

    public void salvarLista(List<Fabricante> listaFabricante) {
        for (Fabricante fabricante : listaFabricante) {
            System.out.println("Fabricante: " + fabricante.getNome());
            if (fabricante.getNome() == null || fabricante.getNome().isEmpty()) {
                continue;
            }
            if (fabricante.getId() != null && fabricante.getId() > 0) {
//atualizar
                System.out.println("inseriu");
                super.atualizar(fabricante);
            } else {
                System.out.println("inseriu");
                super.inserir(fabricante);
            }
        }
    }

}
