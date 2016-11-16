package DAO.impl;

import DAO.CustomersDAO;
import DataBase.Customers;

import java.sql.SQLException;
import java.util.Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.jmx.HibernateService;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by dreikaa on 11/13/16.
 */
public class CustomersDAOImpl implements CustomersDAO {
    private Session session;

    public CustomersDAOImpl() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void addCustomer(Customers customer) throws SQLException {
        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
    }

    public void updateCustomer(Customers customer) throws SQLException {
        session.beginTransaction();
        session.update(customer);
        session.getTransaction().commit();
    }

    public Customers getCustomerById(Long id) throws SQLException {
        Customers customer = null;
        customer = (Customers) session.load(Customers.class, id);
        return customer;
    }

    public Collection<Customers> getAllCustomers() throws SQLException {
        List<Customers> customer = new ArrayList<Customers>();
        customer = session.createCriteria(Customers.class).list();
        return customer;
    }

    public void deleteCustomer(Customers customer) throws SQLException {
        session.beginTransaction();
        session.delete(customer);
        session.getTransaction().commit();
    }
}

