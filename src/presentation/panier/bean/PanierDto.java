package presentation.panier.bean;

import java.util.Map;

import presentation.produit.bean.ProduitDto;

/**
 * @author kevin
 *
 */
public class PanierDto {

    private double                                  montantTotal;
    private double                                  montantRemise;
    private double                                  montantAPayer;
    private Map<ProduitDto, DetailProduitPanierDto> mapProduitDto;

    /**
     * 
     */
    public PanierDto() {
        super();
    }

    /**
     * @return
     */
    public double getMontantTotal() {
        return montantTotal;
    }

    /**
     * @param montantTotal
     */
    public void setMontantTotal(double montantTotal) {
        this.montantTotal = montantTotal;
    }

    /**
     * @return
     */
    public double getMontantRemise() {
        return montantRemise;
    }

    /**
     * @param montantRemise
     */
    public void setMontantRemise(double montantRemise) {
        this.montantRemise = montantRemise;
    }

    /**
     * @return
     */
    public double getMontantAPayer() {
        return montantAPayer;
    }

    /**
     * @param montantAPayer
     */
    public void setMontantAPayer(double montantAPayer) {
        this.montantAPayer = montantAPayer;
    }

    /**
     * @return
     */
    public Map<ProduitDto, DetailProduitPanierDto> getMapProduitDto() {
        return mapProduitDto;
    }

    /**
     * @param mapProduitDto
     */
    public void setMapProduitDto(Map<ProduitDto, DetailProduitPanierDto> mapProduitDto) {
        this.mapProduitDto = mapProduitDto;
    }

}
