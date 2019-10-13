/**
 * 
 */
package service.commande.impl;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import persistance.commande.bean.CommandeDo;
import persistance.commande.bean.LigneCommandeDo;
import persistance.commande.dao.ICommandeDao;
import persistance.commande.dao.impl.CommandeDao;
import persistance.produit.bean.ProduitCommandeDo;
import presentation.commande.bean.CommandeDetailDto;
import presentation.commande.bean.CommandeDto;
import presentation.panier.bean.DetailProduitPanierDto;
import presentation.panier.bean.PanierDto;
import presentation.produit.bean.ProduitDto;
import service.commande.ICommandeService;
import service.commande.MapperDoToCommandeDetailDto;
import service.commande.MapperDoToCommandeDto;
import service.produit.IProduitService;
import service.produit.impl.ProduitService;
import util.MyFactory;

/**
 * @author Jonathan
 *
 */
public class CommandeService implements ICommandeService {

    public CommandeService() {
        // empty method
    }
    
    /**
     * @return
     */
    public ICommandeService getInstance() {
        return new CommandeService();
    }

    @Override
    public CommandeDo createCommande(final PanierDto panierDto, final int idUtilisateur, final String adresseLivraison, final String adresseFacturation) {
        // on r�cup�re la Dao qui permettra de communiquer avec la base de donn�es
        ICommandeDao commandeDao = new CommandeDao();
        IProduitService iProduitService = new ProduitService();
        //
        CommandeDo commandeDo = new CommandeDo();
        commandeDo.setIdUtilisateur(idUtilisateur);
        commandeDo.setDateCde(new Timestamp(System.currentTimeMillis()));
        commandeDo.setAdresseLivraison(adresseLivraison);
        commandeDo.setAdresseFacturation(adresseFacturation);
        commandeDo.setMontantRemise(panierDto.getMontantRemise());
        commandeDo.setMontantTotal(panierDto.getMontantTotal());

        commandeDo = commandeDao.addCommande(commandeDo);

        Map<ProduitDto, DetailProduitPanierDto> mapProduitDto = panierDto.getMapProduitDto();

        // on parcourt les cl�s de la map (~ liste des produits)
        Iterator<ProduitDto> listeProduitDto = mapProduitDto.keySet().iterator();
        while (listeProduitDto.hasNext()) {
            ProduitDto produitDto = listeProduitDto.next();
            ProduitCommandeDo produitCommandedo = iProduitService.addProduitCommande(produitDto);

            LigneCommandeDo ligneCommandeDo = new LigneCommandeDo();
            ligneCommandeDo.setCommandeDo(commandeDo);
            ligneCommandeDo.setProduitCdeDo(produitCommandedo);
            ligneCommandeDo.setQuantite(mapProduitDto.get(produitDto).getQuantite());

            ligneCommandeDo = commandeDao.addLigneCommande(ligneCommandeDo);
        }

        return commandeDo;
    }

    @Override
    public List<CommandeDto> findAllCommandeByUtilisateur(final int id) {
        // on r�cup�re la Dao qui permettra de communiquer avec la base de donn�es
        ICommandeDao commandeDao = MyFactory.getInstance(ICommandeDao.class);

        // on demande la liste des commandes pour l'id d'utilisateur re�u en param�tre
        List<CommandeDo> listeCommandeDo = commandeDao.findAllCommandeByUtilisateur(id);

        // on convertit la liste de CommandeDo en liste de CommandeDto
        return MapperDoToCommandeDto.mapperListDoDto(listeCommandeDo);
    }

    @Override
    public List<CommandeDto> findAllCommande() {
        // on r�cup�re la Dao qui permettra de communiquer avec la base de donn�es
        ICommandeDao commandeDao = MyFactory.getInstance(ICommandeDao.class);

        // on demande la liste de toutes les commandes
        List<CommandeDo> listeCommandeDo = commandeDao.findAllCommande();

        // on convertit la liste de CommandeDo en liste de CommandeDto
        return MapperDoToCommandeDto.mapperListDoDto(listeCommandeDo);
    }

    @Override
    public CommandeDetailDto findDetailCommande(final int idCommande) {
        // on r�cup�re la Dao qui permettra de communiquer avec la base de donn�es
        ICommandeDao commandeDao = MyFactory.getInstance(ICommandeDao.class);

        // on demande la commande pour l'id de commande re�u en param�tre
        CommandeDo commandeDo = commandeDao.findCommande(idCommande);

        // on convertit la CommandeDo en CommandeDetailDto
        return MapperDoToCommandeDetailDto.mapperDotoCommandeDetailDto(commandeDo);
    }

    @Override
    public boolean supprimerAssociation(final int idUser) {
        // on r�cup�re la Dao qui permettra de communiquer avec la base de donn�es
        ICommandeDao commandeDao = MyFactory.getInstance(ICommandeDao.class);

        return commandeDao.supprimerAssociation(idUser);
    }
}
