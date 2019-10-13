package util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Factory pour instancier les impl�mentations des interfaces
 * 
 * @author 
 *
 */
public class MyFactory {

    /**
     * Permet de retourner une instance de l'impl�mentation d'un interface <br/>
     * Cette impl�mentation doit impl�menter une m�thode getInstance() en static qui permet d'instancier la classe
     * 
     * @param clazzInterface
     *            interface dont on veut une impl�mentation
     * @return l'impl�mentation choisie de l'interface
     */
    public static <T> T getInstance(final Class<T> clazzInterface) {

        // on v�rifie si le param�tre est une interface
        if (!clazzInterface.isInterface()) {
            throw new IllegalArgumentException("Ceci n'est pas une interface!");
        }

        // on r�cup�re le nom de l'interface
        final String interfaceName = clazzInterface.getSimpleName();

        // on en d�duit le nom de la classe d'impl�mentation
        final String className = clazzInterface.getPackage().getName() + ".impl." + interfaceName.substring(1);

        // on essaie de charger cette classe pour v�rifier son existance
        Class<?> clazzToInstance = null;
        try {
            clazzToInstance = Class.forName(className);
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
            throw new IllegalArgumentException("Aucune impl�mentation trouv�e pour cette interface!");
        }

        // on appelle la m�thode getInstance() de l'impl�mentation
        Object implementation = null;
        try {
            // on r�cup�re la m�thode getInstance
            final Method methodToCall = clazzToInstance.getMethod("getInstance", new Class[0]);
            // on l'invoque et on stocke son retour
            implementation = methodToCall.invoke(null);
        } catch (final SecurityException e) {
            e.printStackTrace();
            throw new RuntimeException("Probl�me de s�curit�");
        } catch (final NoSuchMethodException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("La classe d'impl�mentation ne respecte pas le pattern singleton (getInstance)!");
        } catch (final IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("Acc�s aux invocation interdit!");
        } catch (final InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException("Probl�me d'invocation!");
        }

        // on retourne le r�sultat
        return clazzInterface.cast(implementation);

    }

}
