/**
 * 
 */
package persistance.utilisateur.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import persistance.factory.HibernateFactory;
import persistance.utilisateur.bean.UtilisateurDo;
import persistance.utilisateur.dao.IUtilisateurDao;

/**
 * @author Caroline
 *
 */

public class UtilisateurDao implements IUtilisateurDao {

    /**
     * @return
     */
    public static IUtilisateurDao getInstance() {
        return new UtilisateurDao();
    }

    @Override
    public UtilisateurDo addUtilisateur(UtilisateurDo utilisateurDo) {
        try (final Session session = HibernateFactory.getSessionFactory().openSession()) {
            final Transaction transaction = session.beginTransaction();

            session.save(utilisateurDo);
            session.flush();

            transaction.commit();
            return utilisateurDo;
        }
    }

    @Override
    public UtilisateurDo updateUtilisateur(int idUtilisateur, UtilisateurDo utilisateur) {
        // TODO Auto-generated method stub
        final SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        try (final Session session = sessionFactory.openSession()) {
            final Transaction transaction = session.beginTransaction();

            final Query<?> query = session
                    .createQuery("UPDATE UtilisateurDo set nom = :nom, prenom = :prenom, email = :email, login = :login, motDePasse = :motDePasse, isAdmin = :isAdmin,"
                            + " isActif = :isActif, adresseLivraison = :adresseLiv, adresseFacturation = :adresseFact, dateNaissance = :dateNaissance where id = :idUtilisateur");

            query.setParameter("nom", utilisateur.getNom());
            query.setParameter("prenom", utilisateur.getPrenom());
            query.setParameter("email", utilisateur.getEmail());
            query.setParameter("login", utilisateur.getLogin());
            query.setParameter("motDePasse", utilisateur.getMotDePasse());
            query.setParameter("isAdmin", utilisateur.getIsAdmin());
            query.setParameter("isActif", utilisateur.getIsActif());
            query.setParameter("adresseLiv", utilisateur.getAdresseLivraison());
            query.setParameter("adresseFact", utilisateur.getAdresseFacturation());
            query.setParameter("dateNaissance", utilisateur.getDateNaissance());
            query.setParameter("idUtilisateur", idUtilisateur);
            query.executeUpdate();

            session.flush();
            transaction.commit();
            return utilisateur;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public UtilisateurDo findUtilisateur(int idUtilisateur) {
        try (final Session session = HibernateFactory.getSessionFactory().openSession()) {
            final Transaction transaction = session.beginTransaction();

            final Query<UtilisateurDo> query = session.createQuery("From UtilisateurDo where id = :idParam", UtilisateurDo.class);

            query.setParameter("idParam", idUtilisateur);

            UtilisateurDo userDo = query.getSingleResult();

            session.flush();
            transaction.commit();

            return userDo;

        } catch (final NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public UtilisateurDo findUtilisateur(String login, String password) {
        // TODO Auto-generated method stub
        try (final Session session = HibernateFactory.getSessionFactory().openSession()) {
            final Transaction transaction = session.beginTransaction();

            final Query<UtilisateurDo> query = session.createQuery("From UtilisateurDo where login like :loginParam AND motDePasse like :mdpParam", UtilisateurDo.class);

            query.setParameter("loginParam", login);
            query.setParameter("mdpParam", password);
            final UtilisateurDo userDo = query.getSingleResult();

            session.flush();
            transaction.commit();

            return userDo;

        } catch (final NoResultException e) {
            return null;
        }
    }

    @Override
    public List<UtilisateurDo> findAllUtilisateurDo() {
        // TODO Auto-generated method stub
        try (final Session session = HibernateFactory.getSessionFactory().openSession()) {
            final Transaction transaction = session.beginTransaction();
            final Query<UtilisateurDo> query = session.createQuery("From UtilisateurDo WHERE isAdmin = :statut", UtilisateurDo.class);
            query.setParameter("statut", false);
            final List<UtilisateurDo> listeUtilisateurDo = query.getResultList();

            session.flush();
            transaction.commit();

            return listeUtilisateurDo;

        }
    }

    @Override
    public boolean deleteUtilisateur(int id) {
        // TODO Auto-generated method stub
        final SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        try (final Session session = sessionFactory.openSession()) {
            final Transaction transaction = session.beginTransaction();
            final UtilisateurDo utilisateurDo = session.load(UtilisateurDo.class, id);
            session.delete(utilisateurDo);

            session.flush();
            transaction.commit();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
