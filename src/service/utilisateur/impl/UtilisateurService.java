/**
 * 
 */
package service.utilisateur.impl;

import persistance.produit.bean.ProduitDo;
import persistance.produit.dao.IProduitDao;
import persistance.utilisateur.bean.UtilisateurDo;
import persistance.utilisateur.dao.IUtilisateurDao;
import presentation.utilisateur.bean.ConnectedUserDto;
import service.commande.ICommandeService;
import service.produit.impl.ProduitMapper;
import service.utilisateur.IUtilisateurService;

import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.List;
import presentation.utilisateur.bean.UtilisateurDto;
import service.utilisateur.UtilisateurMapper;
import util.MD5;
import util.MyFactory;

/**
 * @author Caroline
 *
 */
public class UtilisateurService implements IUtilisateurService {

    /**
     * @return
     * 
     *         pour l'instance
     */
    /**
     * @return
     */
    public static IUtilisateurService getInstance() {
        return new UtilisateurService();
    }
 
    /*
     * (non-Javadoc)
     * 
     * @see service.utilisateur.IUtilisateurService#findUtilisateur(java.lang.String, java.lang.String)
     */
    @Override
    public ConnectedUserDto findUtilisateur(final String login, final String password) {
       final IUtilisateurDao utilisateurDao = MyFactory.getInstance(IUtilisateurDao.class);
        // Cryptage du mot de passe ici    :-)
       UtilisateurDo utilisateurDo = null;
	try {
	    System.out.println("TRY DAO");
		utilisateurDo = utilisateurDao.findUtilisateur(login, MD5.getMD5(password));
	} catch (NoSuchAlgorithmException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
        return UtilisateurMapper.mapUtilisateurDoToConnectedUserDto(utilisateurDo);
    }

    /*
     * (non-Javadoc)
     * 
     * @see service.utilisateur.IUtilisateurService#findUtilisateur(int)
     */
    @Override
    public UtilisateurDto findUtilisateur(final int idUtilisateur) {
    	final IUtilisateurDao utilisateurDao = MyFactory.getInstance(IUtilisateurDao.class);
    	final UtilisateurDo utilisateurDo = utilisateurDao.findUtilisateur(idUtilisateur);
        return UtilisateurMapper.mapDoToDto(utilisateurDo);
       }

    /*
     * (non-Javadoc)
     * 
     * @see service.utilisateur.IUtilisateurService#findAllUtilisateur()
     */
    @Override
    public List<UtilisateurDto> findAllUtilisateur() {
    	final IUtilisateurDao utilisateurDao = MyFactory.getInstance(IUtilisateurDao.class);
    	final List<UtilisateurDo> listeUtilisateurDo = utilisateurDao.findAllUtilisateurDo();

        return UtilisateurMapper.mapListDoToListDto(listeUtilisateurDo);
    }

    /* (non-Javadoc)
     * @see service.utilisateur.IUtilisateurService#deleteUtilisateurDto(int)
     */
    @Override
    public boolean deleteUtilisateurDto(final int id) {
       try { final ICommandeService commandeService = MyFactory.getInstance(ICommandeService.class);
        commandeService.supprimerAssociation(id);
        final IUtilisateurDao utilisateurDao = MyFactory.getInstance(IUtilisateurDao.class);
    	utilisateurDao.deleteUtilisateur(id);
        return true;}
       catch (Exception e) {
    	   return false;
       }
    }

	@Override
	public UtilisateurDto addUtilisateur(UtilisateurDto utilisateurDto) {
		// TODO Auto-generated method stub
		IUtilisateurDao userDao = MyFactory.getInstance(IUtilisateurDao.class);
        
		UtilisateurDo userDo = null;
        try {
            userDo = userDao.addUtilisateur(UtilisateurMapper.mapDtoToDo(utilisateurDto));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return UtilisateurMapper.mapDoToDto(userDo);
	}

	@Override
	public UtilisateurDto updateUtilisateur(final int id,UtilisateurDto utilisateurDto) {
		// TODO Auto-generated method stub
IUtilisateurDao userDao = MyFactory.getInstance(IUtilisateurDao.class);
			UtilisateurDo userDo = null;
            try {
                userDo = userDao.updateUtilisateur(id, UtilisateurMapper.mapDtoToDo(utilisateurDto));
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
	        return UtilisateurMapper.mapDoToDto(userDo);
        
	}

}
