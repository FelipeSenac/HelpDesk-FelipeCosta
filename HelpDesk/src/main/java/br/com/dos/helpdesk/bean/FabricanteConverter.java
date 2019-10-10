/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dos.helpdesk.bean;

import br.com.dos.helpdesk.dao.FabricanteDao;
import br.com.dos.helpdesk.modelo.Fabricante;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author sala302b
 */

@FacesConverter(forClass = Fabricante.class, value="fabricanteConverter")
public class FabricanteConverter implements Converter{
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
         if (value == null || value.isEmpty()) {

            return null;
        } else {
            try {
                Long id = Long.parseLong(value);
                
                Fabricante fabricante = new FabricanteDao().buscar(id);
               
                return fabricante;
            } catch (Exception e) {
                return null;
            }

        }
        
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        
         
        try {
            Fabricante fabricante = (Fabricante) value;
            if (fabricante != null) {
                return String.valueOf(fabricante.getId());
            } else {
                
                return null;
            }
        } catch (Exception e) {
            return null;
        }
        
    }
    
    
}
