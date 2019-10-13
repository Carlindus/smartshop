/**
 * 
 */
package presentation.produit.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import presentation.produit.bean.ProduitDto;
import service.produit.IProduitService;
import util.MyFactory;

/**
 * @author Ian
 *
 */
public class VoirListeProduitAccueilAction extends Action {

    /**
     * nom de l'attribut pour avoir la liste des produits en vente
     */
    public static final String LISTE_PRODUIT_DTO = "listeProduitDto";
    private static final String FORWARD_SUCCESS = "success";

    /**
     * Recupere la liste des produits en vente dans la BDD, l'insert dans la requete et forward vers la JSP associé
     */
   @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
       IProduitService produitService = MyFactory.getInstance(IProduitService.class);
       List<ProduitDto> listeProduitDto = produitService.findAllProduitEnVente();
       request.setAttribute(LISTE_PRODUIT_DTO, listeProduitDto);
       return mapping.findForward(FORWARD_SUCCESS);
    }

}
