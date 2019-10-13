/**
 * 
 */
package persistance.commande.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import persistance.commande.bean.CommandeDo;
import persistance.commande.bean.LigneCommandeDo;
import persistance.commande.dao.ICommandeDao;
import persistance.factory.HibernateFactory;

/**
 * @author Guilaume
 *
 */
public class CommandeDao implements ICommandeDao {

    public static ICommandeDao getInstance() {
        return new CommandeDao();
    }

    final SessionFactory sessionFactory = HibernateFactory.getSessionFactory();

    /**
     * 
     * @param commandeDo
     * @param produitCommandeDo
     * @param ligneCommandeDo
     * @return
     */
    @Override
    public CommandeDo addCommande(CommandeDo commandeDo) {
        try (final Session session = sessionFactory.openSession()) {
            final Transaction transaction = session.beginTransaction();

            session.save(commandeDo);

            transaction.commit();
            return commandeDo;
        }
    }

    @Override
    public LigneCommandeDo addLigneCommande(LigneCommandeDo ligneCommandeDo) {
        try (final Session session = sessionFactory.openSession()) {
            final Transaction transaction = session.beginTransaction();

            session.save(ligneCommandeDo);

            transaction.commit();
            return ligneCommandeDo;
        }
    }

    /**
     * @param id
     * @return
     */
    @Override
    public List<CommandeDo> findAllCommandeByUtilisateur(final int id) {
        try (final Session session = sessionFactory.openSession()) {
            final Transaction transaction = session.beginTransaction();
            final Query<CommandeDo> query = session.createQuery("FROM CommandeDo WHERE idUtilisateur = :idParam", CommandeDo.class);

            query.setParameter("idParam", id);

            final List<CommandeDo> commandeDo = query.getResultList();

            session.flush();
            transaction.commit();
            return commandeDo;
        }
    }

    /**
     * @return
     */
    @Override
    public List<CommandeDo> findAllCommande() {
        try (final Session session = sessionFactory.openSession()) {
            final Transaction transaction = session.beginTransaction();
            final Query<CommandeDo> query = session.createQuery("FROM CommandeDo", CommandeDo.class);

            final List<CommandeDo> commandeDo = query.getResultList();

            session.flush();
            transaction.commit();
            return commandeDo;
        }
    }

    /**
     * @param idCommande
     * @return
     */
    @Override
    public CommandeDo findCommande(final int idCommande) {
        try (final Session session = sessionFactory.openSession()) {
            final Transaction transaction = session.beginTransaction();
            final Query<CommandeDo> query = session.createQuery("FROM CommandeDo WHERE idCde = :idParam", CommandeDo.class);

            query.setParameter("idParam", idCommande);

            final CommandeDo commandeDo = query.getSingleResult();

            session.flush();
            transaction.commit();
            return commandeDo;
        }
    }

    /**
     * remove idUtilisateur from a order(s).
     * 
     * @param idUser
     * @return boolean
     */
    @Override
    public boolean supprimerAssociation(final int idUser) {
        try (final Session session = HibernateFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            final Query<CommandeDo> query = session.createQuery("UPDATE CommandeDo as cd SET cd.idUtilisateur = NULL WHERE cd.idUtilisateur=:id");
            query.setParameter("id", idUser);
            query.executeUpdate();
            session.flush();
            transaction.commit();
            return true;
        } catch (final HibernateException e) {
            e.printStackTrace();
            return false;
        }

    }
}
