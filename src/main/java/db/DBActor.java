package db;

import models.Actor;
import models.Placement;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBActor {

    private static Transaction transaction;
    private static Session session;

    public static List<Placement> findPlacementsForActor(Actor actor){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Placement> results = null;
        try {
            Criteria cr = session.createCriteria(Placement.class);
            cr.add(Restrictions.eq("actor", actor));
            results = cr.list();
        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }

        return results;
    }
}

