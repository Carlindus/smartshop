/**
 * 
 */
package service.produit.impl;

import java.util.List;

import persistance.produit.bean.ProduitCommandeDo;
import persistance.produit.bean.ProduitDo;
import persistance.produit.dao.IProduitDao;
import presentation.produit.bean.ProduitDto;
import service.produit.IProduitService;
import util.MyFactory;

/**
 * @author Alexy
 *
 */
public class ProduitService implements IProduitService {

    /**
     * @return
     */
    public static IProduitService getInstance() {
        return new ProduitService();
    }

    /*
     * (non-Javadoc)
     * 
     * @see service.produit.IProduitService#findAllProduitEnVente()
     */
    @Override
    public List<ProduitDto> findAllProduitEnVente() {
        IProduitDao produitDao = MyFactory.getInstance(IProduitDao.class);
        List<ProduitDo> listeProduitDo = produitDao.findAllProduitEnVente();

        List<ProduitDto> listProduitDto = ProduitMapper.mapListProduitDoToListProduitDto(listeProduitDo);

        return listProduitDto;
    }

    /*
     * (non-Javadoc)
     * 
     * @see service.produit.IProduitService#findAllProduit()
     */
    @Override
    public List<ProduitDto> findAllProduit() {
        IProduitDao produitDao = MyFactory.getInstance(IProduitDao.class);
        List<ProduitDo> listeProduitDo = produitDao.findAllProduit();

        List<ProduitDto> listProduitDto = ProduitMapper.mapListProduitDoToListProduitDto(listeProduitDo);

        return listProduitDto;
    }

    /*
     * (non-Javadoc)
     * 
     * @see service.produit.IProduitService#findProduit(int)
     */
    @Override
    public ProduitDto findProduit(final int id) {
        IProduitDao produitDao = MyFactory.getInstance(IProduitDao.class);
        ProduitDo produitDo = produitDao.findProduit(id);

        ProduitDto produitDto = ProduitMapper.mapProduitDoToProduitDto(produitDo);

        return produitDto;
    }

    @Override
    public boolean addProduit(ProduitDto produitDto) {
        IProduitDao produitDao = MyFactory.getInstance(IProduitDao.class);
        /*
         * if (!addPicture(produitDto)) {
         * return false;
         * }
         */
        ProduitDo produitDo = produitDao.addProduit(ProduitMapper.mapProduitDtoToProduitDo(produitDto));

        if ((produitDo != null) && (produitDo.getReference() != null)) {
            return true;
        }

        return false;
    }

    @Override
    public boolean addPicture(ProduitDto produitDto) {
        // TODO uncommentTodo this part
        // IImageDao imageDao = MyFactory.getInstance(IImageDao.class);
        try {
            // return imageDao.stockerImageDisqueDur(ProduitMapper.produitDtoToImageDo(produitDto));
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    @Override
    public boolean updateProduit(ProduitDto produitDto) {
        IProduitDao produitDao = MyFactory.getInstance(IProduitDao.class);
        int idProduit = produitDto.getIdProduit();
        if (!addPicture(produitDto)) {
            return false;
        }
        if (produitDao.updateProduit(idProduit, ProduitMapper.mapProduitDtoToProduitDo(produitDto)) != null) {
            return true;
        }
        return false;

    }

    @Override
    public ProduitCommandeDo addProduitCommande(ProduitDto produitDto) {
        IProduitDao produitDao = MyFactory.getInstance(IProduitDao.class);

        ProduitCommandeDo produitCommande = produitDao.addProduitCommande(ProduitMapper.mapProduitDtoToProduitCommandeDo(produitDto));

        if ((produitCommande != null) && (produitCommande.getIdProduitCde() != 0)) {
            return produitCommande;
        }
        return null;
    }

    @Override
    public List<ProduitCommandeDo> findAllProduitCommande() {
        IProduitDao produitDao = MyFactory.getInstance(IProduitDao.class);

        List<ProduitCommandeDo> listeProduitCommande = produitDao.findAllProduitCommande();

        return listeProduitCommande;

    }

    @Override
    public ProduitCommandeDo findProduitCommande(int idProduitCommande) {
        IProduitDao produitDao = MyFactory.getInstance(IProduitDao.class);

        ProduitCommandeDo produitCommande = produitDao.findProduitCommande(idProduitCommande);

        return produitCommande;
    }

    @Override
    public ProduitDto mapperProduitCommandeDoToProduitDto(ProduitCommandeDo produitCommande) {
        ProduitDto produitDto = ProduitMapper.mapProduitCommandeDoToProduitDto(produitCommande);

        return produitDto;
    }

    @Override
    public boolean deleteProduit(ProduitDto produitDto) {
        IProduitDao produitDao = MyFactory.getInstance(IProduitDao.class);

        return produitDao.deleteProduit(produitDto.getIdProduit());
    }

}
