package presentation.langue;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Permet de changer de langue, en restant sur la même URL
 * 
 * @author Laurent
 *
 */
public class LangueAction extends Action {

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.struts.action.Action#execute(org.apache.struts.action.
     * ActionMapping, org.apache.struts.action.ActionForm,
     * javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse)
     */
    @Override
    public ActionForward execute( final ActionMapping mapping, final ActionForm form, final HttpServletRequest request,
            final HttpServletResponse response ) throws Exception {
        // on reconstruit l'url
        String url = request.getHeader( "referer" );
        if ( url == null ) {
            url = "/";
        } else {
            url = url.substring( url.lastIndexOf( "/" ) );
        }
        final String newUrl = request.getContextPath() + url;

        // on change de langue
        final String langue = request.getParameter( "lang" );
        if ( "FR".equals( langue ) ) {
            request.getSession().setAttribute( Globals.LOCALE_KEY, Locale.FRENCH );
        } else {
            request.getSession().setAttribute( Globals.LOCALE_KEY, Locale.ENGLISH );
        }

        // on redirige
        response.sendRedirect( newUrl );

        return null;
    }

}
