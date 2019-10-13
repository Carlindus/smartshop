package presentation.utilisateur.bean;

import java.util.Set;

import presentation.commande.bean.CommandeDto;

/**
 * Data Trasnfert Object
 * 
 * @author Ahmed
 *
 */
public class UtilisateurDto {

    private int              idUtilisateur;
    private String           nom;
    private String           prenom;
    private String           dateNaissance;
    private String           email;
    private String           login;
    private String           motDePasse;
    private String           adresseLivraison;
    private String           adresseFacturation;
    private boolean          isAdmin;
    private boolean          isActif;
    private Set<CommandeDto> commandeSet;

    // Constructeur par defaut
    public UtilisateurDto() {
        super();
    }

    /**
     * 
     * @return id de l'utilisateur
     */
    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    /**
     * 
     * @param idUtilisateur
     */
    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    /**
     * 
     * @return nom de l'utilisateur
     */
    public String getNom() {
        return nom;
    }

    /**
     * 
     * @param nom
     *            de l'utilisateur
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * 
     * @return prenom de l'utilisateur
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * 
     * @param prenom
     *            utilisateur
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * 
     * @return de naissance de l'utilisateur
     */
    public String getDateNaissance() {
        return dateNaissance;
    }

    /**
     * 
     * @param dateNaissance
     */
    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    /**
     * 
     * @return email de l'utilisateur
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * @return login de l'utilisateur
     */
    public String getLogin() {
        return login;
    }

    /**
     * 
     * @param login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * 
     * @return mot de passe de l'utilisateur
     */
    public String getMotDePasse() {
        return motDePasse;
    }

    /**
     * 
     * @param motDePasse
     */
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    /**
     * 
     * @return adresse de livraison
     */
    public String getAdresseLivraison() {
        return adresseLivraison;
    }

    /**
     * 
     * @param adresseLivraison
     */
    public void setAdresseLivraison(String adresseLivraison) {
        this.adresseLivraison = adresseLivraison;
    }

    /**
     * 
     * @return adresse de facturation
     */
    public String getAdresseFacturation() {
        return adresseFacturation;
    }

    /**
     * 
     * @param adresseFacturation
     */
    public void setAdresseFacturation(String adresseFacturation) {
        this.adresseFacturation = adresseFacturation;
    }

    /**
     * 
     * @return true si l'utilisateur est admin, false sinon
     */
    public boolean isAdmin() {
        return isAdmin;
    }

    /**
     * 
     * @param true
     *            or false
     */
    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    /**
     * 
     * @return true si l'utilisateur est actif, false sinon
     */
    public boolean isActif() {
        return isActif;
    }

    /**
     * 
     * @param isActif
     */
    public void setActif(boolean isActif) {
        this.isActif = isActif;
    }

    /**
     *
     * @return La liste des commandes de l'utilisateur
     */
    public Set<CommandeDto> getCommandeSet() {
        return commandeSet;
    }

    /**
     *
     * @param commandeSet
     */
    public void setCommandeSet(Set<CommandeDto> commandeSet) {
        this.commandeSet = commandeSet;
    }

}
