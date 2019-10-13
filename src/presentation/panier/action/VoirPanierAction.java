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
 * Action mettant à disposition le contenu du panier
 * 
 * @author Jonathan
 *
 */
public class VoirPanierAction extends Action {

    private static final String FORWARD_SUCCESS = "success";

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse)
     */
    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) {
        // récupération de la session
        final HttpSession session = request.getSession();
        
        // récupération du panier dans la session
        final PanierDto panierDto = (PanierDto) session.getAttribute(ConnexionAction.MAP_PANIER_SESSION);
        
        // appel de la jsp
        return mapping.findForward(FORWARD_SUCCESS);
    }
}
