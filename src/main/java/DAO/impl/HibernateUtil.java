package DAO.impl;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by administrator on 11/16/16.
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutDown() {
        //closes caches and connections
        getSessionFactory().close();
    }
}
