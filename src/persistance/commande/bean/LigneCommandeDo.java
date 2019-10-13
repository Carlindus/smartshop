/**
 * 
 */
package persistance.commande.bean;

import persistance.produit.bean.ProduitCommandeDo;

// test merge request kevinf

/**
 * @author Kevin
 *
 */
public class LigneCommandeDo {
    
    private int               idLigneCde;
    private CommandeDo        commandeDo;
    private ProduitCommandeDo produitCdeDo;
    private int               quantite;

    /**
     *  Constructeur par defaut
     */
    public LigneCommandeDo() {
    }

    /**
     * @return idLigneCde
     */
    public int getIdLigneCde() {
        return idLigneCde;
    }

    /**
     * @param idLigneCde
     *        idLigneCde to set
     */
    public void setIdLigneCde(final int idLigneCde) {
        this.idLigneCde = idLigneCde;
    }

    /**
     * @return commandeDo
     */
    public CommandeDo getCommandeDo() {
        return commandeDo;
    }

    /**
     * @param commandeDo
     *        commandeDo to set
     */
    public void setCommandeDo(final CommandeDo commandeDo) {
        this.commandeDo = commandeDo;
    }

    /**
     * @return produitCommandeDo
     */
    public ProduitCommandeDo getProduitCdeDo() {
        return produitCdeDo;
    }

    /**
     * @param produitCdeDo 
     *        produitCdeDo to set
     */
    public void setProduitCdeDo(final ProduitCommandeDo produitCdeDo) {
        this.produitCdeDo = produitCdeDo;
    }

    /**
     * @return quantite
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * @param quantite
     *        quantite to set
     */
    public void setQuantite(final int quantite) {
        this.quantite = quantite;
    }

}
