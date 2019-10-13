/**
 * 
 */
package presentation.commande.bean;

import java.util.Map;

import presentation.panier.bean.DetailProduitPanierDto;
import presentation.produit.bean.ProduitDto;

/**
 * @author Jonathan
 *
 */
public class CommandeDetailDto {
    private CommandeDto commandeDto;
    private Map<ProduitDto, DetailProduitPanierDto> mapDetailProduitPanier;
    
    /**
     * @return the commandeDto
     */
    public CommandeDto getCommandeDto() {
        return commandeDto;
    }
    
    /**
     * @param commandeDto the commandeDto to set
     */
    public void setCommandeDto(final CommandeDto commandeDto) {
        this.commandeDto = commandeDto;
    }
    
    /**
     * @return the mapDetailProduitPanier
     */
    public Map<ProduitDto, DetailProduitPanierDto> getMapDetailProduitPanier() {
        return mapDetailProduitPanier;
    }
    
    /**
     * @param mapDetailProduitPanier the mapDetailProduitPanier to set
     */
    public void setMapDetailProduitPanier(final Map<ProduitDto, DetailProduitPanierDto> mapDetailProduitPanier) {
        this.mapDetailProduitPanier = mapDetailProduitPanier;
    }
    
}
