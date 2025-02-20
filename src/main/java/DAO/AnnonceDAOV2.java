package DAO;

import Bean.Annonce;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;
import java.util.ArrayList;

public class AnnonceDAOV2 {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("annoncePU");

    public boolean create(Annonce annonce) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        annonce.setDate(new Timestamp(System.currentTimeMillis()));

        em.persist(annonce);
        em.getTransaction().commit();
        em.close();

        return true;
    }

    public boolean delete(Annonce annonce) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Annonce managedAnnonce = em.find(Annonce.class, annonce.getId());

        em.remove(managedAnnonce);
        em.getTransaction().commit();
        em.close();

        return true;
    }


    public boolean update(Annonce annonce) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        annonce.setDate(new Timestamp(System.currentTimeMillis()));

        em.merge(annonce);
        em.getTransaction().commit();
        em.close();

        return true;
    }


    public Annonce find(int id) {
        EntityManager em = emf.createEntityManager();
        Annonce annonce = em.find(Annonce.class, id);
        em.close();
        return annonce;
    }

    public ArrayList<Annonce> list() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Annonce> query = em.createQuery("SELECT a FROM Annonce a", Annonce.class);
        ArrayList<Annonce> annonces = new ArrayList<>(query.getResultList());
        em.close();
        return annonces;
    }

}
