package presentation.utilisateur.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.SessionActionMapping;

import presentation.utilisateur.bean.ConnectedUserDto;
import presentation.utilisateur.bean.UtilisateurDto;
import service.utilisateur.IUtilisateurService;
import service.utilisateur.UtilisateurMapper;
import service.utilisateur.impl.UtilisateurService;
import util.MyFactory;

/**
 * @author Clement
 *
 */
public class SupprimerUtilisateurAction extends Action {

	private static final String FORWARD_SUCCESS = "success";
	private static final String DELETE_ITSELF_SUCCESS = "deleteItselfSuccess";

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.
	 * ActionMapping, org.apache.struts.action.ActionForm,
	 * javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request,
			final HttpServletResponse response) throws Exception {

		// on récupère l'id de l'utilisateur en paramètre
		final String idParam = request.getParameter("idParam");
		final int idUtilisateur = Integer.parseInt(idParam);

		// on effectue le traitement via le sevrice
		final IUtilisateurService utilisateurService = MyFactory.getInstance(IUtilisateurService.class);
		final boolean isUtilisateurSupprime = utilisateurService.deleteUtilisateurDto(idUtilisateur);

		// On récupère l'utilsateur en session + son ID
		final ConnectedUserDto connectedUser = (ConnectedUserDto) request.getSession()
				.getAttribute(ConnexionAction.CONNECTED_USER);
		final int idSessionUtilisateur = connectedUser.getId();

		ActionForward actionForward = mapping.findForward(FORWARD_SUCCESS);

		// On vérifie s'ils sont identiques
		if (idSessionUtilisateur == idUtilisateur) {
			// selon le résultat
			if (isUtilisateurSupprime) {
				// suppression OK
				final ActionMessages messages = new ActionMessages();
				messages.add(ActionMessages.GLOBAL_MESSAGE,
						new ActionMessage("supprimer.user.ok", new Object[] { idUtilisateur }));
				saveMessages(request, messages);

				actionForward = mapping.findForward(DELETE_ITSELF_SUCCESS);

			} else {
				// supression KO
				final ActionErrors errors = new ActionErrors();
				errors.add(ActionMessages.GLOBAL_MESSAGE,
						new ActionMessage("supprimer.user.ko", new Object[] { idUtilisateur }));
				saveErrors(request, errors);
			}

		} else {
			// selon le résultat
			if (isUtilisateurSupprime) {
				// suppression OK
				final ActionMessages messages = new ActionMessages();
				messages.add(ActionMessages.GLOBAL_MESSAGE,
						new ActionMessage("supprimer.user.ok", new Object[] { idUtilisateur }));
				saveMessages(request, messages);
			} else {
				// supression KO
				final ActionErrors errors = new ActionErrors();
				errors.add(ActionMessages.GLOBAL_MESSAGE,
						new ActionMessage("supprimer.user.ko", new Object[] { idUtilisateur }));
				saveErrors(request, errors);
			}
		}
		return actionForward;
	}
}
