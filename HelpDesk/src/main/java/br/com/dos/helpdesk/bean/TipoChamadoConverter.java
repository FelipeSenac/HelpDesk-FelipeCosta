/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dos.helpdesk.bean;

import br.com.dos.helpdesk.dao.TipoChamadoDao;
import br.com.dos.helpdesk.modelo.TipoChamado;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author sala302b
 */

@FacesConverter(forClass = TipoChamado.class, value="tipoChamadoConverter")
public class TipoChamadoConverter implements Converter {
    
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
         if (value == null || value.isEmpty()) {

            return null;
        } else {
            try {
                Long id = Long.parseLong(value);
                
                TipoChamado tipoChamado = new TipoChamadoDao().buscar(id);
               
                return tipoChamado;
            } catch (Exception e) {
                return null;
            }

        }
        
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        
         
        try {
            TipoChamado tipoChamado = (TipoChamado) value;
            if (tipoChamado != null) {
                return String.valueOf(tipoChamado.getId());
            } else {
                
                return null;
            }
        } catch (Exception e) {
            return null;
        }
        
    }
   
}
