package DAO.impl;

import DAO.ShopDAO;
import DataBase.Shop;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by administrator on 11/16/16.
 */
public class ShopDAOImpl implements ShopDAO {
    private Session session;

    public ShopDAOImpl() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void addShop(Shop shop) throws SQLException {
        session.beginTransaction();
        session.save(shop);
        session.getTransaction().commit();
    }

    public void updateShop(Shop shop) throws SQLException {
        session.beginTransaction();
        session.update(shop);
        session.getTransaction().commit();
    }

    public Shop getShopById(Long id) throws SQLException {
        Shop shop = (Shop) session.load(Shop.class, id);
        return shop;
    }

    public Collection<Shop> getAllSuppliers() throws SQLException {
        List<Shop> shops = new ArrayList<Shop>();
        shops = session.createCriteria(Shop.class).list();
        return shops;
    }

    public void deleteShop(Shop shop) throws SQLException {
        session.beginTransaction();
        session.delete(shop);
        session.getTransaction().commit();
    }
}
