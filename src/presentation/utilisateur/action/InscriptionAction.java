/**
 * 
 */
package presentation.utilisateur.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import presentation.utilisateur.bean.UtilisateurDto;
import presentation.utilisateur.form.UtilisateurForm;
import service.utilisateur.IUtilisateurService;
import util.MyFactory;



/**
 * @author Clement
 *
 */
public class InscriptionAction extends Action {

	private static final String FORWARD_SUCCESS = "success";
	
    /*
     * (non-Javadoc)
     * 
     * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse)
     */
    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
      
    			
    	final UtilisateurForm utilisateurForm = (UtilisateurForm) form;

		// on effectue le traitement
		final IUtilisateurService utilisateurService = MyFactory.getInstance(IUtilisateurService.class);
		UtilisateurDto utilisateurDto = mapFormToDto(utilisateurForm);
		utilisateurDto = utilisateurService.addUtilisateur(utilisateurDto);

		// selon le résultat de la création
		if (utilisateurDto == null) {
			// création KO
			final ActionErrors errors = new ActionErrors();
			errors.add(ActionMessages.GLOBAL_MESSAGE,
					new ActionMessage("creer.user.ko"));
			saveErrors(request, errors);
		} else {
			// création OK
			final ActionMessages messages = new ActionMessages();
			messages.add(ActionMessages.GLOBAL_MESSAGE,
					new ActionMessage("creer.user.ok"));
			saveMessages(request, messages);
		}

		return mapping.findForward(FORWARD_SUCCESS);
    }
    
    protected UtilisateurDto mapFormToDto(final UtilisateurForm form) {
		final UtilisateurDto utilisateur = new UtilisateurDto();
		utilisateur.setDateNaissance(form.getDateNaissance());
		utilisateur.setNom(form.getNom());
		utilisateur.setPrenom(form.getPrenom());
		utilisateur.setAdresseFacturation(form.getAdresseFacturation());
		utilisateur.setAdresseLivraison(form.getAdresseLivraison());
		utilisateur.setLogin(form.getLogin());
		utilisateur.setEmail(form.getEmail());
		utilisateur.setMotDePasse(form.getMotDePasse());		
		
		return utilisateur;
	}

}
