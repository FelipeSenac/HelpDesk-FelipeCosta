/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dos.helpdesk.dao;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author sala302b
 * @param <T>
 */
public class AppDao<T> {
    
    protected EntityManager em;
    
    private final Class<T> classe;
    
    public  AppDao(Class<T> Classe){
        this.classe = Classe;
    }
   
    public void inserir(T entidade){
        
        em = JPAUtil.getEntityManager();
        
        em.getTransaction().begin();
        
        em.persist(entidade);//
        
        em.getTransaction().commit();
        
        em.close();
    }
    
    public void atualizar(T entidade){
        
        em = JPAUtil.getEntityManager();
        
        em.getTransaction().begin();
        
        em.merge(entidade);//
        
        em.getTransaction().commit();
        
        em.close();
    }
    
    public void excluir(T entidade){
        
        em = JPAUtil.getEntityManager();
        
        em.getTransaction().begin();
        
        em.remove(em.merge(entidade));//
        
        em.getTransaction().commit();
        
        em.close();
    }
    
    /**
     * Metodo utilizado para recuperar uma entidade no banco de dados, atravez do ID informado
     * @param id
     * @return 
     */
    public T buscar(long id){
        
        em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
            
        T t = em.find(classe, id);//
        
        em.getTransaction().commit();
        em.close();
        return t;
    }
    
     public List<T> buscarTodos(){
        
        em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
         
        List<T> lista;
        
        
        Query q = em.createQuery("From " + classe.getName());
        lista = (List<T>) q.getResultList();
        
       //Lista = em.createQuery("From" + classe.getName()). getResultList();
        
        em.getTransaction().commit();
        em.close();
        return lista;
    }
    
    
    
}
