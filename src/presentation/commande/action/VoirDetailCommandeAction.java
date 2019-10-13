/**
 * 
 */
package presentation.commande.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import presentation.commande.bean.CommandeDetailDto;
import service.commande.impl.CommandeService;

/**
 * @author Jonathan
 *
 */
public class VoirDetailCommandeAction extends Action {

    /**
     * 
     */
    public static final String  COMMANDE_DETAIL_DTO = "commandeDetailDto";
    private static final String FORWARD_SUCCESS     = "success";

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse)
     */
    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        System.out.println("--VoirDetailCommandeAction--");

        // on récupére l'idCde et le retour dans les paramètres
        int idCde = Integer.parseInt(request.getParameter("idCde"));
        final String redirect = request.getParameter("back");

        // on récupére les données via le service
        final CommandeService commandeService = new CommandeService();
        final CommandeDetailDto commandeDetailDto = commandeService.findDetailCommande(idCde);

        // si la page précédente est la liste, on envoie l'attribut lien qui redirige vers la liste des commandes
        if ("LC".equals(redirect))
            request.setAttribute("lien", "voirListeCommande.do");

        // on met les détails de la commande dans la request
        request.setAttribute(COMMANDE_DETAIL_DTO, commandeDetailDto);

        // on retourne la redirection
        return mapping.findForward(FORWARD_SUCCESS);
    }

}
