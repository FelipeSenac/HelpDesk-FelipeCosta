/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dos.helpdesk.bean;

import br.com.dos.helpdesk.dao.FabricanteDao;
import br.com.dos.helpdesk.dao.ModeloDao;
import br.com.dos.helpdesk.modelo.Fabricante;
import br.com.dos.helpdesk.modelo.Modelo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author sala302b
 */

@Named(value = "modeloMB")
@SessionScoped
public class ModeloMB extends AppMB implements Serializable {
    
    private List<Fabricante> listaFabricante;
    
    private List<Modelo> listaModelos;
    private Boolean addNovo = false;

    public List<Modelo> getListaModelos() {
        ModeloDao dao = new ModeloDao();

        if (listaModelos == null) {
            listaModelos = dao.buscarTodos();
        }
        if (listaModelos == null){
            listaModelos = new ArrayList<>();
            
        }
        if(listaModelos.isEmpty()||addNovo){
            listaModelos.add(new Modelo());
            addNovo=false;
        }
        

        

        return listaModelos;
    }
  

    public String excluir(Modelo modelo) {

        ModeloDao dao = new ModeloDao();
        dao.excluir(modelo);
        listaModelos.remove(modelo);
        return null;

    }

    public String salvar() {
        ModeloDao dao = new ModeloDao();
        dao.salvarLista(this.listaModelos);
        return null;

    }

    public String novo() {
        addNovo=true;
        return null;
        
    }
    
     public void setListaModelos(List<Modelo> listaModelos) {
        this.listaModelos = listaModelos;
    }

    public void setListaFabricante(List<Modelo> listaModelos) {
        this.listaModelos = listaModelos;
    }

    public List<Fabricante> getListaFabricante() {
        FabricanteDao fabricanteDao = new FabricanteDao();  
        return fabricanteDao.buscarTodos();
        
    }

    public Boolean getAddNovo() {
        return addNovo;
    }

    public void setAddNovo(Boolean addNovo) {
        this.addNovo = addNovo;
    }

   
    
}
