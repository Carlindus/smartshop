/**
 * 
 */
package persistance.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Laurent
 *
 */
public class HibernateFactory {

    private static SessionFactory sessionFactory = null;

    /**
     * @return SessionFactory
     */
    public static SessionFactory getSessionFactory() {
        synchronized (HibernateFactory.class) {
            // si la sessionFactory n'est pas initialisée
            if (sessionFactory == null) {
                // on l'initialise
                sessionFactory = new Configuration().configure().buildSessionFactory();
            }
        }

        return sessionFactory;

    }
}