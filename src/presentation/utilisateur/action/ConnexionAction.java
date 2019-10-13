package presentation.utilisateur.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import presentation.panier.bean.DetailProduitPanierDto;
import presentation.panier.bean.PanierDto;
import presentation.produit.bean.ProduitDto;
import presentation.utilisateur.bean.ConnectedUserDto;
import presentation.utilisateur.bean.UtilisateurDto;
import presentation.utilisateur.form.ConnexionForm;
import service.utilisateur.IUtilisateurService;
import util.MyFactory;

/**
 * @author David
 *
 */
public class ConnexionAction extends Action {

    /**
     * attribut de session pour Utilisateur connecté
     */
    public static final String  CONNECTED_USER        = "connectedUser";
    private static final String FORWARD_SUCCESS       = "success";
    private static final String FORWARD_SUCCESS_ADMIN = "successAdmin";
    private static final String FORWARD_FAIL          = "fail";
    private static final String FORWARD_FAIL_REDIRECT = "failRedirect";
    /**
     * Nom de la var pour le panier
     */
    public static final String  MAP_PANIER_SESSION    = "panier";

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse)
     */
    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
    	final ConnexionForm connexionForm = (ConnexionForm) form;
    	
    	final IUtilisateurService utilisateurService = MyFactory.getInstance(IUtilisateurService.class);
    	final ConnectedUserDto connectedUser = utilisateurService.findUtilisateur(connexionForm.getLogin(), connexionForm.getMdp());
    	
    	if(connectedUser == null) {
			final ActionErrors errors = new ActionErrors();
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("connexion.user.ko"));
			saveErrors(request, errors);

    		
    		return mapping.findForward(FORWARD_FAIL);
    	} 
    		// Passage du ConnectedUser en session
    		request.getSession().setAttribute(CONNECTED_USER, connectedUser);
    		// Creation du panier
    		if (request.getSession().getAttribute(MAP_PANIER_SESSION) == null) {
    			final PanierDto panier = new PanierDto();
    			final Map<ProduitDto, DetailProduitPanierDto> mapProduitDto = new HashMap<ProduitDto, DetailProduitPanierDto>();
    			panier.setMapProduitDto(mapProduitDto);
    			
    			request.getSession().setAttribute(MAP_PANIER_SESSION, panier);
    		}
    		// Rediretion selon permissions
    		if (connectedUser.isAdmin()) {
    			return mapping.findForward(FORWARD_SUCCESS_ADMIN);
    		}
    			return mapping.findForward(FORWARD_SUCCESS);
    		
    	
    }
}
