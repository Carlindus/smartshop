/**
 * 
 */
package presentation.produit.action;

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
    private static final String FORWARD_FAIL    = "fail";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("-----------into CreerProduitAction -------------");
        ProduitDto produitDto = new ProduitDto();
        final ProduitForm produitForm = (ProduitForm) form;
        System.out.println("produitForm :");
        System.out.println(produitForm.toString());

        // enregistre donn�es du formulaire dans le produitDto
        produitDto.setDescription(produitForm.getDescription());
        produitDto.setEtat(produitForm.isEnVente());
        produitDto.setPrix(Double.parseDouble(produitForm.getPrix()));
        produitDto.setReference(produitForm.getReference());
        // produitDto.setImage(produitForm.getImage().getFileName());
        // produitDto.setData(produitForm.getImage().getFileData());

        System.out.println();
        System.out.println("produitDto :");
        System.out.println(produitDto.toString());
        System.out.println(produitDto.getReference());
        System.out.println(produitDto.getPrix());
        System.out.println(produitDto.getDescription());
        System.out.println(produitDto.getEtat());

        final IProduitService produitService = MyFactory.getInstance(IProduitService.class);

        boolean resultAddProduct = produitService.addProduit(produitDto);
        if (!resultAddProduct) {
            return mapping.findForward(FORWARD_FAIL);
        }
        ActionMessages messages = new ActionMessages();
        final ActionMessage message = new ActionMessage("creerProduit.success", new Object[] { produitDto.getReference() });
        messages.add(ActionMessages.GLOBAL_MESSAGE, message);
        saveMessages(request, messages);

        return mapping.findForward(FORWARD_SUCCESS);
    }

}
