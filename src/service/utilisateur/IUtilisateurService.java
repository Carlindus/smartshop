/**
 * 
 */
package service.utilisateur;

import presentation.utilisateur.bean.ConnectedUserDto;
import java.util.List;
import presentation.utilisateur.bean.UtilisateurDto;

/**
 * @author David
 *
 */
public interface IUtilisateurService {

    /**
     * 
     * @param login
     * @param password
     * @return the ConnectedUserDto to find
     */
    ConnectedUserDto findUtilisateur(final String login, final String password);

    /**
     * @param idUtilisateur
     * @return the UtilisateurDto to find
     */
    UtilisateurDto findUtilisateur(final int idUtilisateur);

    /**
     * 
     * @return List<UtilisateurDto>
     */
    List<UtilisateurDto> findAllUtilisateur();
    
    /**
     * 
     * @param utilisateurDto
     * @return
     */
    UtilisateurDto addUtilisateur(final UtilisateurDto utilisateurDto);
    
    /**
     * 
     * @param utilisateurDto
     * @return
     */
    UtilisateurDto updateUtilisateur(final int id, final UtilisateurDto utilisateurDto);

    /**
     * @param id
     * @return
     */
    boolean deleteUtilisateurDto(final int id);
}
