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
import service.produit.IProduitService;
import util.MyFactory;

/**
 * @author Michelle
 *
 */
public class SupprimerProduitAction extends Action {

    private final String FORWARD_SUCCESS = "success";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        System.out.println("@SupprimerProduitAction");

        // Find the product to delete by Id
        String pId = request.getParameter("id");
        int vId = Integer.parseInt(pId);
        IProduitService vProduitService = MyFactory.getInstance(IProduitService.class);
        ProduitDto vProduitDto = vProduitService.findProduit(vId);

        // Delete the product
        boolean vResultDeleteProduit = vProduitService.deleteProduit(vProduitDto);

        // Return an information message
        String vValidateMessage = "supprimerProduit.fail";
        if (vResultDeleteProduit) {
            vValidateMessage = "supprimerProduit.success";
        }
        ActionMessages vActionMessages = new ActionMessages();
        final ActionMessage vActionMessage = new ActionMessage(vValidateMessage, new Object[] { vProduitDto.getReference() });
        vActionMessages.add(ActionMessages.GLOBAL_MESSAGE, vActionMessage);
        saveMessages(request, vActionMessages);

        return mapping.findForward(FORWARD_SUCCESS);
    }
}
