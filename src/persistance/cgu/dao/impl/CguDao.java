/**
 * 
 */
package persistance.cgu.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import org.apache.struts.tiles.taglib.GetAttributeTag;

import persistance.cgu.dao.ICguDao;

/**
 * @author Robin
 *
 */
public class CguDao implements ICguDao{

    /**
     * @return
     */
    public static ICguDao getInstance() {
        return new CguDao();
    }
    
	/**
	 * Permet de lire le fichier cgu.txt contenant les Conditions Générales d'utilisation
	 */
	@Override
	public String readCgu() {
		String laCgu="";
		
		String filename = "C:/JavaEE/Workspace/smartshop-start/resources/cgu.txt"; // on récupère l'emplacement du fichier à lire
		  try
		  {
		    BufferedReader reader = new BufferedReader(new FileReader(filename)); // on lit notre fichier
		    String line;
		    
		    while ((line = reader.readLine()) != null) // on parcours chaque ligne de notre fichier
		    {
		      laCgu+= line + "\br"; // on stock la ligne dans une String avec un retour à la ligne
		    }
		    reader.close(); // on termine la lecture du fichier
		    return laCgu; // on retourne notre String contenant les lignes de notre fichier
		  }
		  catch (Exception e)
		  {
		    return "" ; // si le fichier n'a pas put être lu on retourne une String vide
		  }
	}
	
}
