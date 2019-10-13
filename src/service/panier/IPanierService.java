/**
 * 
 */
package service.panier;

import presentation.panier.bean.PanierDto;

/**
 * @author Formation
 *
 */
public interface IPanierService {

    /**
     * @param idProduit
     * @param panier
     * @return
     */
    PanierDto ajouterProduitPanier(final int idProduit, final PanierDto panier);

    /**
     * @param idProduit
     * @param panier
     * @return
     */
    PanierDto increaseQuantity(final int idProduit, final PanierDto panier);

    /**
     * @param idProduit
     * @param panier
     * @return
     */
    PanierDto decreaseQuantity(final int idProduit, final PanierDto panier);

    /**
     * @param idProduit
     * @param panier
     * @return
     */
    PanierDto removeProduit(final int idProduit, final PanierDto panier);

    /**
     * @param panierRempli
     * @return
     */
    PanierDto cleanPanier(final PanierDto panierRempli);
    
    /**
     * @param panier
     * @return
     */
    boolean verifierPanierDto(final PanierDto panier);
    
    /**
     * @param panier
     * @return
     */
    PanierDto updateProduitsPanier(final PanierDto panier);

}