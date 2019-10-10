/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dos.helpdesk.bean;

import br.com.dos.helpdesk.dao.UsuarioDao;
import br.com.dos.helpdesk.modelo.Usuario;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author sala302b
 */
@Named(value = "segurancaMB")
@SessionScoped
public class SegurancaMB extends AppMB implements Serializable {

    public SegurancaMB() {
    }
    
    private String login = "";
    private String senha = "";
    
    

    public String logar() {
        
        UsuarioDao dao = new UsuarioDao();
        Usuario usuario = dao.autenticar(login,senha);
        System.out.println("logou com " + usuario);
        if(usuario!=null){
            //inserir usuario na sessão
            FacesContext fc = FacesContext.getCurrentInstance();

            //colocar valor em sessão 
            fc.getExternalContext().getSessionMap().put("usuarioLogado", usuario);

            
            return "/chamado/listar?faces-redirect=true";
        }else{
            addMessageErro("Login ou senha incorreto!");
            return null;
        }

    }
    
    public String logout(){
        //inserir usuario na sessão
        FacesContext fc = FacesContext.getCurrentInstance();

        //colocar valor em sessão 
        fc.getExternalContext().getSessionMap().put("usuarioLogado", null);

        //encerrando a sessão
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

        //redirecionando para a tela de lin
         return "/login?faces-redirect=true";
    }
    

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

