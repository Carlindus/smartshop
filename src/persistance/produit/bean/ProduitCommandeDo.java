/**
 * 
 */
package persistance.produit.bean;

/**
 * @author Audrey
 *
 */
public class ProduitCommandeDo {

	private int     idProduitCde;
    private String  reference;
    private String  description;
    private double  prix;
    private String  image;
    private int     idProduit;
    
    /**
     * 
     */
    public ProduitCommandeDo() {
    }

    
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    
    /**
     * @param description 
     * the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }


    
    /**
     * @return the idProduitCde
     */
    public int getIdProduitCde() {
        return idProduitCde;
    }


    
    /**
     * @param idProduitCde 
     * the idProduitCde to set
     */
    public void setIdProduitCde(int idProduitCde) {
        this.idProduitCde = idProduitCde;
    }


    
    /**
     * @return the reference
     */
    public String getReference() {
        return reference;
    }


    
    /**
     * @param reference 
     * the reference to set
     */
    public void setReference(String reference) {
        this.reference = reference;
    }


    
    /**
     * @return the prix
     */
    public double getPrix() {
        return prix;
    }


    
    /**
     * @param prix 
     * the prix to set
     */
    public void setPrix(double prix) {
        this.prix = prix;
    }


    
    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }


    
    /**
     * @param image 
     * the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }


    
    /**
     * @return the idProduit
     */
    public int getIdProduit() {
        return idProduit;
    }


    
    /**
     * @param idProduit 
     * the idProduit to set
     */
    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    
    
}
