package DAO.impl;

import DAO.OrderDAO;
import DataBase.Order;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by administrator on 11/16/16.
 */
public class OrderDAOImpl implements OrderDAO {
    private Session session;

    public OrderDAOImpl() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void addOrder(Order order) throws SQLException {
        session.beginTransaction();
        session.save(order);
        session.getTransaction().commit();
    }

    public void updateOrder(Order order) throws SQLException {
        session.beginTransaction();
        session.update(order);
        session.getTransaction().commit();
    }

    public Order getOrderById(Long id) throws SQLException {
        Order order = null;
        order = (Order) session.load(Order.class, id);
        return order;
    }

    public Collection<Order> getAllOrders() throws SQLException {
        List<Order> orders = new ArrayList<Order>();
        orders = session.createCriteria(Order.class).list();
        return orders;
    }

    public void deleteOrder(Order order) throws SQLException {
        session.beginTransaction();
        session.delete(order);
        session.getTransaction().commit();
    }
}
