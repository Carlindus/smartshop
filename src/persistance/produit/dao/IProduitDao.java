/**
 * 
 */
package persistance.produit.dao;

import java.util.List;

import persistance.produit.bean.ProduitCommandeDo;
import persistance.produit.bean.ProduitDo;

/**
 * @author Michelle
 *
 */
public interface IProduitDao {
    
    /**
     * @param produitDo
     * @return
     */
    ProduitDo addProduit(final ProduitDo produitDo);
    
    /**
     * @param produitCommandeDo
     * @return
     */
    ProduitCommandeDo addProduitCommande(final ProduitCommandeDo produitCommandeDo);
    

    /**Supprimer un produit en vente
     * @param idProduit
     * @return boolean
     * true si supp
     */
    boolean deleteProduit(final int idProduit);
    
    

    /**Modifier un produit
     * @param idProduit
     * @param produitDo
     * @return ProduitDo
     */
    ProduitDo updateProduit(final int idProduit, final ProduitDo produitDo);

    
    
    /**Trouver un produit en vente
     * @param idProduit
     * @return ProduitDo produitDo
     */
    ProduitDo findProduit(final int idProduit);

    
    /**Trouver un produit commandé
     * @param idProduitCde
     * @return ProduitDo produitDo
     */
    ProduitCommandeDo findProduitCommande(final int idProduitCde);
    
    
    
    /** Trouver tous les produits
     * @return list<ProduitDo>
     */
    List<ProduitDo> findAllProduit();

    
    
    /**Trouver tous les produits commandés
     * @return list<ProduitCommandeDo>
     */
    List<ProduitCommandeDo> findAllProduitCommande();
    
    
    
    /**Trouver tous les produits en vente
     * @return list<ProduitDo>
     */
    List<ProduitDo> findAllProduitEnVente();


}
