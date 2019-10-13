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
import org.apache.struts.action.ActionRedirect;

import presentation.panier.bean.PanierDto;
import presentation.utilisateur.action.ConnexionAction;
import service.panier.IPanierService;
import util.MyFactory;

/**
 * @author Jonathan
 *
 */
public class AjouterProduitAction extends Action {
    
    /**
     * 
     */
    private static final String FORWARD_SUCCESS_DETAIL = "successFromDetail";
    /**
     * 
     */
    private static final String FORWARD_SUCCESS_LIST   = "successFromList";

    /**
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, 
            final HttpServletResponse response) throws Exception {
        // r�cup�ration de l'id du produit et le num�ro de la jsp dans les param�tres
        final int idProduit = Integer.parseInt(request.getParameter("idProduit"));
        final String numeroJsp = request.getParameter("nb");
        
        // r�cup�ration de la session et le panier dans la session
        final HttpSession session = request.getSession();
        final PanierDto panier = (PanierDto) session.getAttribute(ConnexionAction.MAP_PANIER_SESSION);
        
        // r�cup�ration du service panier et appel de la m�thode d'ajout d'un produit
        final IPanierService panierService = MyFactory.getInstance(IPanierService.class);
        final PanierDto panierResultat = panierService.ajouterProduitPanier(idProduit, panier);
        
        // on met le nouveau panier dans la session
        session.setAttribute(ConnexionAction.MAP_PANIER_SESSION, panierResultat);
        
        // Si le client est sur la page d�tail, on sauvegarde les param�tres pour le retour � cette page
        if (numeroJsp.equals("1")) {
            final ActionRedirect redirect = new ActionRedirect(mapping.findForward(FORWARD_SUCCESS_DETAIL));
            redirect.addParameter("id", idProduit);
            redirect.addParameter("nb", 1);
            redirect.addParameter("back", "accueil");
            return redirect;
        }
        
        return mapping.findForward(FORWARD_SUCCESS_LIST);
    }

}
