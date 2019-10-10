/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dos.helpdesk.bean;

import br.com.dos.helpdesk.dao.ChamadoDao;
import br.com.dos.helpdesk.dao.EquipamentoDao;
import br.com.dos.helpdesk.dao.TipoChamadoDao;
import br.com.dos.helpdesk.dao.UsuarioDao;
import br.com.dos.helpdesk.modelo.Chamado;
import br.com.dos.helpdesk.modelo.Equipamento;
import br.com.dos.helpdesk.modelo.Status;
import br.com.dos.helpdesk.modelo.TipoChamado;
import br.com.dos.helpdesk.modelo.Usuario;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author sala302b
 */

@Named(value = "chamadoMB") // já esta utilizando o CDI
@SessionScoped
public class ChamadoMB extends AppMB implements Serializable {
    
    private Chamado chamado = new Chamado();
    
    private List<Chamado> listaChamadosAberto;
    
    private List<Chamado> listaChamadosFechado;
    
    private List<Usuario> listaUsuarios;
    
    private List<Equipamento> listaEquipamentos;
    
    private List<TipoChamado> listaTipoChamados;
    
    private Status [] status;
    
    
    public String gravar() {
        System.out.println("br.com.dos.helpdesk.bean.ChamadoMB.gravar()");
        ChamadoDao dao = new ChamadoDao();
            if(chamado.getId()!= null && chamado.getId()> 0){
                dao.atualizar(chamado);
                addMessageWarnning("Chamado gravado com sucesso!!!");
            }else{
                try {
                //insere o usuario de abertura quando salver um novo usuairo
                chamado.setUsuarioAbertura(getUsuarioLogado());
                
                //muda o status para aberto
                chamado.setStatus(Status.ABT);
                
                //Insere a data atual como a data de abertura
                chamado.setDataAbertura(new Date());
                
                //Insere como data para atendimento a data atual mais o tempo para atendimento do chamado
                chamado.setLimiteAtendimento(addHora(new Date(), chamado.getTipoChamado().getTempoAtendimento()));
                dao.inserir(chamado);
                addMessageInfo("Chamado inserido com sucesso!!");
                return "listar?faces-redirect=true";
            } catch (Exception e) {
                addMessageErro(e.getMessage());
                return null;
            }
        }
        return "listar?faces-redirect=true";
    }
    
    public String atender(Chamado chamado) {
        this.chamado = chamado;
        
        //insere o técnico responsável quando o usuario clicar em atender
        this.chamado.setTecnicoResponsavel(getUsuarioLogado());
        
        //Coloca o status do chamado como em atendimento
        this.chamado.setStatus(Status.ATD);
        
        return "editar?faces-redirect=true";
    }
   
    public String encerrar(){
        //Coloca o status do chamado como fechado
        chamado.setStatus(Status.FCH);
        
        //chama o gravar
        gravar();
        
        //envia email
       // enviarEmail(chamado);
        
       addMessageInfo("Chamado finalizado com sucesso!!");
       
        return "listar?faces-redirect=true";
    }
    
     /** 
     * @param horasAdicionais - Horas a serem adicionas (int)
     * @param data - Data a ser modificada (Date)
     * @return - Data alterada (Date)
     */
    public Date addHora(Date data, int horasAdicionais) {
        int umaHora = 60*60*1000; //1h = 60min * 60seg * 1000miliseg
        data.setTime(data.getTime() + horasAdicionais*umaHora);
        return data;
    }

    
    /*
    
    funcionando
    public String gravar() {
        System.out.println("br.com.dos.helpdesk.bean.ChamadoMB.gravar()");
        ChamadoDao dao = new ChamadoDao();
            if(chamado.getId()!= null && chamado.getId()> 0){
                dao.atualizar(chamado);
                addMessageWarnning("Chamado atualizado com sucesso!!!");
            }else{
                dao.inserir(chamado);
                addMessageWarnning("Chamado inserido com sucesso!!!");
            }
            
            return "listar?faces-redirect=true";
     
    }
    
    */
    
 
    
    public String novoChamado (){
        
        this.chamado = new Chamado();
        return "editar?faces-redirect=true";
    }
    
    public String editar (Chamado chamado){
        
        this.chamado = chamado;
        return "editar?faces-redirect=true";
    }
    
    public String excluir (Chamado chamado){
        
        ChamadoDao dao = new ChamadoDao();
        dao.excluir(chamado);
        addMessageWarnning("Chamado excluido com sucesso!!!");
        return null;
    }

    public Chamado getChamado() {
        return chamado;
    }

    public void setChamado(Chamado chamado) {
        this.chamado = chamado;
    }

    public List<Chamado> getListaChamadosAberto() {
        ChamadoDao dao = new ChamadoDao();
        
        return dao.getListaChamadosAbertos();
    }

    public void setListaChamadosAberto(List<Chamado> listaChamadosAberto) {
        this.listaChamadosAberto = listaChamadosAberto;
    }

    public List<Chamado> getListaChamadosFechado() {
         ChamadoDao dao = new ChamadoDao();
        
        return dao.getListaChamadosEncerrados();
    }

    public void setListaChamadosFechado(List<Chamado> listaChamadosFechado) {
        this.listaChamadosFechado = listaChamadosFechado;
    }


    

    public List<Usuario> getListaUsuarios() {
        UsuarioDao dao = new UsuarioDao();
        return dao.buscarTodos();
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public List<Equipamento> getListaEquipamentos() {
        EquipamentoDao dao = new EquipamentoDao();
        return dao.buscarTodos();
    }

    public void setListaEquipamentos(List<Equipamento> listaEquipamentos) {
        this.listaEquipamentos = listaEquipamentos;
    }

    public List<TipoChamado> getListaTipoChamados() {
        TipoChamadoDao dao = new TipoChamadoDao();
        return dao.buscarTodos();
    }

    public void setListaTipoChamados(List<TipoChamado> listaTipoChamados) {
        this.listaTipoChamados = listaTipoChamados;
    }

    public Status[] getStatus() {
        return status;
    }

    public void setStatus(Status[] status) {
        this.status = status;
    }
    
   public boolean dono(Chamado chamado){
       
      if (getUsuarioLogado().equals(chamado.getUsuarioAbertura())){
          
          return true;
      }
      
      return false;
               
   }
           
   
    
}
