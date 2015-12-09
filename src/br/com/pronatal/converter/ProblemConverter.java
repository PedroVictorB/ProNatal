/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pronatal.converter;

import br.com.pronatal.business.ProblemService;
import br.com.pronatal.model.Problem;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author brunomoreira
 */

@FacesConverter(value="problemConverter")
public class ProblemConverter implements Converter{

    private ProblemService problemService;
    
    public ProblemConverter () {
        problemService = new ProblemService();
    }
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }

        try {
            int id = Integer.parseInt(value);
            return problemService.retrieveProblemById(id);
        } catch (NumberFormatException e) {
            throw new ConverterException("O valor não é um ID de Problem válido: " + value, e);
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if (value == null) {
            return "";
        }

        if (value instanceof Problem) {
            int id = ((Problem) value).getId();
            return String.valueOf(id);
        } else {
            throw new ConverterException("O valor não é uma instância de Problem: " + value);
        }
    }
    
}
