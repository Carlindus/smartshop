/**
 * 
 */
package presentation.utilisateur.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import presentation.utilisateur.bean.UtilisateurDto;
import service.utilisateur.IUtilisateurService;
import util.MyFactory;

/**
 * Voir le formumlaire de modification de l'utilisateur
 * 
 * @author Ahmed
 *
 */
public class VoirModifierUtilisateurAction extends Action {

    private static final String FORWARD_SUCCESS = "success";

    /**
     * Nom de l'objet Utilisateur passe a la JSP
     */
    public static final String UTILISATEUR_REQUEST = "user";

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.struts.action.Action#execute(org.apache.struts.action.
     * ActionMapping, org.apache.struts.action.ActionForm,
     * javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse)
     */
    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {

        // on recupere l'id de l'utilisateur en parametre
        final String idParam = request.getParameter("idParam");
        final int idUtilisateur = Integer.parseInt(idParam);

        // on effectue le traitement via le service
        final IUtilisateurService utilisateurService = MyFactory.getInstance(IUtilisateurService.class);
        final UtilisateurDto utilisateurDto = utilisateurService.findUtilisateur(idUtilisateur);

        // on met les donnees en request pour la vue
        request.setAttribute(UTILISATEUR_REQUEST, utilisateurDto);

        return mapping.findForward(FORWARD_SUCCESS);
    }

}
