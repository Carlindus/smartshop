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
import org.apache.struts.action.ActionRedirect;

import presentation.utilisateur.bean.UtilisateurDto;
import presentation.utilisateur.form.UtilisateurForm;
import service.utilisateur.IUtilisateurService;
import util.MyFactory;

/**
 * Modifier un Utilisateur
 * 
 * @author
 *
 */
public class ModifierUtilisateurAction extends Action {

    private static final String FORWARD_SUCCESS = "success";

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

        final UtilisateurForm utilisateurForm = (UtilisateurForm) form;

        // on effectue le traitement via le service
        final IUtilisateurService utilisateurService = MyFactory.getInstance(IUtilisateurService.class);
        final UtilisateurDto utilisateurDto = mapFormToDto(utilisateurForm);
        final UtilisateurDto utilisateur = utilisateurService.updateUtilisateur(utilisateurDto.getIdUtilisateur(), utilisateurDto);

        // selon le resultat
        if (utilisateur == null) {
            // creation KO
            final ActionErrors errors = new ActionErrors();
            errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("modifier.user.ko"));
            saveErrors(request, errors);
            // on remet les infos en request
            request.setAttribute(VoirModifierUtilisateurAction.UTILISATEUR_REQUEST, utilisateurDto);
        } else {
            // creation OK
            final ActionMessages messages = new ActionMessages();
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("modifier.user.ok"));
            saveMessages(request.getSession(), messages);
        }

        ActionRedirect redirect = new ActionRedirect(mapping.findForward("success"));
        redirect.addParameter("idParam", utilisateurDto.getIdUtilisateur());
        return redirect;
    }

    /**
     * Mapper le formulaire en Dto
     * 
     * @param form
     *            le formulaire
     * 
     * @return le Dto
     */
    protected UtilisateurDto mapFormToDto(final UtilisateurForm form) {
        final UtilisateurDto utilisateur = new UtilisateurDto();
        utilisateur.setIdUtilisateur(form.getIdUtilisateur());
        utilisateur.setNom(form.getNom());
        utilisateur.setPrenom(form.getPrenom());
        utilisateur.setDateNaissance(form.getDateNaissance());
        utilisateur.setEmail(form.getEmail());
        utilisateur.setLogin(form.getLogin());
        utilisateur.setMotDePasse(form.getMotDePasse());
        utilisateur.setAdresseLivraison(form.getAdresseLivraison());
        utilisateur.setAdresseFacturation(form.getAdresseLivraison());
        utilisateur.setAdmin(form.getIsAdmin());
        utilisateur.setActif(form.getIsActif());
        return utilisateur;
    }

}
