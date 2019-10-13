/**
 * 
 */
package presentation.panier.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import presentation.panier.bean.PanierDto;
import presentation.utilisateur.action.ConnexionAction;
import service.panier.IPanierService;
import util.MyFactory;

/**
 * @author Jonathan
 *
 */
public class IncrementerPanierAction extends Action {

    private static final String FORWARD_SUCCESS = "success";

    /**
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, 
            final HttpServletResponse response) throws Exception {
        // r�cup�ration de l'id du produit dans les param�tres
        final int idProduit = Integer.parseInt(request.getParameter("idProduit"));
        
        // r�cup�ration de la session et le panier dans la session
        final HttpSession session = request.getSession();
        final PanierDto panierDto = (PanierDto) session.getAttribute(ConnexionAction.MAP_PANIER_SESSION);
        
        // r�cup�ration du service panier et appel de la m�thode d'incr�mentation de la quantit� d'un produit
        final IPanierService panierService = MyFactory.getInstance(IPanierService.class);
        final PanierDto panierResultat = panierService.increaseQuantity(idProduit, panierDto);
        
        // on met le nouveau panier dans la session
        session.setAttribute(ConnexionAction.MAP_PANIER_SESSION, panierResultat);
        
        // on appelle la mise � jour de la page
        return mapping.findForward(FORWARD_SUCCESS);
    }
}
