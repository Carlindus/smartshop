/**
 * 
 */
package presentation.produit.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

/**
 * @author Alexy
 *         test merge request
 *
 */
public class ProduitForm extends ActionForm {

    /**
     */
    private static final long serialVersionUID = 8588116075065580728L;

    private int      idProduit;
    private String   reference;
    private String   prix;
    private String   description;
    private boolean  enVente;
    private FormFile image;

    /**
     * 
     */
    public ProduitForm() {
        System.out.println("----- ProduitForm CONSTRUCTOR ----------");
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.struts.action.ActionForm#reset(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
     */
    @Override
    public void reset(final ActionMapping mapping, final HttpServletRequest request) {

        this.reference = "";
        this.description = "";
        this.image = null;
        this.enVente = false;

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.struts.action.ActionForm#validate(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
     */
    @Override
    public ActionErrors validate(final ActionMapping mapping, final HttpServletRequest request) {
        System.out.println("-------- VALIDATE ProduitForm --------");
        ActionErrors errorForm = new ActionErrors();

        /*
         * if(reference.isEmpty()) {
         * errorForm.add("reference",new ActionMessage("errors.reference.obligatoire"));
         * }
         * 
         * if(prix.isEmpty()) {
         * errorForm.add("prix",new ActionMessage("errors.prix.obligatoire"));
         * try {
         * if(Double.parseDouble(prix) < 0) {
         * errorForm.add("prix",new ActionMessage("errors.prix.negatif"));
         * }
         * 
         * }catch(final NumberFormatException e) {
         * e.printStackTrace();
         * errorForm.add("prix",new ActionMessage("errors.prix.type"));
         * 
         * }
         * }
         */
        System.out.println("errorForm = " + errorForm.toString());
        return errorForm;

    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEnVente() {
        return enVente;
    }

    public void setEnVente(boolean etat) {
        this.enVente = etat;
    }

    public FormFile getImage() {
        return image;
    }

    public void setImage(FormFile image) {
        this.image = image;
    }

}
