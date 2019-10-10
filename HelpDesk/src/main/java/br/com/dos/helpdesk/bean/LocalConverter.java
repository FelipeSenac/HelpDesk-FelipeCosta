/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dos.helpdesk.bean;


import br.com.dos.helpdesk.dao.LocalDao;
import br.com.dos.helpdesk.modelo.Local;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author sala302b
 */

@FacesConverter(forClass = Local.class, value="localConverter")
public class LocalConverter implements Converter {
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
         if (value == null || value.isEmpty()) {

            return null;
        } else {
            try {
                Long id = Long.parseLong(value);
                
                Local local = new LocalDao().buscar(id);
               
                return local;
            } catch (Exception e) {
                return null;
            }

        }
        
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        
         
        try {
            Local local = (Local) value;
            if (local != null) {
                return String.valueOf(local.getId());
            } else {
                
                return null;
            }
        } catch (Exception e) {
            return null;
        }
        
    }
    
    
    
    
}
