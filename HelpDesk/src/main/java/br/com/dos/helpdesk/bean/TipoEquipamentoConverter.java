/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dos.helpdesk.bean;


import br.com.dos.helpdesk.dao.TipoEquipamentoDao;
import br.com.dos.helpdesk.modelo.TipoEquipamento;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author sala302b
 */

@FacesConverter(forClass = TipoEquipamento.class, value="tipoEquipamentoConverter")
public class TipoEquipamentoConverter implements Converter {
    
     @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
         if (value == null || value.isEmpty()) {

            return null;
        } else {
            try {
                Long id = Long.parseLong(value);
                
                TipoEquipamento tipoEquipamento = new TipoEquipamentoDao().buscar(id);
               
                return tipoEquipamento;
            } catch (Exception e) {
                return null;
            }

        }
        
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        
         
        try {
            TipoEquipamento tipoEquipamento = (TipoEquipamento) value;
            if (tipoEquipamento != null) {
                return String.valueOf(tipoEquipamento.getId());
            } else {
                
                return null;
            }
        } catch (Exception e) {
            return null;
        }
        
    }

    
    
    
}
