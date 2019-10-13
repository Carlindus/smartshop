package presentation.produit.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import presentation.produit.bean.ProduitDto;
import service.produit.IProduitService;
import util.MyFactory;

/**
 * @author Alexy
 *
 */
public class VoirModifierProduitAction extends Action {

    /**
     * 
     */
    public static String PRODUIT_REQUEST = "produit";

    /**
     * 
     */
    public static String FORWARD_SUCCESS = "success";

    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        System.out.println("-------------into voirModifierProduitAction-------------");

        final String idParam = request.getParameter("id");
        final int id = Integer.parseInt(idParam);

        final IProduitService produitService = MyFactory.getInstance(IProduitService.class);
        ProduitDto produitDto = produitService.findProduit(id);
        request.setAttribute(PRODUIT_REQUEST, produitDto);
        return mapping.findForward(FORWARD_SUCCESS);
    }
}
