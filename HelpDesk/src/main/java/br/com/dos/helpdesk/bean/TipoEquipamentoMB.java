/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dos.helpdesk.bean;


import br.com.dos.helpdesk.dao.TipoEquipamentoDao;
import br.com.dos.helpdesk.modelo.TipoEquipamento;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author sala302b
 */

@Named(value = "tipoEquipamentoMB")
@SessionScoped
public class TipoEquipamentoMB extends AppMB implements Serializable {
    
    
    
    private List<TipoEquipamento> listaTipoEquipamentos;
    private Boolean addNovo = false;

    public List<TipoEquipamento> getListaTipoEquipamentos() {
        TipoEquipamentoDao dao = new TipoEquipamentoDao();

        if (listaTipoEquipamentos == null) {
            listaTipoEquipamentos = dao.buscarTodos();
        }
        if (listaTipoEquipamentos == null){
            listaTipoEquipamentos = new ArrayList<>();
            
        }
        if(listaTipoEquipamentos.isEmpty()||addNovo){
            listaTipoEquipamentos.add(new TipoEquipamento());
            addNovo=false;
        }
        

        

        return listaTipoEquipamentos;
    }

   
    

    public String excluir(TipoEquipamento tipoEquipamento) {

        TipoEquipamentoDao dao = new TipoEquipamentoDao();
        dao.excluir(tipoEquipamento);
        listaTipoEquipamentos.remove(tipoEquipamento);
        return null;

    }

    public String salvar() {
        TipoEquipamentoDao dao = new TipoEquipamentoDao();
        dao.salvarLista(this.listaTipoEquipamentos);
        return null;

    }

    public String novo() {
        addNovo=true;
        return null;
        
    }


    public void setListaTipoEquipamentos(List<TipoEquipamento> listaTipoEquipamentos) {
        this.listaTipoEquipamentos = listaTipoEquipamentos;
    }

    public Boolean getAddNovo() {
        return addNovo;
    }

    public void setAddNovo(Boolean addNovo) {
        this.addNovo = addNovo;
    }

   
    
}
