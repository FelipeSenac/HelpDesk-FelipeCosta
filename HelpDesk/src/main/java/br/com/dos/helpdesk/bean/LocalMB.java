/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dos.helpdesk.bean;


import br.com.dos.helpdesk.dao.LocalDao;
import br.com.dos.helpdesk.modelo.Local;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author sala302b
 */

@Named(value = "localMB")
@SessionScoped
public class LocalMB extends AppMB implements Serializable{
    
    private Local local;
    
    private List<Local> listaLocals = new ArrayList<>();
    private Boolean addNovo = false;

    public List<Local> getListaLocals() {
        LocalDao dao = new LocalDao();
        listaLocals = dao.buscarTodos();
       
        return listaLocals;
    }

    
    public String excluir(Local local) {

        LocalDao dao = new LocalDao();
        dao.excluir(local);
        listaLocals.remove(local);
        return null;

    }

    public String salvar() {
        LocalDao dao = new LocalDao();
        dao.salvarLista(this.listaLocals);
        return null;

    }
    
    public String editar (Local local){
        
        this.local = local;
        return "editar?faces-redirect=true";
    }
    
    public String gravar(){
        
        System.out.println("## Gravando um local ##");
        
        LocalDao dao = new LocalDao();
        if(local.getId()!= null && local.getId()> 0){
                dao.atualizar(local);
            }else{
                dao.inserir(local);
            }
            
            return "listar?faces-redirect=true";
            
       /*
        LocalDao dao = new LocalDao();
        dao.inserir(local);
        return null;*/
    }
      
    public String novaLocal (){
        
        this.local = new Local();
        return "editar?faces-redirect=true";
    }

    public void setListaLocals(List<Local> listaLocals) {
        this.listaLocals = listaLocals;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Boolean getAddNovo() {
        return addNovo;
    }

    public void setAddNovo(Boolean addNovo) {
        this.addNovo = addNovo;
    }
    
}
