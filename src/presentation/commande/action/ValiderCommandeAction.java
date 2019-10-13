package presentation.commande.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import persistance.commande.bean.CommandeDo;
import presentation.commande.form.CommandeForm;
import presentation.panier.bean.PanierDto;
import presentation.utilisateur.action.ConnexionAction;
import presentation.utilisateur.bean.ConnectedUserDto;
import service.commande.ICommandeService;
import service.panier.IPanierService;
import util.MyFactory;

/**
 * @author Karl
 *
 */
public class ValiderCommandeAction extends Action {

    private static final String FORWARD_SUCCESS = "success";
    private static final String FORWARD_ERROR   = "error";

    private String adresseLivraison;
    private String adresseFacturation;

    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {

        final HttpSession session = request.getSession();
        final PanierDto panier = (PanierDto) session.getAttribute(ConnexionAction.MAP_PANIER_SESSION);
        final ConnectedUserDto connectedUserDto = (ConnectedUserDto) session.getAttribute(ConnexionAction.CONNECTED_USER);
        final CommandeForm commandeForm = (CommandeForm) form;
        mapFormToDto(commandeForm);

        final IPanierService panierService = MyFactory.getInstance(IPanierService.class);
        final boolean verifPanier = panierService.verifierPanierDto(panier);

        if (verifPanier == true) {
            ICommandeService commandeService = MyFactory.getInstance(ICommandeService.class);
            CommandeDo commandeDo = commandeService.createCommande(panier, connectedUserDto.getId(), adresseLivraison, adresseFacturation);

            return mapping.findForward(FORWARD_SUCCESS);

        }
        PanierDto panierDtoModif = panierService.updateProduitsPanier(panier);
        session.setAttribute(ConnexionAction.MAP_PANIER_SESSION, panierDtoModif);
        final ActionMessages messages = new ActionMessages();
        messages.add("validerPanier.erreur ", new ActionMessage("validerPanier.erreur"));
        saveMessages(request, messages);
        return mapping.findForward(FORWARD_ERROR);

    }

    private void mapFormToDto(CommandeForm commandeForm) {
        adresseFacturation = commandeForm.getAdresseFacturation();
        adresseLivraison = commandeForm.getAdresseLivraison();
    }
}
