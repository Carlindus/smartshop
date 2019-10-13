/**
 * 
 */
package persistance.commande.bean;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

import persistance.utilisateur.bean.UtilisateurDo;

/** to review robin
 * @author Robin
 * test merge ,qskjdnbiuqsldfjofhqsisduofjiuqsdshfiuquhsdifhqopsduhfuef
 *
 */
public class CommandeDo {
    private int idCde ; 
    private int idUtilisateur;
    private Timestamp dateCde ;
    private double montantTotal;
    private double montantRemise;
    private String adresseLivraison;
    private String adresseFacturation;
    private Set<LigneCommandeDo> ligneCommandeSet;
    
    public int getIdCde() {
        return idCde;
    }
    
    public void setIdCde(int idCde) {
        this.idCde = idCde;
    }
    
    /**
     * @return
     */
    public int getIdUtilisateur() {
        return idUtilisateur;
    }
    
    /**
     * @param idUtilisateur
     */
    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }
    
    /**
     * @return
     */
    public Timestamp getDateCde() {
        return dateCde;
    }
    
    public void setDateCde(Timestamp dateCde) {
        this.dateCde = dateCde;
    }
    
    public double getMontantTotal() {
        return montantTotal;
    }
    
    public void setMontantTotal(double montantTotal) {
        this.montantTotal = montantTotal;
    }
    
    public double getMontantRemise() {
        return montantRemise;
    }
    
    public void setMontantRemise(double montantRemise) {
        this.montantRemise = montantRemise;
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
    
    public Set<LigneCommandeDo> getLigneCommandeSet() {
        return ligneCommandeSet;
    }
    
    public void setLigneCommandeSet(Set<LigneCommandeDo> ligneCommandeSet) {
        this.ligneCommandeSet = ligneCommandeSet;
    }

    
}
