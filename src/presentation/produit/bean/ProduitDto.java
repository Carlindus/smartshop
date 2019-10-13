/**
 * 
 */
package presentation.produit.bean;

/**
 * Data Transfer Object pour le produit
 * 
 * @author Audrey
 *
 */
public class ProduitDto {

    private int     idProduit;
    private String  reference;
    private String  description;
    private double  prix;
    private String  image;
    private boolean etat;
    private byte[]  data;

    /**
     * constructeur par d�faut
     */
    public ProduitDto() {
    }

    /**
     * @return the idProduit
     */
    public int getIdProduit() {
        return idProduit;
    }

    /**
     * @param idProduit
     *            the idProduit to set
     */
    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    /**
     * @return the reference
     */
    public String getReference() {
        return reference;
    }

    /**
     * @param reference
     *            the reference to set
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the prix
     */
    public double getPrix() {
        return prix;
    }

    /**
     * @param prix
     *            the prix to set
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
     *            the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the etat
     */
    public boolean getEtat() {
        return etat;
    }

    /**
     * @param etat
     *            the etat to set
     */
    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    /**
     * @return the data
     */
    public byte[] getData() {
        return data;
    }

    /**
     * @param data
     *            the data to set
     */
    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ProduitDto [idProduit=" + idProduit + ",\n reference=" + reference + ",\n description=" + description + ",\n prix=" + prix + ",\n etat=" + etat + "\n ]";
    }

}
