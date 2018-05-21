package db;

import models.Placement;
import models.Play;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import sun.jvm.hotspot.utilities.Interval;


import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

public class DBPlay {

    private static Transaction transaction;
    private static Session session;

    public static List<Placement> findCharactersForPlay(Play play){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Placement> results = null;
        try {
            Criteria cr = session.createCriteria(Placement.class);
            cr.add(Restrictions.eq("play", play));
            results = cr.list();
        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }

        return results;
    }

}
