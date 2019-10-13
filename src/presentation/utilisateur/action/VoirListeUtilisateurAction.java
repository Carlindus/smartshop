package presentation.utilisateur.action;

import java.util.List;

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
 * Action mettant à disposition la liste d'utilisateur
 * 
 * @author Clément
 */
public class VoirListeUtilisateurAction extends Action {

    private static final String FORWARD_SUCCESS = "success";
    /**
     * Nom de la liste renvoyée en Request
     */
    public static final String  LISTE_USERS_REQUEST = "liste";

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
    		// test merge
    		// on récupère les données via le service
    		final IUtilisateurService utilisateurService = MyFactory.getInstance(IUtilisateurService.class);
    		final List<UtilisateurDto> listeUtilisateur = utilisateurService.findAllUtilisateur();
    		
    		// on les met dans la request
    		request.setAttribute(LISTE_USERS_REQUEST, listeUtilisateur);

    		// on retourne la redirection
    		return mapping.findForward(FORWARD_SUCCESS);
    	
    }

}
