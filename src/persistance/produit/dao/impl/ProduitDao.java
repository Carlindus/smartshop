/**
 * 
 */
package persistance.produit.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import persistance.factory.HibernateFactory;
import persistance.produit.bean.ProduitCommandeDo;
import persistance.produit.bean.ProduitDo;
import persistance.produit.dao.IProduitDao;

/**
 * @author Michelle
 *
 */
public class ProduitDao implements IProduitDao {

    /**
     * CREATION D'UN SINGLETON
     * Permet de se connecter une seule fois (pas de doublons)
     * 
     * @return instance
     */
    private static IProduitDao instance = null;

    // Constructor priv�e pour faire mon getInstance()
    private ProduitDao() {

    }

    public static IProduitDao getInstance() {
        if (instance == null) {
            instance = new ProduitDao();
        }

        return instance;
    }

    // AJOUTER PRODUIT
    @Override
    public ProduitDo addProduit(ProduitDo produitDo) {
        try (final Session session = HibernateFactory.getSessionFactory().openSession()) {
            final Transaction transaction = session.beginTransaction();

            session.save(produitDo);
            session.flush();

            transaction.commit();
            return produitDo;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    // AJOUTER PRODUIT COMMANDE
    @Override
    public ProduitCommandeDo addProduitCommande(ProduitCommandeDo produitCommandeDo) {
        final SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        try (final Session session = sessionFactory.openSession()) {

            final Transaction transaction = session.beginTransaction();

            session.save(produitCommandeDo);
            session.flush();

            transaction.commit();

            return produitCommandeDo;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    // SUPPRIMER UN PRODUIT
    @Override
    public boolean deleteProduit(int idProduit) {
        final SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        try (final Session session = sessionFactory.openSession()) {
            final Transaction transaction = session.beginTransaction();

            final ProduitDo produitDo = session.load(ProduitDo.class, idProduit);
            session.delete(produitDo);

            session.flush();

            transaction.commit();

            return true;
        }
    }

    // TROUVER UN PRODUIT
    /*
     * (non-Javadoc)
     * 
     * @see persistance.produit.dao.IProduitDao#findProduit(int)
     */
    @Override
    public ProduitDo findProduit(final int idProduit) {
        try (final Session session = HibernateFactory.getSessionFactory().openSession()) {
            final Transaction transaction = session.beginTransaction();
            final Query<ProduitDo> query = session.createQuery("From ProduitDo where idProduit = :idParam", ProduitDo.class);

            query.setParameter("idParam", idProduit);

            final ProduitDo produitDo = query.getSingleResult();

            session.flush();
            transaction.commit();

            return produitDo;
        }
    }

    // TROUVER UN PRODUIT COMMANDE
    @Override
    public ProduitCommandeDo findProduitCommande(int idProduitCde) {
        try (final Session session = HibernateFactory.getSessionFactory().openSession()) {

            final Transaction transaction = session.beginTransaction();
            final Query<ProduitCommandeDo> query = session.createQuery("From ProduitCommandeDo where idProduitCde = :idProduitCde", ProduitCommandeDo.class);

            query.setParameter("idProduitCde", idProduitCde);

            final ProduitCommandeDo produitCommandeDo = query.getSingleResult();

            session.flush();

            transaction.commit();

            return produitCommandeDo;
        }
    }

    // TROUVER TOUS LES PRODUITS
    @Override
    public List<ProduitDo> findAllProduit() {
        try (final Session session = HibernateFactory.getSessionFactory().openSession()) {
            final Transaction transaction = session.beginTransaction();
            final Query<ProduitDo> query = session.createQuery("FROM ProduitDo order by idProduit desc", ProduitDo.class);

            final List<ProduitDo> listeProduit = query.getResultList();

            session.flush();

            transaction.commit();
            return listeProduit;

        } catch (final NoResultException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }

    }

    // TROUVER TOUS LES PRODUITS COMMANDES
    @Override
    public List<ProduitCommandeDo> findAllProduitCommande() {
        final SessionFactory sessionFactory = HibernateFactory.getSessionFactory();

        try (final Session session = sessionFactory.openSession()) {
            final Transaction transaction = session.beginTransaction();
            final Query<ProduitCommandeDo> query = session.createQuery("FROM ProduitCommandeDo", ProduitCommandeDo.class);

            final List<ProduitCommandeDo> listeProduitCde = query.getResultList();

            session.flush();

            transaction.commit();
            return listeProduitCde;

        } catch (final NoResultException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // TROUVER TOUS LES PRODUITS EN VENTE
    @Override
    public List<ProduitDo> findAllProduitEnVente() {
        try (final Session session = HibernateFactory.getSessionFactory().openSession()) {
            final Transaction transaction = session.beginTransaction();
            final Query<ProduitDo> query = session.createQuery("FROM ProduitDo where etat = 1 order by reference ASC", ProduitDo.class);

            final List<ProduitDo> listeProduitEnVenteDo = query.getResultList();

            session.flush();

            transaction.commit();

            return listeProduitEnVenteDo;
        } catch (final NoResultException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // MODIFIER UN PRODUIT
    @Override
    public ProduitDo updateProduit(int idProduit, ProduitDo produitDo) {
        final SessionFactory sessionFactory = HibernateFactory.getSessionFactory();

        try (final Session session = sessionFactory.openSession()) {
            final Transaction transaction = session.beginTransaction();

            final Query<?> query = session.createQuery(
                    "UPDATE ProduitDo set reference = :reference, description = :description, prix = :prix, image = :image, etat = :etat " + "where idProduit = :idProduit");

            query.setParameter("reference", produitDo.getReference());
            query.setParameter("description", produitDo.getDescription());
            query.setParameter("prix", produitDo.getPrix());
            query.setParameter("image", produitDo.getImage());
            query.setParameter("etat", produitDo.getEtat());
            query.setParameter("idProduit", idProduit);
            query.executeUpdate();

            produitDo.setIdProduit(idProduit);

            session.flush();

            transaction.commit();

            return produitDo;
        }
    }

}
