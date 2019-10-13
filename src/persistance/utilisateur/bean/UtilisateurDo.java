/**
 * 
 */
package persistance.utilisateur.bean;

import java.util.Date;
import java.util.Set;

import persistance.commande.bean.CommandeDo;

/**
 * @author Clement
 *
 */
public class UtilisateurDo {

	private int idUtilisateur;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String email;
    private String login;
    private String motDePasse;
    private String adresseLivraison;
    private String adresseFacturation;
    private boolean isAdmin;
    private boolean isActif;
    private Set<CommandeDo> commandeSet;

	public UtilisateurDo() {
	}
    
    /**
     * 
     * @return l'id de l'utilisateur
     */
    public int getIdUtilisateur() {
        return idUtilisateur;
    }
    
    /**
     * 
     *  @param idUtilisateur
     */
    public void setIdUtilisateur(final int idUtilisateur) {
    	this.idUtilisateur = idUtilisateur;
    }
    
    /**
     * 
     * @return le nom de l'utilisateur
     */
    public String getNom() {
        return nom;
    }
    
    /**
     * 
     * @param nom
     */
    public void setNom(final String nom) {
        this.nom = nom;
    }
    
    /**
     * 
     * @return le prénom de l'utilisateur
     */
    public String getPrenom() {
        return prenom;
    }
    
    /**
     * 
     * @param prénom
     */
    public void setPrenom(final String prenom) {
        this.prenom = prenom;
    }
    
    /**
     * 
     * @return la date de naissance de l'utilisateur
     */
    public Date getDateNaissance() {
        return dateNaissance;
    }
    
    /**
     * 
     * @param dateNaissance
     * préférez le constructeur Date(int year, int month, int date)
     */
    public void setDateNaissance(final Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    
    /**
     * 
     * @return l'e-mail de l'utilisateur
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * 
     * @param email
     */
    public void setEmail(final String email) {
        this.email = email;
    }
    
    /**
     * 
     * @return le login de l'utilisateur
     */
    public String getLogin() {
        return login;
    }
    
    /**
     * 
     * @param login
     */
    public void setLogin(final String login) {
        this.login = login;
    }
    
    /**
     * 
     * @return le mot de passe de l'utilisateur
     */
    public String getMotDePasse() {
        return motDePasse;
    }
    
    /**
     * 
     * @param motDePasse
     */
    public void setMotDePasse(final String motDePasse) {
        this.motDePasse = motDePasse;
    }
    
    /**
     * 
     * @return l'adresse de livraison de l'utilisateur
     */
    public String getAdresseLivraison() {
        return adresseLivraison;
    }
    
    /**
     * 
     * @param adresseLivraison
     */
    public void setAdresseLivraison(final String adresseLivraison) {
        this.adresseLivraison = adresseLivraison;
    }
    
    /**
     * 
     * @return l'adresse de facturation de l'utilisateur
     */
    public String getAdresseFacturation() {
        return adresseFacturation;
    }
    
    /**
     * 
     * @param adresseFacturation
     */
    public void setAdresseFacturation(final String adresseFacturation) {
        this.adresseFacturation = adresseFacturation;
    }
    
    /**
     * 
     * @return true si l'utilisateur est admin
     */
    public boolean getIsAdmin() {
        return isAdmin;
    }
    
    /**
     * 
     * @param isAdmin
     */
    public void setIsAdmin(final boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    
    /**
     * 
     * @return true si l'utilisateur est actif
     */
    public boolean getIsActif() {
        return isActif;
    }
    
    /**
     * 
     * @param isActif
     */
    public void setIsActif(final boolean isActif) {
        this.isActif = isActif;
    }
    
    public Set<CommandeDo> getCommandeSet() {
		return commandeSet;
	}

	public void setCommandeSet(Set<CommandeDo> commandeSet) {
		this.commandeSet = commandeSet;
	}

}
