/**
 * 
 */
package presentation.produit.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

import presentation.produit.bean.ProduitDto;
import presentation.utilisateur.bean.UtilisateurDto;

/**
 * @author Alexy
 *test merge request
 *
 */
public class ProduitForm extends ActionForm {

    /**
     * 
     * 
     * 
     */
    private static final long serialVersionUID = 8588116075065580728L;
    
    private String produitReference;
    private String produitPrix;
    

    private String produitDescription;
    private boolean produitEnVente;
    private FormFile produitImage;
    
    /**
     * 
     */
    public ProduitForm() {
        
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
        
        if(produitReference.isEmpty()) {
            errorForm.add("produitReference",new ActionMessage("errors.reference.obligatoire"));
        }
        
        if(produitImage.getFileSize()==0) {
            errorForm.add("produitImage",new ActionMessage("errors.image.obligatoire"));
        }
        
        if(produitPrix.isEmpty()) {
            errorForm.add("produitPrix",new ActionMessage("errors.prix.obligatoire"));
            try {
                if(Double.parseDouble(produitPrix) < 0) {
                    errorForm.add("produitPrix",new ActionMessage("errors.prix.negatif"));
                }
               
            }catch(final NumberFormatException e) {
                e.printStackTrace();
                errorForm.add("produitPrix",new ActionMessage("errors.prix.type"));
         
            }
        }
        
        return errorForm;
    }
    

    public String getReference() {
        return produitReference;
    }
  
    public String getPrix() {
        return produitPrix;
    }

    public String getDescription() {
        return produitDescription;
    }

    public boolean getEtat() {
        return produitEnVente;
    }

    public FormFile getImageFile() {
        return produitImage;
    }

}
