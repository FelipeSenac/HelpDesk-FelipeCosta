/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dos.helpdesk.bean;

import br.com.dos.helpdesk.dao.TipoChamadoDao;
import br.com.dos.helpdesk.modelo.TipoChamado;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author sala302b
 */

@Named(value = "tipoChamadoMB")
@SessionScoped
public class TipoChamadoMB extends AppMB implements Serializable {
    
     private List<TipoChamado> listaTipoChamados;
    private Boolean addNovo = false;

    public List<TipoChamado> getListaTipoChamados() {
        TipoChamadoDao dao = new TipoChamadoDao();

        if (listaTipoChamados == null) {
            listaTipoChamados = dao.buscarTodos();
        }
        if (listaTipoChamados == null){
            listaTipoChamados = new ArrayList<>();
            
        }
        if(listaTipoChamados.isEmpty()||addNovo){
            listaTipoChamados.add(new TipoChamado());
            addNovo=false;
        }
        

        

        return listaTipoChamados;
    }

   
    

    public String excluir(TipoChamado tipoChamado) {

        TipoChamadoDao dao = new TipoChamadoDao();
        dao.excluir(tipoChamado);
        listaTipoChamados.remove(tipoChamado);
        return null;

    }

    public String salvar() {
        TipoChamadoDao dao = new TipoChamadoDao();
        dao.salvarLista(this.listaTipoChamados);
        return null;

    }

    public String novo() {
        addNovo=true;
        return null;
        
    }


    public void setListaTipoChamados(List<TipoChamado> listaTipoChamados) {
        this.listaTipoChamados = listaTipoChamados;
    }

    public Boolean getAddNovo() {
        return addNovo;
    }

    public void setAddNovo(Boolean addNovo) {
        this.addNovo = addNovo;
    }

   
    
}
