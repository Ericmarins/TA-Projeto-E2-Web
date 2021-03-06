package br.edu.ifsul.converters;

import br.edu.ifsul.modelo.Permissao;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author eric_
 */
@FacesConverter(value = "converterPermissao")
public class ConverterPermissao implements Serializable, Converter {
    
    @PersistenceContext(unitName = "TA_Projeto_E2_WebPU")
    private EntityManager em;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null || string.equals("Selecione um registro")){
            return null;
        }
        return em.find(Permissao.class, string);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null){
            return null;
        }
        Permissao obj = (Permissao) o;
        return obj.getNome();
    }

}
