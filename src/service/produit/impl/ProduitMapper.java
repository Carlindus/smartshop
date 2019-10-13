package service.produit.impl;

import java.util.ArrayList;
import java.util.List;

import persistance.image.bean.ImageDo;
import persistance.produit.bean.ProduitCommandeDo;
import persistance.produit.bean.ProduitDo;
import presentation.produit.bean.ProduitDto;

/**
 * @author Ian
 *
 */
public class ProduitMapper {

    /**
     * Converti un produitDo en produitDto
     * 
     * @param produitDo
     * @return produitDto
     */
    public static ProduitDto mapProduitDoToProduitDto(final ProduitDo produitDo) {
        ProduitDto produitDto = new ProduitDto();
        if (produitDo != null) {
            produitDto.setDescription(produitDo.getDescription());
            produitDto.setEtat(produitDo.getEtat());
            produitDto.setIdProduit(produitDo.getIdProduit());
            if (produitDo.getImage() != null) {
                produitDto.setImage(produitDo.getImage());
            } else {
                produitDto.setImage("imageFictive.jpg");
            }
            produitDto.setPrix(produitDo.getPrix());
            produitDto.setReference(produitDo.getReference());
        }
        return produitDto;
    }

    /**
     * Converti une liste de produitDo en liste de produitDto
     * 
     * @param listeProduitDo
     * @return listeProduitDto
     */
    public static List<ProduitDto> mapListProduitDoToListProduitDto(final List<ProduitDo> listeProduitDo) {
        List<ProduitDto> listeProduitDto = new ArrayList<>();
        if (listeProduitDo != null) {
            for (ProduitDo produitDo : listeProduitDo) {
                if (produitDo != null) {
                    listeProduitDto.add(mapProduitDoToProduitDto(produitDo));
                }
            }
        }
        return listeProduitDto;
    }

    /**
     * Converti un produitDto en produitDo
     * 
     * @param produitDto
     * @return produitDo
     */
    public static ProduitDo mapProduitDtoToProduitDo(final ProduitDto produitDto) {
        ProduitDo produitDo = new ProduitDo();
        if (produitDto != null) {
            produitDo.setDescription(produitDto.getDescription());
            produitDo.setEtat(produitDto.getEtat());
            produitDo.setIdProduit(produitDto.getIdProduit());
            // produitDo.setImage(produitDto.getImage());
            produitDo.setPrix(produitDto.getPrix());
            produitDo.setReference(produitDto.getReference());
        }
        return produitDo;
    }

    /**
     * Converti un produitCommandeDo en produitDto
     * 
     * @param produitCommandeDo
     * @return produitDto
     */
    public static ProduitDto mapProduitCommandeDoToProduitDto(final ProduitCommandeDo produitCommandeDo) {
        ProduitDto produitDto = new ProduitDto();
        if (produitCommandeDo != null) {
            produitDto.setDescription(produitCommandeDo.getDescription());
            produitDto.setIdProduit(produitCommandeDo.getIdProduit());
            // produitDto.setImage(produitCommandeDo.getImage());
            produitDto.setPrix(produitCommandeDo.getPrix());
            produitDto.setReference(produitCommandeDo.getReference());
        }
        return produitDto;
    }

    /**
     * @param produitDto
     * @return
     */
    public static ProduitCommandeDo mapProduitDtoToProduitCommandeDo(final ProduitDto produitDto) {
        ProduitCommandeDo produitCommandeDo = new ProduitCommandeDo();
        if (produitDto != null) {
            produitCommandeDo.setDescription(produitDto.getDescription());
            produitCommandeDo.setIdProduit(produitDto.getIdProduit());
            // produitCommandeDo.setImage(produitDto.getImage());
            produitCommandeDo.setPrix(produitDto.getPrix());
            produitCommandeDo.setReference(produitDto.getReference());
        }
        return produitCommandeDo;
    }

    /**
     * @param produitDto
     * @return
     */
    public static ImageDo produitDtoToImageDo(final ProduitDto produitDto) {
        ImageDo imageDo = new ImageDo();
        if (produitDto != null) {
            imageDo.setImageName(produitDto.getImage());
            imageDo.setImageData(produitDto.getData());
        }
        return imageDo;
    }
}
