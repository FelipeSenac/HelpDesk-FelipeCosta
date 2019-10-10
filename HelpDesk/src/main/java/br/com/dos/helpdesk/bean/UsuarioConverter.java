/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dos.helpdesk.bean;


import br.com.dos.helpdesk.dao.UsuarioDao;
import br.com.dos.helpdesk.modelo.Usuario;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author sala302b
 */

@FacesConverter(forClass = Usuario.class, value="usuarioConverter")
public class UsuarioConverter implements Converter {
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
         if (value == null || value.isEmpty()) {

            return null;
        } else {
            try {
                Long id = Long.parseLong(value);
                
                Usuario usuario = new UsuarioDao().buscar(id);
               
                return usuario;
            } catch (Exception e) {
                return null;
            }

        }
        
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        
         
        try {
            Usuario usuario = (Usuario) value;
            if (usuario != null) {
                return String.valueOf(usuario.getId());
            } else {
                
                return null;
            }
        } catch (Exception e) {
            return null;
        }
        
    }

    
    
}
