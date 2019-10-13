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
 * @author Ahmed
 *
 */
public class VoirDetailUtilisateurAction extends Action {

    // entative de correction 1 apr�s remarques architecte
    // test commit (independant du push de la fueature locale vers le serveur distant)
    private static final String FORWARD_SUCCESS     = "success";
    /**
     * Nom de l'objet Utilisateur passe a la JSP
     */
    public static final String  UTILISATEUR_REQUEST = "personne";

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

        // on va rechercher les donnees via le service
        final IUtilisateurService utilisateurService = MyFactory.getInstance(IUtilisateurService.class);
        final UtilisateurDto utilisateurDto = utilisateurService.findUtilisateur(idUtilisateur);

        // on met les donnees a disposition
        request.setAttribute(UTILISATEUR_REQUEST, utilisateurDto);

        // on redirige
        return mapping.findForward(FORWARD_SUCCESS);

    }
}
