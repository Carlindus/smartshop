package presentation.filtre;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import presentation.utilisateur.action.ConnexionAction;
import presentation.utilisateur.bean.ConnectedUserDto;

/**
 * @author David & Alexy
 *
 */
public class FiltreHttp implements Filter {

    // Cr�ation d'une constante qui repr�sente le formulaire de connexion
    private static final String PAGE_CONNEXION = "voirConnexion.do";
    // Cr�ation des constantes qui repr�sente tous les profils qui peuvent exister
    private static final int PROFIL_ADMIN  = 7; // 0111
    private static final int PROFIL_USER   = 3; // 0011
    private static final int PROFIL_INVITE = 1; // 0001
    // Cr�ation des constantes qui repr�sentes tous les acc�s par profil
    private static final int ACCES_ADMIN  = 4; // 0100
    private static final int ACCES_USER   = 2; // 0010
    private static final int ACCES_INVITE = 1; // 0001

    // Cr�ation d'une map avec comme cl� la liste des url des pages de l'application et comme valeur la liste des acc�s par profil correspondante
    private static Map<String, Integer> droitsAcces = new HashMap<>();
    static {
        // Acces Admin
        droitsAcces.put("listerUtilisateur", ACCES_ADMIN);
        droitsAcces.put("voirCreerProduit", ACCES_ADMIN);
        droitsAcces.put("creerProduit", ACCES_ADMIN);
        droitsAcces.put("modifierProduit", ACCES_ADMIN);
        droitsAcces.put("supprimerProduit", ACCES_ADMIN);
        droitsAcces.put("listerProduitAdmin", ACCES_ADMIN);
        droitsAcces.put("voirListeCommande", ACCES_ADMIN);
        droitsAcces.put("voirDetailCommande", ACCES_ADMIN);
        droitsAcces.put("voirModifierProduit", ACCES_ADMIN);

        // Acces UtilisateurConnecté
        droitsAcces.put("deconnexion", ACCES_USER);
        droitsAcces.put("listerProduitAccueil", ACCES_USER);
        droitsAcces.put("voirDetailUtilisateur", ACCES_USER);
        droitsAcces.put("voirModifierUtilisateur", ACCES_USER);
        droitsAcces.put("modifierUtilisateur", ACCES_USER);
        droitsAcces.put("supprimerUtilisateur", ACCES_USER);
        droitsAcces.put("ajouterProduitPanier", ACCES_USER);
        droitsAcces.put("ajouterQttPanier", ACCES_USER);
        droitsAcces.put("retirerQttPanier", ACCES_USER);
        droitsAcces.put("supprimerQttPanier", ACCES_USER);
        droitsAcces.put("supprimerLignePanier", ACCES_USER);
        droitsAcces.put("listerPanier", ACCES_USER);
        droitsAcces.put("viderPanier", ACCES_USER);
        droitsAcces.put("validerPanier", ACCES_USER);
        droitsAcces.put("validerCommande", ACCES_USER);

        // Acces Invité
        droitsAcces.put("voirConnexion", ACCES_INVITE);
        droitsAcces.put("connexion", ACCES_INVITE);
        droitsAcces.put("listerProduitAccueil", ACCES_INVITE);
        droitsAcces.put("voirDetailProduit", ACCES_INVITE);
        droitsAcces.put("langue", ACCES_INVITE);
        droitsAcces.put("voirCgu", ACCES_INVITE);
        droitsAcces.put("voirInscription", ACCES_INVITE);
        droitsAcces.put("inscription", ACCES_INVITE);
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    @Override
    public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain) throws IOException, ServletException {
        // r�cup�ration de la session
        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) res;
        final HttpSession session = request.getSession();
        // re�cup�ration de l'url demand�
        final String url = request.getRequestURI();
        final String path = request.getContextPath();
        final String resultat = extract(url, path);
        // r�cup�ration de l'objet user en session
        final ConnectedUserDto user = (ConnectedUserDto) session.getAttribute(ConnexionAction.CONNECTED_USER);
        // tester si l'objet user s'il n'est pas nul si c est un admin ou un utilisateur normal( non admin)
        int valeurProfil = PROFIL_INVITE; // Si l'objet user est null, alors l'utilisateur est un invit�
        if (user != null) {
            if (user.isAdmin() == true) {
                valeurProfil = PROFIL_ADMIN;
            } else {
                valeurProfil = PROFIL_USER;
            }
        }
        // tester si l'url demand� existe
        if (droitsAcces.get(resultat) != null) {
            final int valeur = droitsAcces.get(resultat);
            // comparer le profil et le droit d'acc�s (attention la comparaison se fait avec & binaire entre la constante profil et la constante acces)
            final int acces = valeur & valeurProfil;
            // rediriger l'user vers la page demand�e ou la page de connexion en fonction du resultat de la comparaison
            if (acces != 0) {
                chain.doFilter(request, response);
            } else {
                request.getRequestDispatcher(PAGE_CONNEXION).forward(request, response);
            }
        } else {
            request.getRequestDispatcher(PAGE_CONNEXION).forward(request, response);
        }

    }

    /**
     * M�thode pour extraire le nom de la page demand�e
     * 
     * @param url
     *            : l'url de la requ�te
     * @param path
     *            : le ContextPath de la requ�te
     * @return le nom de la page demand�e
     */
    private String extract(final String url, final String path) {
        final int indexEnd = url.indexOf(".do");
        if (indexEnd == -1) {
            return url;
        }
        final int indexBegin = path.length() + 1;
        final String result = url.substring(indexBegin, indexEnd);
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.Filter#destroy()
     */
    @Override
    public void destroy() {
        // empty method
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(final FilterConfig arg0) throws ServletException {
        // empty method
    }

}
