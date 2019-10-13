package presentation.panier.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import presentation.panier.bean.PanierDto;
import presentation.utilisateur.action.ConnexionAction;
import service.panier.IPanierService;
import util.MyFactory;

/**
 * Action V�rifiant le contenu du panier
 * 
 * @author Guillaume
 *
 */
public class ValiderPanierAction extends Action {

    HttpSession session;

    private static final String FORWARD_SUCCESS = "success";
    private static final String FORWARD_ERROR   = "error";

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.struts.action.Action#execute(org.apache.struts.action.
     * ActionMapping, org.apache.struts.action.ActionForm,
     * javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse)
     */
    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) {

        System.out.println("@ValiderPanierAction");

        session = request.getSession(true);
        final IPanierService iPanierService = MyFactory.getInstance(IPanierService.class);
        PanierDto panierDto = (PanierDto) session.getAttribute(ConnexionAction.MAP_PANIER_SESSION);
        boolean booleanProduitDto = iPanierService.verifierPanierDto(panierDto);
        if (!booleanProduitDto) {
            PanierDto panierDtoModif = iPanierService.updateProduitsPanier(panierDto);
            session.setAttribute(ConnexionAction.MAP_PANIER_SESSION, panierDtoModif);
            final ActionMessages messages = new ActionMessages();
            messages.add("validerPanier.erreur ", new ActionMessage("validerPanier.erreur"));
            saveMessages(request, messages);
            return mapping.findForward(FORWARD_ERROR);
        }
        return mapping.findForward(FORWARD_SUCCESS);
    }
}