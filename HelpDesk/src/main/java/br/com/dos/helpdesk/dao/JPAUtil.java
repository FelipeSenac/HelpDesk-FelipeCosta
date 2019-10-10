/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dos.helpdesk.dao;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author sala302b
 */
public class JPAUtil {
    
    // informar o nome da unidade de persistencia no outros codigos 
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("helpdeskPU");
    
    public static EntityManager getEntityManager(){
        
        try{
            
            return emf.createEntityManager();
            
        }catch (Exception e){
            
            e.printStackTrace();
            throw new RuntimeException("Erro ao acessar o banco de dados");
        }
        
    }
    
}
