package presentation.commande.bean;

import java.util.Date;
import java.util.Set;

import persistance.commande.bean.LigneCommandeDo;
import persistance.utilisateur.bean.UtilisateurDo;
import persistance.utilisateur.dao.impl.UtilisateurDao;
import presentation.utilisateur.bean.UtilisateurDto;
import service.utilisateur.UtilisateurMapper;

/**
 * @author Kevin
 *
 */
public class CommandeDto {

    private int                  idCde;
    private int                  idUtilisateur;
    private UtilisateurDto       utilisateur;
    private String               adresseLivraison;
    private String               adresseFacturation;
    private Date                 dateCde;
    private double               montantTotal;
    private double               montantRemise;
    private Set<LigneCommandeDo> ligneCommandeSet;

    /**
     * Constructeur par defaut
     */
    public CommandeDto() {
        super();
    }

    /**
     * @return idCde
     */
    public int getIdCde() {
        return idCde;
    }

    /**
     * @param idCde
     *            idCde to set
     */
    public void setIdCde(final int idCde) {
        this.idCde = idCde;
    }

    /**
     * @return adresseLivraison
     */
    public String getAdresseLivraison() {
        return adresseLivraison;
    }

    /**
     * @param adresseLivraison
     *            adresseLivraison to set
     */
    public void setAdresseLivraison(final String adresseLivraison) {
        this.adresseLivraison = adresseLivraison;
    }

    /**
     * @return adresseFacturation
     */
    public String getAdresseFacturation() {
        return adresseFacturation;
    }

    /**
     * @param adresseFacturation
     *            adresseFacturation to set
     */
    public void setAdresseFacturation(final String adresseFacturation) {
        this.adresseFacturation = adresseFacturation;
    }

    /**
     * @return dateCde
     */
    public Date getDateCde() {
        return dateCde;
    }

    /**
     * @param dateCde
     *            dateCde to set
     */
    public void setDateCde(final Date dateCde) {
        this.dateCde = dateCde;
    }

    /**
     * @return montantTotal
     */
    public double getMontantTotal() {
        return montantTotal;
    }

    /**
     * @param montantTotal
     *            montantTotal to set
     */
    public void setMontantTotal(final double montantTotal) {
        this.montantTotal = montantTotal;
    }

    /**
     * @return montantRemise
     */
    public double getMontantRemise() {
        return montantRemise;
    }

    /**
     * @param montantRemise
     *            montantRemise to set
     */
    public void setMontantRemise(final double montantRemise) {
        this.montantRemise = montantRemise;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public UtilisateurDto getUtilisateur() {
        UtilisateurDo utilisateurDo = new UtilisateurDo();
        utilisateurDo = UtilisateurDao.getInstance().findUtilisateur(this.idUtilisateur);
        UtilisateurDto utilisateur = UtilisateurMapper.mapDoToDto(utilisateurDo);
        return utilisateur;
    }

    public void setUtilisateur(UtilisateurDto utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Set<LigneCommandeDo> getLigneCommandeSet() {
        return ligneCommandeSet;
    }

    public void setLigneCommandeSet(Set<LigneCommandeDo> ligneCommandeSet) {
        this.ligneCommandeSet = ligneCommandeSet;
    }

    @Override
    public String toString() {
        return "CommandeDto [idCde=" + idCde + ", idUtilisateur=" + idUtilisateur + ", dateCde=" + dateCde + ", montantTotal=" + montantTotal + ", montantRemise=" + montantRemise
                + ", ligneCommandeSet=" + ligneCommandeSet + "]";
    }

}
