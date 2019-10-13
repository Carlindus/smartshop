package presentation.panier.bean;

/**
 * @author Kevin
 *
 */
public class DetailProduitPanierDto {

    private double montantLigne;
    private int    quantite;

    /**
     * 
     */
    public DetailProduitPanierDto() {

    }

    /**
     * @return montantLigne
     */
    public double getMontantLigne() {
        return montantLigne;
    }

    /**
     * @param montantLigne
     */
    public void setMontantLigne(double montantLigne) {
        this.montantLigne = montantLigne;
    }

    /**
     * @return quantite
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * @param quantite
     */
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "DetailProduitPanierDto [montantLigne=" + montantLigne + ", quantite=" + quantite + "]";
    }

}
