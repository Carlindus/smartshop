/**
 * 
 */
package service.commande;

import java.sql.Timestamp;
import java.util.List;

import persistance.commande.bean.CommandeDo;
import persistance.produit.bean.ProduitDo;
import presentation.commande.bean.CommandeDetailDto;
import presentation.commande.bean.CommandeDto;
import presentation.panier.bean.PanierDto;
import presentation.produit.bean.ProduitDto;

/**
 * @author Formation
 *
 */
public interface ICommandeService {

    /**
     * 
     * @param panierDto
     * @param idUtilisateur
     * @param adresseLivraison
     * @param adresseFacturation
     * @return
     */
    CommandeDo createCommande(final PanierDto panierDto, final int idUtilisateur, final String adresseLivraison, final String adresseFacturation);
    
    /**
     * @param id
     * @return
     */
    List<CommandeDto> findAllCommandeByUtilisateur(final int id);
    
    /**
     * @return
     */
    List<CommandeDto> findAllCommande();

    /**
     * @param idCommande
     * @return
     */
    CommandeDetailDto findDetailCommande(final int idCommande);
    
    /**
     * @param idUser
     * @return
     */
    boolean supprimerAssociation(final int idUser);
}
