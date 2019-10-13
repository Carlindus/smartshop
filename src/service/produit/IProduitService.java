/**
 * 
 */
package service.produit;

import java.io.IOException;
import java.util.List;

import persistance.produit.bean.ProduitCommandeDo;
import presentation.produit.bean.ProduitDto;

/**
 * @author Formation
 *
 */
public interface IProduitService {

    /**
     * @return
     */
    List<ProduitDto> findAllProduitEnVente();

    /**
     * @param id
     * @return
     */
    ProduitDto findProduit(final int id);

    /**
     * @return
     */
    List<ProduitDto> findAllProduit();

    /**
     * @param produitDto
     * @return
     */
    boolean addProduit(final ProduitDto produitDto);

    /**
     * @param produitDto
     * @return
     * @throws IOException
     */
    boolean addPicture(final ProduitDto produitDto) throws IOException;

    /**
     * @param produitDto
     * @return
     */

    boolean deleteProduit(final ProduitDto produitDto);

    /**
     * @param produitDto
     * @return
     */
    boolean updateProduit(final ProduitDto produitDto);

    /**
     * @param produitDo
     * @return
     */

    ProduitCommandeDo addProduitCommande(final ProduitDto produitDto);

    /**
     * @return
     */

    List<ProduitCommandeDo> findAllProduitCommande();

    /**
     * @param idProduitCommande
     * @return
     * 
     */

    ProduitCommandeDo findProduitCommande(int idProduitCommande);

    /**
     * @param produitCommandeDo
     * @return
     * 
     */

    ProduitDto mapperProduitCommandeDoToProduitDto(ProduitCommandeDo produitCommandeDo);

}