/**
 * 
 */
package presentation.commande.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import presentation.commande.bean.CommandeDto;
import presentation.utilisateur.action.ConnexionAction;
import presentation.utilisateur.bean.ConnectedUserDto;
import service.commande.ICommandeService;
import service.commande.impl.CommandeService;

/**
 * @author Guillaume
 *
 */
public class VoirListeCommandeAction extends Action {

    HttpSession session;

    private static final String FORWARD_SUCCESS        = "success";
    /**
     * Nom de la liste renvoy� en Request
     */
    public static final String  LISTE_COMMANDE_REQUEST = "listeCommande";

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
      System.out.println("---------------- into VoirListeCommandeAction ----------------");
        // on r�cup�re les donn�es
        session = request.getSession(true);
        final ICommandeService CommandeService = new CommandeService();
        final List<CommandeDto> listeCommande;
        ConnectedUserDto connectedUserDto = (ConnectedUserDto) session.getAttribute(ConnexionAction.CONNECTED_USER);
        if (connectedUserDto.isAdmin()) {
            listeCommande = CommandeService.findAllCommande();
        } else {
            listeCommande = CommandeService.findAllCommandeByUtilisateur(connectedUserDto.getId());
        }
        if (listeCommande.isEmpty()) {
            final ActionMessages messages = new ActionMessages();
            messages.add("listerCommande.vide", new ActionMessage("listerCommande.vide"));
            saveMessages(request, messages);
        } else {
            final ActionMessages messages = new ActionMessages();
            messages.add("listerCommande.date.commande", new ActionMessage("listerCommande.date.commande"));
            messages.add("listerCommande.date.livraison", new ActionMessage("listerCommande.date.livraison"));
            saveMessages(request, messages);
        }
        request.setAttribute(LISTE_COMMANDE_REQUEST, listeCommande);
        // on retourne la redirection
        return mapping.findForward(FORWARD_SUCCESS);

    }

}
