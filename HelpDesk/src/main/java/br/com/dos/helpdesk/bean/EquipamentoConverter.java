/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dos.helpdesk.bean;

import br.com.dos.helpdesk.dao.EquipamentoDao;
import br.com.dos.helpdesk.modelo.Equipamento;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author sala302b
 */

@FacesConverter(forClass = Equipamento.class, value="equipamentoConverter")
public class EquipamentoConverter implements Converter {
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
         if (value == null || value.isEmpty()) {

            return null;
        } else {
            try {
                Long id = Long.parseLong(value);
                
                Equipamento equipamento = new EquipamentoDao().buscar(id);
               
                return equipamento;
            } catch (Exception e) {
                return null;
            }

        }
        
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        
         
        try {
            Equipamento equipamento = (Equipamento) value;
            if (equipamento != null) {
                return String.valueOf(equipamento.getId());
            } else {
                
                return null;
            }
        } catch (Exception e) {
            return null;
        }
        
    }

    
}
