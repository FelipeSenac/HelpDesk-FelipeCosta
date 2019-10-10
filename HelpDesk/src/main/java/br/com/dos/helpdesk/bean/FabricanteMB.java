/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dos.helpdesk.bean;

import br.com.dos.helpdesk.dao.FabricanteDao;
import br.com.dos.helpdesk.modelo.Fabricante;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author sala302b
 */
@Named(value = "fabricanteMB")
@SessionScoped
public class FabricanteMB extends AppMB implements Serializable {
    
    private List<Fabricante> listaFabricante;
    private Boolean addNovo = false;

    public List<Fabricante> getListaFabricante() {
        FabricanteDao dao = new FabricanteDao();

        if (listaFabricante == null) {
            listaFabricante = dao.buscarTodos();
        }
        if (listaFabricante == null){
            listaFabricante = new ArrayList<>();
            
        }
        if(listaFabricante.isEmpty()||addNovo){
            listaFabricante.add(new Fabricante());
            addNovo=false;
        }
        

        

        return listaFabricante;
    }

   
    

    public String excluir(Fabricante fabricante) {

        FabricanteDao dao = new FabricanteDao();
        dao.excluir(fabricante);
        listaFabricante.remove(fabricante);
        return null;

    }

    public String salvar() {
        FabricanteDao dao = new FabricanteDao();
        dao.salvarLista(this.listaFabricante);
        return null;

    }

    public String novo() {
        addNovo=true;
        return null;
        
    }

    public void setListaFabricante(List<Fabricante> listaFabricante) {
        this.listaFabricante = listaFabricante;
    }
}
