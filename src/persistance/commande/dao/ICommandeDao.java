/**
 * 
 */
package persistance.commande.dao;

import java.util.List;
import java.sql.Timestamp;

import persistance.commande.bean.CommandeDo;
import persistance.commande.bean.LigneCommandeDo;
import persistance.produit.bean.ProduitCommandeDo;
import persistance.produit.bean.ProduitDo;
import presentation.commande.bean.CommandeDto;
import presentation.produit.bean.ProduitDto;

/**
 * @author Formation
 *
 */
public interface ICommandeDao {

    /**
     * 
     * @param commandeDo
     * @return
     */
	CommandeDo addCommande(CommandeDo commandeDo);
	
	/**
	 * 
	 * @param ligneCommandeDo
	 * @return
	 */
    LigneCommandeDo addLigneCommande(LigneCommandeDo ligneCommandeDo);
    
    /**
     * @param id
     * @return
     */
    List<CommandeDo> findAllCommandeByUtilisateur(final int id);

    /**
     * @return
     */
    List<CommandeDo> findAllCommande();
    
    /**
     * @param idCommande
     * @return
     */
    CommandeDo findCommande(final int idCommande);
    
    /**
     * @param idUser
     * @return
     */
    boolean supprimerAssociation(final int idUser);
}
