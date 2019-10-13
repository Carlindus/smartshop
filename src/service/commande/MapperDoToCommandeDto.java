/**
 * 
 */
package service.commande;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import persistance.commande.bean.CommandeDo;
import presentation.commande.bean.CommandeDto;

/**
 * @author Guilaume
 *
 */
public class MapperDoToCommandeDto {

	/**
	 * Attribut
	 */
    private static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Constructor
     */
    public MapperDoToCommandeDto() {
		// Empty
	}
    
    /**
     * Convert listeCommandeDo to listeCommandeDto
     * @param listeCommandeDo
     * @return listeCommandeDto
     */
    public static List<CommandeDto> mapperListDoDto(final List<CommandeDo> listeCommandeDo) {
        List<CommandeDto> listeCommandeDto = new ArrayList<>();
        for (CommandeDo commandeDo : listeCommandeDo) {
            listeCommandeDto.add(mapperDoDto(commandeDo));
        }
        return listeCommandeDto;
    }

    /**
     * Convert commandeDo to commandeDto
     * @param commandeDo
     * @return commandeDto
     */
    public static CommandeDto mapperDoDto(final CommandeDo commandeDo) {
        CommandeDto commandeDto = new CommandeDto();
        commandeDto.setIdCde(commandeDo.getIdCde());
        commandeDto.setIdUtilisateur(commandeDo.getIdUtilisateur());
        commandeDto.setAdresseFacturation(commandeDo.getAdresseFacturation());
        commandeDto.setAdresseLivraison(commandeDo.getAdresseLivraison());
        commandeDto.setDateCde(commandeDo.getDateCde());
        commandeDto.setMontantRemise(commandeDo.getMontantRemise());
        commandeDto.setMontantTotal(commandeDo.getMontantTotal());
        commandeDto.setLigneCommandeSet(commandeDo.getLigneCommandeSet());
        return commandeDto;
    }

}
