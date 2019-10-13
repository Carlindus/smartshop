/**
 * 
 */
package presentation.produit.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
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
 * @author Audrey
 *
 */
public class CreerProduitAction extends Action {

    private static final String FORWARD_SUCCESS = "success";
    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) 
                    throws Exception {

        ProduitDto produitDto = new ProduitDto();
        final ProduitForm produitForm = (ProduitForm) form;
        
        //enregistre données du formulaire dans le produitDto
        produitDto.setDescription(produitForm.getDescription());
        produitDto.setEtat(produitForm.getEtat());
        produitDto.setPrix(Double.parseDouble(produitForm.getPrix()));
        produitDto.setReference(produitForm.getReference());
        produitDto.setImage(produitForm.getImageFile().getFileName());
        produitDto.setData(produitForm.getImageFile().getFileData());

        final IProduitService produitService = MyFactory.getInstance(IProduitService.class);
        produitService.addProduit(produitDto);
        ActionMessages messages = new ActionMessages();
        final ActionMessage message = new ActionMessage("creerProduit.success", new Object[] {produitDto.getReference()});
        messages.add(ActionMessages.GLOBAL_MESSAGE, message);
        saveMessages(request, messages);
        return mapping.findForward(FORWARD_SUCCESS);
    
    }
      
}
