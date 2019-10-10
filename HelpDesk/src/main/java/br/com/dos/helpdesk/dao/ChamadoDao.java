/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dos.helpdesk.dao;

import br.com.dos.helpdesk.modelo.Chamado;
import br.com.dos.helpdesk.modelo.Status;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;


/**
 *
 * @author sala302b
 */
public class ChamadoDao extends AppDao<Chamado>{
    
    public ChamadoDao(){
        super(Chamado.class);
    }
    
    /**
     * Retonra a lista de chamados abertos e em atendimento
     * @return 
     */
    public List<Chamado> getListaChamadosAbertos(){
        List<Chamado> listaRetorno=null;
        String hql = "SELECT c FROM Chamado c where c.status = :aberto or c.status= :atendimento";
        
        this.em = JPAUtil.getEntityManager(); 
        Query query = em.createQuery(hql);
        query.setParameter("aberto", Status.ABT);
        query.setParameter("atendimento", Status.ATD);
        
        try {
             //em.getTransaction().begin();
             listaRetorno = query.getResultList() ;
              //em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }finally{
            em.close(); 
        }
        return listaRetorno;
    }
    
    /**
     * Retorna lista de chamados Fechados
     * @return 
     */
    public List<Chamado> getListaChamadosEncerrados(){
        List<Chamado> listaRetorno=null;
        String hql = "SELECT c FROM Chamado c where c.status = :fechado";
        
        this.em = JPAUtil.getEntityManager(); 
        Query query = em.createQuery(hql);
        query.setParameter("fechado", Status.FCH);
        
        try {
             //em.getTransaction().begin();
             listaRetorno = query.getResultList() ;
              //em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }finally{
            em.close(); 
        }
        return listaRetorno;
    }
    
    
}
