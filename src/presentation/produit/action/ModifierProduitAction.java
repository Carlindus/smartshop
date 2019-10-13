package presentation.produit.action;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import presentation.produit.bean.ProduitDto;
import presentation.produit.form.ProduitForm;
import service.produit.IProduitService;
import util.MyFactory;

/**
 * @author Alexy
 *
 */
public class ModifierProduitAction extends Action{
    
    private static final String UTILISATEUR_REQUEST = null;
    public static String FORWARD_SUCCESS = "success";
    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        final ProduitForm produitForm = (ProduitForm) form;
        
        final IProduitService produitService = MyFactory.getInstance(IProduitService.class);
        final ProduitDto produitDto = mapFormToDto(produitForm, request);
        final boolean produit = produitService.updateProduit(produitDto);
        
     // selon le résultat
        if (produit == false) {
            // création KO
            final ActionErrors errors = new ActionErrors();
            errors.add(ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("modifier.user.ko", new Object[] { produitDto.getIdProduit() }));
            saveErrors(request, errors);
            // on remet les infos en request
            request.setAttribute(VoirModifierProduitAction.PRODUIT_REQUEST, produitDto);
        } else {
            // création OK
            final ActionMessages messages = new ActionMessages();
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("modifier.user.ok", new Object[] { produitDto.getIdProduit() }));
            saveMessages(request, messages);
        }
        return mapping.findForward(FORWARD_SUCCESS);
    }
    
    
    private ProduitDto mapFormToDto(final ProduitForm produitForm, final HttpServletRequest request) throws FileNotFoundException, IOException {
        ProduitDto produitDto = new ProduitDto();
        produitDto.setEtat(produitForm.getEtat());
        produitDto.setDescription(produitForm.getDescription());
        produitDto.setPrix(Double.parseDouble(produitForm.getPrix()));
        produitDto.setReference(produitForm.getReference());
        produitDto.setData(produitForm.getImageFile().getFileData());
        produitDto.setImage(produitForm.getImageFile().getFileName());
        produitDto.setIdProduit(((ProduitDto) request.getAttribute(VoirModifierProduitAction.PRODUIT_REQUEST)).getIdProduit());
        
        return produitDto;
    }
}
