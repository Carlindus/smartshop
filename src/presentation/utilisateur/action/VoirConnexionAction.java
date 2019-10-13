/**
 * 
 */
package presentation.utilisateur.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import presentation.utilisateur.bean.ConnectedUserDto;
import presentation.utilisateur.bean.UtilisateurDto;
import service.utilisateur.IUtilisateurService;
import util.MyFactory;

/**
 * @author Ahmed
 *
 */
public class VoirConnexionAction extends Action {

    private static final String FORWARD_SUCCESS       = "success";
    private static final String FORWARD_CONNECT_ADMIN = "successConnecteAdmin";
    private static final String FORWARD_CONNECT       = "successConnecte";

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse)
     */
    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {

        final HttpSession session = request.getSession();


        return mapping.findForward(FORWARD_SUCCESS);

    }

}
