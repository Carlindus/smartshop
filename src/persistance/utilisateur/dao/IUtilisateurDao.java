/**
 * 
 */
package persistance.utilisateur.dao;

import java.util.List;

import persistance.utilisateur.bean.UtilisateurDo;

/**
 * @author Caroline
 *
 */
public interface IUtilisateurDao {
   
    /**
     * @param utilisateur
     * @return
     */
    UtilisateurDo addUtilisateur(final UtilisateurDo utilisateur);
    
    /**
     * @param idUtilisateur
     * @param utilisateur 
     * @return
     */
    UtilisateurDo updateUtilisateur(final int idUtilisateur,final UtilisateurDo utilisateur);

    /**
     * @param idUtilisateur
     * @return
     */
    UtilisateurDo findUtilisateur(final int idUtilisateur);

    /**
     * 
     * @param login
     * @param password
     * @return
     */
    UtilisateurDo findUtilisateur(final String login, final String password);

    /**
     * @return La liste des utilisateurDo
     */
    List<UtilisateurDo> findAllUtilisateurDo();

    /**
     * @param id
     * @return
     */
    boolean deleteUtilisateur(final int id);
}
