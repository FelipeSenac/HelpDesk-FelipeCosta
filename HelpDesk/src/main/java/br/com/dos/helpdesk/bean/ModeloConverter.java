/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dos.helpdesk.bean;


import br.com.dos.helpdesk.dao.ModeloDao;
import br.com.dos.helpdesk.modelo.Modelo;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author sala302b
 */
@FacesConverter(forClass = Modelo.class, value="modeloConverter")
public class ModeloConverter implements Converter{
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
         if (value == null || value.isEmpty()) {

            return null;
        } else {
            try {
                Long id = Long.parseLong(value);
                
                Modelo modelo = new ModeloDao().buscar(id);
               
                return modelo;
            } catch (Exception e) {
                return null;
            }

        }
        
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        
         
        try {
            Modelo modelo = (Modelo) value;
            if (modelo != null) {
                return String.valueOf(modelo.getId());
            } else {
                
                return null;
            }
        } catch (Exception e) {
            return null;
        }
        
    }
    
    
    
}
