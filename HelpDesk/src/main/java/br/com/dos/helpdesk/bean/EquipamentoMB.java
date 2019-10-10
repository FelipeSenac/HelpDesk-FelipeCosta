/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dos.helpdesk.bean;

import br.com.dos.helpdesk.dao.EquipamentoDao;
import br.com.dos.helpdesk.dao.FabricanteDao;
import br.com.dos.helpdesk.dao.LocalDao;
import br.com.dos.helpdesk.dao.ModeloDao;
import br.com.dos.helpdesk.dao.TipoEquipamentoDao;
import br.com.dos.helpdesk.modelo.Equipamento;
import br.com.dos.helpdesk.modelo.Fabricante;
import br.com.dos.helpdesk.modelo.Local;
import br.com.dos.helpdesk.modelo.Modelo;
import br.com.dos.helpdesk.modelo.TipoEquipamento;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


/**
 *
 * @author sala302b
 */
@Named(value = "equipamentoMB") // já esta utilizando o CDI
@SessionScoped
public class EquipamentoMB extends AppMB implements Serializable {
    
    private Equipamento equipamento = new Equipamento();
    
    private List<Equipamento> listaEquipamentos;
    
    private List<Local> listaLocals;
    
    private List<Modelo> listaModelos;
    
    private List<Fabricante> listaFabricantes;
    
    private List<TipoEquipamento> listaTipoEquipamentos;
  
    
     public String gravar() {
        System.out.println("br.com.dos.helpdesk.bean.EquipamentoMB.gravar()");
         EquipamentoDao dao = new EquipamentoDao();
            if(equipamento.getId()!= null && equipamento.getId()> 0){
                dao.atualizar(equipamento);
                addMessageWarnning("Equipamento atualizado com sucesso!!!");
            }else{
                dao.inserir(equipamento);
                addMessageWarnning("Equipamento inserido com sucesso!!!");
            }
            
            return "listar?faces-redirect=true";
       
    }
    
    public String novoEquipamento (){
        
        this.equipamento = new Equipamento();
        return "editar?faces-redirect=true";
    }
    
    public String editar (Equipamento equipamento){
        
        this.equipamento = equipamento;
        return "editar?faces-redirect=true";
    }
    
    public String excluir (Equipamento equipamento){
        
        EquipamentoDao dao = new EquipamentoDao();
        dao.excluir(equipamento);
        addMessageWarnning("Equipamento excluido com sucesso!!!");
        return null;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public List<Equipamento> getListaEquipamentos() {
        EquipamentoDao equipamentoDao = new EquipamentoDao();
        return equipamentoDao.buscarTodos();
    }

    public void setListaEquipamentos(List<Equipamento> listaEquipamentos) {
        this.listaEquipamentos = listaEquipamentos;
    }

    public List<Local> getListaLocals() {
        LocalDao localDao = new LocalDao();
        return localDao.buscarTodos();
    }

    public void setListaLocals(List<Local> listaLocals) {
        this.listaLocals = listaLocals;
    }

    public List<Modelo> getListaModelos() {
        ModeloDao modeloDao = new ModeloDao();
        return modeloDao.buscarTodos();
    }

    public void setListaModelos(List<Modelo> listaModelos) {
        this.listaModelos = listaModelos;
    }

    public List<Fabricante> getListaFabricantes() {
        FabricanteDao fabricanteDao = new FabricanteDao();
        return fabricanteDao.buscarTodos();
    }

    public void setListaFabricantes(List<Fabricante> listaFabricantes) {
        this.listaFabricantes = listaFabricantes;
    }

    public List<TipoEquipamento> getListaTipoEquipamentos() {
        TipoEquipamentoDao tipoEquipamentoDao = new TipoEquipamentoDao();
        return tipoEquipamentoDao.buscarTodos();
    }

    public void setListaTipoEquipamentos(List<TipoEquipamento> listaTipoEquipamentos) {
        this.listaTipoEquipamentos = listaTipoEquipamentos;
    }

   
}
