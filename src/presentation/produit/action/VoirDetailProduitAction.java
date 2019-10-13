/**
 * 
 */
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
 * @author Alexy
 *
 */
public class VoirDetailProduitAction extends Action {

    private static final String FORWARD_SUCCESS = "success";
    
    public static final String FIND_PRODUIT = "produit";
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        IProduitService produitService = MyFactory.getInstance(IProduitService.class);
        int idProduit = Integer.parseInt(request.getParameter("id"));
        ProduitDto produit = produitService.findProduit(idProduit);
        
        request.setAttribute(FIND_PRODUIT,produit);
        
        return mapping.findForward(FORWARD_SUCCESS);
    }

}
