/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dos.helpdesk.bean;

import br.com.dos.helpdesk.dao.LocalDao;
import br.com.dos.helpdesk.dao.UsuarioDao;
import br.com.dos.helpdesk.modelo.Local;
import br.com.dos.helpdesk.modelo.Perfil;
import br.com.dos.helpdesk.modelo.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author sala302b
 */

@Named(value = "usuarioMB") // já esta utilizando o CDI
@SessionScoped
public class UsuarioMB extends AppMB implements Serializable {
    
    private Usuario usuario = new Usuario();
    
    private List<Usuario> listaUsuarios;
  
    private List<Local> listaLocals;
    
    private Perfil[] perfil;
   

 public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String gravar() {
        System.out.println("br.com.dos.helpdesk.bean.UsuarioMB.gravar()");
        UsuarioDao dao = new UsuarioDao();
            if(usuario.getId()!= null && usuario.getId()> 0){
                dao.atualizar(usuario);
                addMessageWarnning("Usuário atualizado com sucesso!!!");
            }else{
                dao.inserir(usuario);
                addMessageWarnning("Usuário inserido com sucesso!!!");
            }
            
            return "listar?faces-redirect=true";
        /*
        System.out.println("Pessoa" + pessoa.getNome());
        PessoaDao dao = new PessoaDao();
        dao.inserir(pessoa);
        
        return null;*/
    }
    
    public String novoUsuario (){
        
        this.usuario = new Usuario();
        return "editar?faces-redirect=true";
    }
    
    public String editar (Usuario usuario){
        
        this.usuario = usuario;
        return "editar?faces-redirect=true";
    }
    
    public String excluir (Usuario usuario){
        
        UsuarioDao dao = new UsuarioDao();
        dao.excluir(usuario);
        addMessageWarnning("Usuário excluido com sucesso!!!");
        return null;
    }

    public List<Usuario> getListaUsuarios() {
        
        UsuarioDao dao = new UsuarioDao();
        return dao.buscarTodos();
        
    }

    public void setListaUsuario(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    
    public List<Local> getListaLocals() {
        LocalDao localDao = new LocalDao();
        return localDao.buscarTodos();
        
    }

    public void setListaLocals(List<Local> listaLocals) {
        this.listaLocals = listaLocals;
    }

    public Perfil[] getPerfil() {
         return Perfil.values();
    }

    public void setPerfil(Perfil[] perfil) {
        this.perfil = perfil;
    }

   

    
    
}
