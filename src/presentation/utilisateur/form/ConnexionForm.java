/**
 * 
 */
package presentation.utilisateur.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 * @author David
 *
 */
public class ConnexionForm extends ActionForm {
	
	private String login;
	private String mdp;

    /**
     * 
     */
    private static final long serialVersionUID = -6520005009842869291L;


    /*
     * (non-Javadoc)
     * 
     * @see org.apache.struts.action.ActionForm#reset(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
     */
    @Override
    public void reset(final ActionMapping mapping, final HttpServletRequest request) {
    	// on fait le reset par défaut
    	super.reset(mapping, request);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.struts.action.ActionForm#validate(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
     */
    @Override
    public ActionErrors validate(final ActionMapping mapping, final HttpServletRequest request) {
    	final ActionErrors errors = new ActionErrors();
    	
    	if (login == null) {
    		return errors;
    	}
		if (login.isEmpty()) {
			errors.add("login", new ActionMessage("errors.login.obligatoire"));
		}
		if (mdp.isEmpty()) {
			errors.add("mdp", new ActionMessage("errors.mdp.obligatoire"));
		}

		return errors;
    }

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the mdp
	 */
	public String getMdp() {
		return mdp;
	}

	/**
	 * @param mdp the mdp to set
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

}
