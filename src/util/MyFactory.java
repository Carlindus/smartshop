package util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Factory pour instancier les implémentations des interfaces
 * 
 * @author 
 *
 */
public class MyFactory {

    /**
     * Permet de retourner une instance de l'implémentation d'un interface <br/>
     * Cette implémentation doit implémenter une méthode getInstance() en static qui permet d'instancier la classe
     * 
     * @param clazzInterface
     *            interface dont on veut une implémentation
     * @return l'implémentation choisie de l'interface
     */
    public static <T> T getInstance(final Class<T> clazzInterface) {

        // on vérifie si le paramètre est une interface
        if (!clazzInterface.isInterface()) {
            throw new IllegalArgumentException("Ceci n'est pas une interface!");
        }

        // on récupère le nom de l'interface
        final String interfaceName = clazzInterface.getSimpleName();

        // on en déduit le nom de la classe d'implémentation
        final String className = clazzInterface.getPackage().getName() + ".impl." + interfaceName.substring(1);

        // on essaie de charger cette classe pour vérifier son existance
        Class<?> clazzToInstance = null;
        try {
            clazzToInstance = Class.forName(className);
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
            throw new IllegalArgumentException("Aucune implémentation trouvée pour cette interface!");
        }

        // on appelle la méthode getInstance() de l'implémentation
        Object implementation = null;
        try {
            // on récupère la méthode getInstance
            final Method methodToCall = clazzToInstance.getMethod("getInstance", new Class[0]);
            // on l'invoque et on stocke son retour
            implementation = methodToCall.invoke(null);
        } catch (final SecurityException e) {
            e.printStackTrace();
            throw new RuntimeException("Problème de sécurité");
        } catch (final NoSuchMethodException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("La classe d'implémentation ne respecte pas le pattern singleton (getInstance)!");
        } catch (final IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("Accès aux invocation interdit!");
        } catch (final InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException("Problème d'invocation!");
        }

        // on retourne le résultat
        return clazzInterface.cast(implementation);

    }

}
