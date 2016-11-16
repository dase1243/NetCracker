package DAO.impl;

import DAO.GoodDAO;
import DataBase.Good;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by administrator on 11/16/16.
 */
public class GoodDAOImpl implements GoodDAO {
    private Session session;

    public GoodDAOImpl() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void addGoods(Good good) throws SQLException {
        session.beginTransaction();
        session.save(good);
        session.getTransaction().commit();
    }

    public void updateGood(Good good) throws SQLException {
        session.beginTransaction();
        session.update(good);
        session.getTransaction().commit();
    }

    public Good getGoodById(Long id) throws SQLException {
        Good good = null;
        good = (Good) session.load(Good.class, id);
        return good;
    }

    public Collection<Good> getAllGood() throws SQLException {
        List<Good> goods = new ArrayList<Good>();
        goods = session.createCriteria(Good.class).list();
        return goods;
    }

    public void deleteGood(Good good) throws SQLException {
        session.beginTransaction();
        session.delete(good);
        session.getTransaction().commit();
    }
}
