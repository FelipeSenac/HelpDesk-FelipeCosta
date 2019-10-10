/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dos.helpdesk.controle;


import br.com.dos.helpdesk.modelo.Usuario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sala302b
 */
public class LoginFiltro implements Filter {
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String contextPath = req.getContextPath();
        
        
        //verifica se é a pagina de login ou dos recursos para liberar acesso
        if(req.getRequestURI().endsWith(contextPath+"/faces/login.xhtml") 
                || req.getRequestURI().contains(contextPath+"/faces/javax.faces.resource/")){
            chain.doFilter(req, res);
            return;
        }

        HttpSession session = req.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        //System.out.println("usuario logado =" + usuario);
        if (usuario == null) {
            //redireciona para a pagina de login
            ((HttpServletResponse) res).sendRedirect(contextPath+"/faces/login.xhtml");
        } else {
            //da continuidade ao programa
            chain.doFilter(req, res);
        }
    }

    @Override
    public void destroy() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
