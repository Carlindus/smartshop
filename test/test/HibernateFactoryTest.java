/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import persistance.factory.HibernateFactory;



/**
 * @author Formation
 *
 */
public class HibernateFactoryTest {

	/**
	 * Test method for {@link factory.HibernateFactory#getSessionFactory()}.
	 */
	@Test
    public final void testGetSessionFactory() {
//      assertNotNull(HibernateFactory.getSessionFactory());
        final SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        assertNotNull(sessionFactory);
        try (final Session session = sessionFactory.openSession()) {
            assertNotNull(session);
            assertNotNull(session.createNativeQuery("select 1 from dual;").getSingleResult());
        }
    }
}
