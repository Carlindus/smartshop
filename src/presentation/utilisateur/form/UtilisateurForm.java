/**
 * 
 */
package presentation.utilisateur.form;

import java.util.regex.Pattern;

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

    private int     idUtilisateur;
    private String  nom;
    private String  prenom;
    private String  dateNaissance;
    private String  jourNaissance;
    private String  moisNaissance;
    private String  anneeNaissance;
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
        System.out.println("--UtilisateurForm_reset()--");

        // on recherche le bean dans la request pour initialiser le formulaire
        UtilisateurDto utilisateurDto = (UtilisateurDto) request.getAttribute(VoirModifierUtilisateurAction.UTILISATEUR_REQUEST);
        if (utilisateurDto == null) {
            utilisateurDto = new UtilisateurDto("", "", "", "", "", "", "", "");
            // s'il n'y est pas, on fait le reset par d�faut
            super.reset(mapping, request);
        }
        // sinon, on initialise le formulaire

        this.idUtilisateur = utilisateurDto.getIdUtilisateur();
        this.nom = utilisateurDto.getNom();
        this.prenom = utilisateurDto.getPrenom();
        this.dateNaissance = utilisateurDto.getDateNaissance();
        if (!this.dateNaissance.equals("")) {
            this.jourNaissance = this.dateNaissance.substring(0, 1);
            this.moisNaissance = this.dateNaissance.substring(3, 4);
            this.anneeNaissance = this.dateNaissance.substring(6, 6);
        } else {
            this.jourNaissance = "-";
            this.moisNaissance = "-";
            this.anneeNaissance = "-";
        }
        this.email = utilisateurDto.getEmail();
        this.login = utilisateurDto.getLogin();
        this.motDePasse = utilisateurDto.getMotDePasse();
        this.confirmerMotDePasse = utilisateurDto.getMotDePasse();
        this.adresseLivraison = utilisateurDto.getAdresseLivraison();
        this.adresseFacturation = utilisateurDto.getAdresseFacturation();
        this.isActif = utilisateurDto.isActif();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.struts.action.ActionForm#validate(org.apache.struts.action.
     * ActionMapping, javax.servlet.http.HttpServletRequest)
     */
    @Override
    public ActionErrors validate(final ActionMapping mapping, final HttpServletRequest request) {
        // TODO Verification de l'existence d'un meme Login/pass

        System.out.println("--UtilisateurForm_validate()--");
        System.out.println("idUtilisateurV :" + this.idUtilisateur);
        System.out.println("nomV :" + this.nom);

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
        } else if (!motDePasse.equals(confirmerMotDePasse)) {
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

        if (dateNaissance.isEmpty()) {
            errors.add("dateNaissance", new ActionMessage("errors.dateNaissance.obligatoire"));
        } else if (!isValideDate(dateNaissance)) {
            errors.add("dateNaissance", new ActionMessage("errors.dateNaissance.dateInvalide"));
        }

        // if (jourNaissance.equals("-")) {
        // errors.add("jourNaissance", new ActionMessage("errors.jourNaissance.obligatoire"));
        // }
        // if (moisNaissance.equals("-")) {
        // errors.add("moisNaissance", new ActionMessage("errors.moisNaissance.obligatoire"));
        // }
        // if (anneeNaissance.equals("-")) {
        // errors.add("anneeNaissance", new ActionMessage("errors.anneeNaissance.obligatoire"));
        // }

        return errors;

    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
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

    // public String getJourNaissance() {
    // return jourNaissance;
    // }
    //
    // public void setJourNaissance(String jourNaissance) {
    // this.jourNaissance = jourNaissance;
    // }
    //
    // public String getMoisNaissance() {
    // return moisNaissance;
    // }
    //
    // public void setMoisNaissance(String moisNaissance) {
    // this.moisNaissance = moisNaissance;
    // }
    //
    // public String getAnneeNaissance() {
    // return anneeNaissance;
    // }
    //
    // public void setAnneeNaissance(String anneeNaissance) {
    // this.anneeNaissance = anneeNaissance;
    // }

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

    /**
     * Test if the date of birth have the format "dd/mm/yyyy"
     * 
     * @param dateNaissance
     * @return true if the string have the good format
     */
    public Boolean isValideDate(String dateNaissance) {
        String regExp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(19|20)?([0-9]{2})";
        Pattern datePattern = Pattern.compile(regExp);
        return datePattern.matcher(dateNaissance).matches();
    }

}
