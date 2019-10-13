package service.utilisateur;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import persistance.utilisateur.bean.UtilisateurDo;
import presentation.utilisateur.bean.ConnectedUserDto;
import presentation.utilisateur.bean.UtilisateurDto;
import service.utilisateur.impl.UtilisateurService;

/**
 * Mapping des diff�rents beans Utilisateur (Do, Dto, ConnectedUserDto)
 * 
 * @author David
 *
 */
public class UtilisateurMapper {

    // Test merge request davidf

    private static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * @param listeUtilisateurDo
     * @return the mapped List<UtilisateurDto>
     */
    public static List<UtilisateurDto> mapListDoToListDto(final List<UtilisateurDo> listeUtilisateurDo) {
        List<UtilisateurDto> listeUtilisateurDto = new ArrayList<UtilisateurDto>();

        for (UtilisateurDo unUtilisateurDo : listeUtilisateurDo) {
            listeUtilisateurDto.add(mapDoToDto(unUtilisateurDo));
        }

        return listeUtilisateurDto;
    }

    /**
     * @param utilisateurDo
     * @return the mapped UtilisateurDto
     */
    public static UtilisateurDto mapDoToDto(final UtilisateurDo utilisateurDo) {
        UtilisateurDto utilisateurDto = new UtilisateurDto();

        utilisateurDto.setIdUtilisateur(utilisateurDo.getIdUtilisateur());
        utilisateurDto.setNom(utilisateurDo.getNom());
        utilisateurDto.setPrenom(utilisateurDo.getPrenom());
        utilisateurDto.setDateNaissance(SDF.format(utilisateurDo.getDateNaissance()));
        utilisateurDto.setEmail(utilisateurDo.getEmail());
        utilisateurDto.setLogin(utilisateurDo.getLogin());
        utilisateurDto.setMotDePasse(utilisateurDo.getMotDePasse());
        utilisateurDto.setAdresseLivraison(utilisateurDo.getAdresseLivraison());
        utilisateurDto.setAdresseFacturation(utilisateurDo.getAdresseFacturation());
        utilisateurDto.setAdmin(utilisateurDo.getIsAdmin());
        utilisateurDto.setActif(utilisateurDo.getIsActif());

        return utilisateurDto;
    }

    /**
     * @param utilisateurDto
     * @return the mapped UtilisateurDo
     * @throws ParseException
     */
    public static UtilisateurDo mapDtoToDo(final UtilisateurDto utilisateurDto) throws ParseException {
        UtilisateurDo utilisateurDo = new UtilisateurDo();

        utilisateurDo.setIdUtilisateur(utilisateurDto.getIdUtilisateur());
        utilisateurDo.setNom(utilisateurDto.getNom());
        utilisateurDo.setPrenom(utilisateurDto.getPrenom());
        if (utilisateurDto.getDateNaissance().equals("")) {
            // TODO générer mieux les dates quand l'input dans l'UtilisateurForm sera fonctionnel
            utilisateurDo.setDateNaissance(new Date());
        } else {
            utilisateurDo.setDateNaissance(SDF.parse(utilisateurDto.getDateNaissance()));
        }
        utilisateurDo.setEmail(utilisateurDto.getEmail());
        utilisateurDo.setLogin(utilisateurDto.getLogin());
        utilisateurDo.setMotDePasse(utilisateurDto.getMotDePasse());
        utilisateurDo.setAdresseLivraison(utilisateurDto.getAdresseLivraison());
        utilisateurDo.setAdresseFacturation(utilisateurDto.getAdresseFacturation());
        utilisateurDo.setIsAdmin(utilisateurDto.isAdmin());
        utilisateurDo.setIsActif(utilisateurDto.isActif());

        return utilisateurDo;
    }

    /**
     * @param utilisateurDo
     * @return the mapped ConnectedUserDto
     */
    public static ConnectedUserDto mapUtilisateurDoToConnectedUserDto(final UtilisateurDo utilisateurDo) {
        ConnectedUserDto connectedUserDto = new ConnectedUserDto();
        if (utilisateurDo != null) {
            connectedUserDto.setId(utilisateurDo.getIdUtilisateur());
            connectedUserDto.setLogin(utilisateurDo.getLogin());
            connectedUserDto.setAdmin(utilisateurDo.getIsAdmin());
        } else {
            connectedUserDto = null;
        }
        return connectedUserDto;
    }

    /**
     * @param connectedUserDto
     * @return the mapped UtilisateurDto
     */
    public static UtilisateurDto mapConnectedUserDtoToUtilisateurDto(final ConnectedUserDto connectedUserDto) {
        IUtilisateurService ius = UtilisateurService.getInstance();

        return ius.findUtilisateur(connectedUserDto.getId());
    }
}
