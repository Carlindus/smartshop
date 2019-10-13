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

/**
 * @author Michelle
 *
 */
public class VoirCreerProduitAction extends Action {

    private final String FORWARD_SUCCESS = "success";

     @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("-----------into VoirCreerProduitAction--------------");
         return mapping.findForward(FORWARD_SUCCESS);
    }

}
