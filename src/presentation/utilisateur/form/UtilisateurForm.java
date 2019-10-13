/**
 * 
 */
package presentation.utilisateur.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import presentation.utilisateur.action.VoirModifierUtilisateurAction;
import presentation.utilisateur.bean.UtilisateurDto;

/**
 * @author Cl�ment
 *
 */
public class UtilisateurForm extends ActionForm {

    private String  nom;
    private String  prenom;
    private String  dateNaissance;
    private String  email;
    private String  login;
    private String  motDePasse;
    private String  confirmerMotDePasse;
    private String  adresseLivraison;
    private String  adresseFacturation;
    private boolean isAdmin;
    private boolean isActif;

    /**
     * @author Cl�ment
     */
    private static final long serialVersionUID = -8546930090591952690L;

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.struts.action.ActionForm#reset(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
     */
    @Override
    public void reset(final ActionMapping mapping, final HttpServletRequest request) {
        // on recherche le bean dans la request pour initialiser le formulaire
        final UtilisateurDto utilisateurDto = (UtilisateurDto) request.getAttribute(VoirModifierUtilisateurAction.UTILISATEUR_REQUEST);
        if (utilisateurDto == null) {
            // s'il n'y est pas, on fait le reset par d�faut
            super.reset(mapping, request);
        } else {
            // sinon, on initialise le formulaire
            this.nom = utilisateurDto.getNom();
            this.prenom = utilisateurDto.getPrenom();
            this.dateNaissance = utilisateurDto.getDateNaissance();
            this.email = utilisateurDto.getEmail();
            this.login = utilisateurDto.getLogin();
            this.motDePasse = utilisateurDto.getMotDePasse();
            this.confirmerMotDePasse = utilisateurDto.getMotDePasse();
            this.adresseLivraison = utilisateurDto.getAdresseLivraison();
            this.adresseFacturation = utilisateurDto.getAdresseFacturation();
            this.isActif = utilisateurDto.isActif();
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.struts.action.ActionForm#validate(org.apache.struts.action.
     * ActionMapping, javax.servlet.http.HttpServletRequest)
     */
    @Override
    public ActionErrors validate(final ActionMapping mapping, final HttpServletRequest request) {
        final ActionErrors errors = new ActionErrors();

        if (nom.isEmpty()) {
            errors.add("nom", new ActionMessage("errors.nom.obligatoire"));
        } else {
            if (nom.length() > 20) {
                errors.add("nom", new ActionMessage("errors.nom.tropLong"));
            }
        }

        if (prenom.isEmpty()) {
            errors.add("prenom", new ActionMessage("errors.prenom.obligatoire"));
        } else {
            if (prenom.length() > 20) {
                errors.add("prenom", new ActionMessage("errors.prenom.tropLong"));
            }
        }

        if (login.isEmpty()) {
            errors.add("login", new ActionMessage("errors.login.obligatoire"));
        } else {
            if (login.length() > 20) {
                errors.add("login", new ActionMessage("errors.login.tropLong"));
            }
        }

        if (motDePasse.isEmpty()) {
            errors.add("motDePasse", new ActionMessage("errors.motDePasse.obligatoire"));
        } else if (motDePasse != confirmerMotDePasse) {
            errors.add("motDePasse", new ActionMessage("errors.motDePasse.different"));
        } else {
            if (motDePasse.length() > 20) {
                errors.add("motDePasse", new ActionMessage("errors.motDePasse.tropLong"));
            }
        }

        if (adresseFacturation.isEmpty()) {
            errors.add("adresseFacturation", new ActionMessage("errors.adresseFacturation.obligatoire"));
        }

        if (adresseLivraison.isEmpty()) {
            errors.add("adresseLivraison", new ActionMessage("errors.adresseLivraison.obligatoire"));
        }

        // if (dateNaissance.isEmpty()) {
        //
        // // V�rifier qu'il corresponde au format dd/MM/yyyy
        // errors.add("age", new ActionMessage("errors.age.obligatoire"));
        // }

        return errors;

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getAdresseLivraison() {
        return adresseLivraison;
    }

    public void setAdresseLivraison(String adresseLivraison) {
        this.adresseLivraison = adresseLivraison;
    }

    public String getAdresseFacturation() {
        return adresseFacturation;
    }

    public void setAdresseFacturation(String adresseFacturation) {
        this.adresseFacturation = adresseFacturation;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public boolean getIsActif() {
        return isActif;
    }

    public void setIsActif(boolean isActif) {
        this.isActif = isActif;
    }

    public String getConfirmerMotDePasse() {
        return confirmerMotDePasse;
    }

    public void setConfirmerMotDePasse(String confirmerMotDePasse) {
        this.confirmerMotDePasse = confirmerMotDePasse;
    }

}
