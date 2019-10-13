
package persistance.produit.bean;

/**
 * @author Michelle
 *
 */
public class ProduitDo {
    // test merge request michellef

    // to review 1435

    // ATTRIBUTS
    private int     idProduit;
    private String  reference;
    private String  description;
    private double  prix;
    private String  image;
    private boolean etat;

    // CONSTRUCTOR PAR DEFAUT
    public ProduitDo() {

    }

    // GETTERS & SETTERS
    // Produit
    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    // reference
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    // description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // prix
    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    // image
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    // etat (en vente ou non)
    public boolean getEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

}
