package db;

import models.Author;
import models.Play;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBAuthor {

    private static Transaction transaction;
    private static Session session;

    public static List<Play> findPlaysForAuthor(Author author){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Play> results = null;
        try {
            Criteria cr = session.createCriteria(Play.class);
            cr.add(Restrictions.eq("author", author));
            results = cr.list();
        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }

        return results;
    }
}
