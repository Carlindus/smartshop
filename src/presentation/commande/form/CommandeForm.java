/**
 * 
 */
package presentation.commande.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


/**
 * @author Alexy
 *test merge request
 *
 */
public class CommandeForm extends ActionForm {

    /**
     * 
     * 
     * 
     */
    private static final long serialVersionUID = 8588116075065580728L;
    
    private String adresseLivraison;
    private String adresseFacturation;
    

    
    /**
     * 
     */
    public CommandeForm() {
        
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.struts.action.ActionForm#reset(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
     */
    @Override
    public void reset(final ActionMapping mapping, final HttpServletRequest request) {
        
        super.reset(mapping, request);
        
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.struts.action.ActionForm#validate(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
     */
    @Override
    public ActionErrors validate(final ActionMapping mapping, final HttpServletRequest request) {
        ActionErrors errorForm = new ActionErrors();
        
        if(adresseLivraison.isEmpty()) {
            errorForm.add("adresseLivraison",new ActionMessage("errors.adresseLivraison.obligatoire"));
        }
        
        if(adresseFacturation.isEmpty()) {
            errorForm.add("adresseFacturation",new ActionMessage("errors.adresseFacturation.obligatoire"));
        }
        return errorForm;
    }
    

    /**
     * @return
     */
    public String getAdresseLivraison() {
        return adresseLivraison;
    }
  
    /**
     * @return
     */
    public String getAdresseFacturation() {
        return adresseFacturation;
    }

   

}
