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
public class SupprimerLignePanierAction extends Action {

    private static final String FORWARD_SUCCESS = "success";

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse)
     */
    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        // récupération de l'id du produit dans les paramètres
        final int idProduit = Integer.parseInt(request.getParameter("idProduit"));
        
        // récupération de la session et le panier dans la session
        final HttpSession session = request.getSession();
        final PanierDto panierDto = (PanierDto) session.getAttribute(ConnexionAction.MAP_PANIER_SESSION);
        
        // récupération du service panier et appel de la méthode de suppression d'un produit
        final IPanierService panierService = MyFactory.getInstance(IPanierService.class);
        final PanierDto panierResultat = panierService.removeProduit(idProduit, panierDto);
        
        // on met le nouveau panier dans la session
        session.setAttribute(ConnexionAction.MAP_PANIER_SESSION, panierResultat);
        
        // on appelle la mise à jour de la page
        return mapping.findForward(FORWARD_SUCCESS);
    }

}
