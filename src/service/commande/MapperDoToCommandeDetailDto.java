/**
 * 
 */
package service.commande;

import java.util.HashMap;
import java.util.Map;

import persistance.commande.bean.CommandeDo;
import persistance.commande.bean.LigneCommandeDo;
import persistance.produit.bean.ProduitCommandeDo;
import presentation.commande.bean.CommandeDetailDto;
import presentation.commande.bean.CommandeDto;
import presentation.panier.bean.DetailProduitPanierDto;
import presentation.produit.bean.ProduitDto;
import service.panier.IPanierService;
import service.produit.IProduitService;
import util.MyFactory;

/**
 * @author Guilaume
 *
 */
public class MapperDoToCommandeDetailDto {

	/**
	 * Constructor
	 */
	public MapperDoToCommandeDetailDto() {
		// Empty
	}
	
	/**
	 * Convert commandeDo to commandeDetailDto
	 * @param commandeDo
	 * @return commandeDetailDto
	 */
    public static CommandeDetailDto mapperDotoCommandeDetailDto(final CommandeDo commandeDo) {
    	CommandeDetailDto commandeDetailDto = new CommandeDetailDto();
    	CommandeDto commandeDto = MapperDoToCommandeDto.mapperDoDto(commandeDo);
    	Map<ProduitDto, DetailProduitPanierDto> mapDetailProduitPanier = new HashMap<ProduitDto, DetailProduitPanierDto>();
    	IProduitService iProduitService = MyFactory.getInstance(IProduitService.class);
    	for (LigneCommandeDo ligneCommandeDo : commandeDo.getLigneCommandeSet()) {
    		ProduitDto produitDto = iProduitService.mapperProduitCommandeDoToProduitDto(ligneCommandeDo.getProduitCdeDo());
        	DetailProduitPanierDto detailProduitPanierDto = new DetailProduitPanierDto();
        	detailProduitPanierDto.setMontantLigne(produitDto.getPrix()*ligneCommandeDo.getQuantite());
        	detailProduitPanierDto.setQuantite(ligneCommandeDo.getQuantite());
        	mapDetailProduitPanier.put(produitDto, detailProduitPanierDto);
		}    	
    	commandeDetailDto.setCommandeDto(commandeDto);
    	commandeDetailDto.setMapDetailProduitPanier(mapDetailProduitPanier);
        return commandeDetailDto;
    }
}
