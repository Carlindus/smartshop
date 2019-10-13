package presentation.produit.action;

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
 * @author Michelle
 *
 */
public class SupprimerProduitAction extends Action{

    private final String FORWARD_SUCCESS = "success";
    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, 
                                HttpServletRequest request, HttpServletResponse response)
                                throws Exception  {
        //Récupérer le paramètre de la requête (jsp)
        String idParam = request.getParameter("id");
        int id = Integer.parseInt(idParam);
        IProduitService produitService = MyFactory.getInstance(IProduitService.class);
        ProduitDto produit = produitService.findProduit(id);
        produitService.deleteProduit(produit);
        
        return mapping.findForward(FORWARD_SUCCESS);
    }
}
