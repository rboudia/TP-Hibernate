package DAO;

import Bean.Annonce;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.lang.reflect.Array;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AnnonceDAOV2  {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("annoncePU");

    public boolean create(Annonce annonce) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        annonce.setDate(new Timestamp(System.currentTimeMillis()));

        em.persist(annonce);  // ✅ INSERT automatique
        em.getTransaction().commit();
        em.close();

        return true;
    }

    public boolean delete(Annonce annonce) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // Rechercher l'entité pour la rattacher au contexte persistant
        Annonce managedAnnonce = em.find(Annonce.class, annonce.getId());

        if (managedAnnonce != null) {
            em.remove(managedAnnonce); // ✅ Supprimer uniquement une entité attachée
        }

        em.getTransaction().commit();
        em.close();

        return managedAnnonce != null;  // Retourne true si suppression réussie
    }


    public boolean update(Annonce annonce) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // ✅ Mettre à jour la date avant merge
        annonce.setDate(new Timestamp(System.currentTimeMillis()));

        em.merge(annonce);  // ✅ UPDATE automatique

        em.getTransaction().commit();
        em.close();

        return true;
    }


    public Annonce find(int id) {
        EntityManager em = emf.createEntityManager();
        Annonce annonce = em.find(Annonce.class, id);  // ✅ SELECT automatique
        em.close();
        return annonce;
    }

    public ArrayList<Annonce> list() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Annonce> query = em.createQuery("SELECT a FROM Annonce a", Annonce.class);
        ArrayList<Annonce> annonces = new ArrayList<>(query.getResultList()); // ✅ Conversion correcte
        em.close();
        return annonces;
    }

}
