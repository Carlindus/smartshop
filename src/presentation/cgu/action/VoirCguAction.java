/**
 * 
 */
package presentation.cgu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import service.cgu.ICguService;
import util.MyFactory;

/**
 * @author Caroline
 *
 */
public class VoirCguAction extends Action {
    
	 /**
     * 
     */
    public static final String FORWARD_SUCCESS ="success";
    
    /**
     * 
     */
    public static final String CGU_CONSTANTE ="contenu_Cgu";
    
    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        final ICguService cguService = MyFactory.getInstance(ICguService.class);
        final String str = cguService.readCgu();
        if (str.equals("")) {
            request.setAttribute(CGU_CONSTANTE, "Fichier introuvable");
        }
        else {
            request.setAttribute(CGU_CONSTANTE, str);
        }
        return mapping.findForward(FORWARD_SUCCESS);
    }

}
