import Bean.Annonce;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import Hibernate.HibernateUtil;

import java.util.List;


public class Test {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Session session = null;

        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            List<Annonce> annonces = session.createCriteria(Annonce.class).list();
            System.out.println("With CRITERIA API : annonces : "+annonces.size());

            List<Annonce> annoncesHQL = session.createQuery("FROM Annonce").list();
            System.out.println("WITH HQL QUERY : personnesHQL : "+annoncesHQL.size());

            List<Annonce> annoncesSQL = session.createSQLQuery("select * from annonce").list();
            System.out.println("WITH SQL QUERY : personnesSQL : "+annoncesSQL.size());

            tx.commit();
            System.out.println("Done");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
}
