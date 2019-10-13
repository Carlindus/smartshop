/**
 * 
 */
package service.panier.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import presentation.panier.bean.DetailProduitPanierDto;
import presentation.panier.bean.PanierDto;
import presentation.produit.bean.ProduitDto;
import service.panier.IPanierService;
import service.produit.IProduitService;
import util.MyFactory;

/**
 * @author Jonathan
 *
 */
public class PanierService implements IPanierService {

    private static final BigDecimal DIX_POURCENT          = BigDecimal.valueOf(0.1);
    private static final double     SEUIL_PRIX_REMISE     = 100;
    private static final int        SEUIL_PRODUITS_REMISE = 5;

    private PanierService() {
        // empty method
    }

    /**
     * @return
     */
    public static IPanierService getInstance() {
        return new PanierService();
    }

    /**
     * @param idProduit
     * @param panier
     * @return
     */
    @Override
    public PanierDto ajouterProduitPanier(final int idProduit, final PanierDto panier) {
        // on r�cup�re le panier et la map
        PanierDto panierResultat = panier;
        Map<ProduitDto, DetailProduitPanierDto> mapProduitDto = panierResultat.getMapProduitDto();

        ProduitDto produitDto = null;
        DetailProduitPanierDto detailProduitPanierDto = null;

        // on parcourt la liste des produits dans le panier (cl�s de ma map)
        Iterator<ProduitDto> listeProduitDto = mapProduitDto.keySet().iterator();
        boolean trouve = false;
        while (listeProduitDto.hasNext() && !trouve) {
            produitDto = (ProduitDto) listeProduitDto.next();
            if (produitDto.getIdProduit() == idProduit) {
                trouve = true;
                detailProduitPanierDto = mapProduitDto.get(produitDto);
            }

        }

        if (!trouve) {
            // on r�cup�re le service des produits
            IProduitService produitService = MyFactory.getInstance(IProduitService.class);
            // on r�cup�re le produit avec le service dans la BDD
            produitDto = produitService.findProduit(idProduit);

            detailProduitPanierDto = new DetailProduitPanierDto();
            detailProduitPanierDto.setQuantite(0);
            detailProduitPanierDto.setMontantLigne(0);
        }

        // on incr�mente la quantit� et le montant de la ligne
        detailProduitPanierDto.setQuantite(detailProduitPanierDto.getQuantite() + 1);
        detailProduitPanierDto.setMontantLigne(detailProduitPanierDto.getMontantLigne() + produitDto.getPrix());

        // on ins�re les nouvelles valeurs dans la map
        mapProduitDto.put(produitDto, detailProduitPanierDto);

        // on affecte la nouvelle map au panier
        panierResultat.setMapProduitDto(mapProduitDto);

        // on recalcule les nouveaux prix du paniers
        panierResultat = calculPanier(panierResultat, BigDecimal.valueOf(produitDto.getPrix()));

        return panierResultat;
    }

    /*
     * (non-Javadoc)
     * 
     * @see service.panier.IPanierService#increaseQuantity(int, presentation.panier.bean.PanierDto)
     */
    @Override
    public PanierDto increaseQuantity(final int idProduit, final PanierDto panier) {
        // on r�cup�re le panier et la map
        PanierDto panierResultat = panier;
        Map<ProduitDto, DetailProduitPanierDto> mapProduitDto = panierResultat.getMapProduitDto();

        ProduitDto produitDto = null;
        DetailProduitPanierDto detailProduitPanierDto = null;

        // on parcourt la liste des produits dans le panier (cl�s de ma map)
        Iterator<ProduitDto> listeProduitDto = mapProduitDto.keySet().iterator();
        boolean trouve = false;
        while (listeProduitDto.hasNext() && !trouve) {
            produitDto = (ProduitDto) listeProduitDto.next();
            if (produitDto.getIdProduit() == idProduit) {
                trouve = true;
                detailProduitPanierDto = mapProduitDto.get(produitDto);
            }

        }

        // on incr�mente la quantit� et le montant de la ligne
        detailProduitPanierDto.setQuantite(detailProduitPanierDto.getQuantite() + 1);
        detailProduitPanierDto.setMontantLigne(detailProduitPanierDto.getMontantLigne() + produitDto.getPrix());

        // on ins�re les nouvelles valeurs dans la map
        mapProduitDto.put(produitDto, detailProduitPanierDto);

        // on affecte la nouvelle map au panier
        panierResultat.setMapProduitDto(mapProduitDto);

        // on recalcule les nouveaux prix du paniers
        panierResultat = calculPanier(panierResultat, BigDecimal.valueOf(produitDto.getPrix()));

        return panierResultat;
    }

    /*
     * (non-Javadoc)
     * 
     * @see service.panier.IPanierService#decreaseQuantity(int, presentation.panier.bean.PanierDto)
     */
    @Override
    public PanierDto decreaseQuantity(final int idProduit, final PanierDto panier) {
        // on r�cup�re le panier et la map
        PanierDto panierResultat = panier;
        Map<ProduitDto, DetailProduitPanierDto> mapProduitDto = panierResultat.getMapProduitDto();

        ProduitDto produitDto = null;
        DetailProduitPanierDto detailProduitPanierDto = null;

        // on parcourt la liste des produits dans le panier (cl�s de ma map)
        Iterator<ProduitDto> listeProduitDto = mapProduitDto.keySet().iterator();
        boolean trouve = false;
        while (listeProduitDto.hasNext() && !trouve) {
            produitDto = (ProduitDto) listeProduitDto.next();
            if (produitDto.getIdProduit() == idProduit) {
                trouve = true;
                detailProduitPanierDto = mapProduitDto.get(produitDto);
            }

        }

        // On d�cr�mente la quantit� ainsi que le montant de la ligne
        detailProduitPanierDto.setQuantite(detailProduitPanierDto.getQuantite() - 1);
        detailProduitPanierDto.setMontantLigne(detailProduitPanierDto.getMontantLigne() - produitDto.getPrix());

        // si la nouvelle quantit� est positive, on applique la modification de quantit�
        // si elle est nulle, on retire le produit de la map
        if (detailProduitPanierDto.getQuantite() > 0) {
            mapProduitDto.put(produitDto, detailProduitPanierDto);
        } else {
            mapProduitDto.remove(produitDto);
        }

        // on affecte la nouvelle map au panier
        panierResultat.setMapProduitDto(mapProduitDto);

        // on recalcule les nouveaux prix du paniers
        panierResultat = calculPanier(panierResultat, BigDecimal.valueOf(-produitDto.getPrix()));

        return panierResultat;
    }

    /*
     * (non-Javadoc)
     * 
     * @see service.panier.IPanierService#removeProduit(int, presentation.panier.bean.PanierDto)
     */
    @Override
    public PanierDto removeProduit(final int idProduit, final PanierDto panier) {
        // on r�cup�re le panier et la map
        PanierDto panierResultat = panier;
        Map<ProduitDto, DetailProduitPanierDto> mapProduitDto = panierResultat.getMapProduitDto();

        ProduitDto produitDto = null;
        DetailProduitPanierDto detailProduitPanierDto = null;

        // on parcourt la liste des produits dans le panier (cl�s de ma map)
        Iterator<ProduitDto> listeProduitDto = mapProduitDto.keySet().iterator();
        boolean trouve = false;
        while (listeProduitDto.hasNext() && !trouve) {
            produitDto = (ProduitDto) listeProduitDto.next();
            if (produitDto.getIdProduit() == idProduit) {
                trouve = true;
            }
        }

        // on "sauvegarde" la quantit� avant de retirer le produit de la map
        int quantite = mapProduitDto.get(produitDto).getQuantite();

        // on retire le produit de la map du panier
        mapProduitDto.remove(produitDto);

        // on affecte la nouvelle map au panier
        panierResultat.setMapProduitDto(mapProduitDto);

        // on recalcule les nouveaux prix du paniers
        panierResultat = calculPanier(panierResultat, BigDecimal.valueOf(-produitDto.getPrix() * quantite));

        return panierResultat;
    }

    /*
     * @see service.panier.IPanierService#cleanPanier(presentation.panier.bean.PanierDto)
     */
    @Override
    public PanierDto cleanPanier(final PanierDto panierRempli) {
        // on r�cup�re le service des produits
        IProduitService produitService = MyFactory.getInstance(IProduitService.class);

        // on r�cup�re le panier et la map
        PanierDto panierResultat = panierRempli;
        Map<ProduitDto, DetailProduitPanierDto> mapProduitDto = panierResultat.getMapProduitDto();

        // on vide les produits de la map
        mapProduitDto.clear();

        // on affecte la nouvelle map au panier
        panierResultat.setMapProduitDto(mapProduitDto);

        // on recalcule les nouveaux prix du paniers
        panierResultat = calculPanier(panierResultat, BigDecimal.valueOf(-panierResultat.getMontantTotal()));

        return panierResultat;
    }

    @Override
    public PanierDto updateProduitsPanier(final PanierDto panier) {
        // on r�cup�re le service des produits
        IProduitService produitService = MyFactory.getInstance(IProduitService.class);

        // on r�cup�re le panier et la map
        PanierDto panierResultat = panier;
        Map<ProduitDto, DetailProduitPanierDto> mapProduitDto = panierResultat.getMapProduitDto();

        // on initialise la map r�sultat
        Map<ProduitDto, DetailProduitPanierDto> mapResultat = new HashMap<ProduitDto, DetailProduitPanierDto>();

        // on parcours la liste des produits dans le panier (cl�s de ma map)
        for (ProduitDto produitDto : mapProduitDto.keySet()) {
            // on r�cup�re la derni�re version des produits dans la BDD mais on garde le detailProduit actuel
            ProduitDto produitResultat = produitService.findProduit(produitDto.getIdProduit());
            DetailProduitPanierDto detailResultat = mapProduitDto.get(produitDto);

            // on met � jour le prix du detail
            detailResultat.setMontantLigne(produitDto.getPrix() * detailResultat.getQuantite());

            // on ajoute le nouvel �l�ment � la map
            mapResultat.put(produitResultat, detailResultat);
        }

        // on affecte la nouvelle map au panier
        panierResultat.setMapProduitDto(mapProduitDto);

        return panierResultat;
    }

    @Override
    public boolean verifierPanierDto(final PanierDto panier) {
        // on r�cup�re la map des produits
        Map<ProduitDto, DetailProduitPanierDto> mapProduitDto = panier.getMapProduitDto();

        // on parcourt les cl�s de la map (~ liste des produits)
        Iterator<ProduitDto> listeProduitDto = mapProduitDto.keySet().iterator();
        while (listeProduitDto.hasNext()) {
            ProduitDto produitDto = (ProduitDto) listeProduitDto.next();
            // on v�rifie que le produit correspond � celui de la BDD
            // si il ne correspond pas, on return false
            if (!verifierProduitDto(produitDto))
                return false;
        }

        // si tous les produits sont valides, on return true
        return true;

    }

    private boolean verifierProduitDto(final ProduitDto produit) {
        // on r�cup�re le service des produits pour r�cup�rer le produit dans la BDD
        IProduitService produitService = MyFactory.getInstance(IProduitService.class);
        ProduitDto produitBdd = produitService.findProduit(produit.getIdProduit());

        // si le produit n'existe plus ou n'est plus en vente on return false
        if (produitBdd == null || !produitBdd.getEtat())
            return false;

        // on v�rifie les champs un par un et si l'un d'eux ne correspond pas, on return false
        if (!produit.getDescription().equals(produitBdd.getDescription()) || produit.getPrix() != produitBdd.getPrix() || !produit.getReference().equals(produitBdd.getReference()))
            return false;

        // on return true si le produit a �t� valid�
        return true;
    }

    /**
     * @param panier
     * @return le montant de la remise
     */
    private BigDecimal calculerRemise(final PanierDto panier) {
        // init du compteur de produits
        int nbProduits = 0;

        // comptage du nombre de produits
        for (Map.Entry<ProduitDto, DetailProduitPanierDto> entry : panier.getMapProduitDto().entrySet()) {
            nbProduits += entry.getValue().getQuantite();
        }

        // v�rification du droit � la remise selon les conditons

        if (nbProduits >= this.SEUIL_PRODUITS_REMISE && panier.getMontantTotal() >= this.SEUIL_PRIX_REMISE) {
            // application de la remise
            return this.DIX_POURCENT;
        }

        // remise nulle
        return BigDecimal.valueOf(0);
    }

    /**
     * @param panier
     * @param prix
     *            (positif ou negatif)
     *            calcule le prixTotal, montantRemise et montantAPayer
     */

    private PanierDto calculPanier(final PanierDto panier, final BigDecimal prix) {
        PanierDto panierResultat = panier;

        // le prix passe sera positif pour ajouter ou negatif pour soustraire du prixTotal
        panierResultat.setMontantTotal(panierResultat.getMontantTotal() + prix.doubleValue());

        // calcul remisePanier
        panierResultat.setMontantRemise(this.calculerRemise(panierResultat).doubleValue());

        // calcul montant-a-payer
        panierResultat.setMontantAPayer(panierResultat.getMontantTotal() * (1 - panierResultat.getMontantRemise()));

        return panierResultat;
    }

}