package DAO.impl;

import DAO.CustomerDAO;
import DataBase.Customer;

import java.sql.SQLException;
import java.util.Collection;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

/**
 * Created by dreikaa on 11/13/16.
 */
public class CustomerDAOImpl implements CustomerDAO {
    private Session session;

    public CustomerDAOImpl() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void addCustomer(Customer customer) throws SQLException {
        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
    }

    public void updateCustomer(Customer customer) throws SQLException {
        session.beginTransaction();
        session.update(customer);
        session.getTransaction().commit();
    }

    public Customer getCustomerById(Long id) throws SQLException {
        Customer customer = null;
        customer = (Customer) session.load(Customer.class, id);
        return customer;
    }

    public Collection<Customer> getAllCustomers() throws SQLException {
        List<Customer> customer = new ArrayList<Customer>();
        customer = session.createCriteria(Customer.class).list();
        return customer;
    }

    public void deleteCustomer(Customer customer) throws SQLException {
        session.beginTransaction();
        session.delete(customer);
        session.getTransaction().commit();
    }
}

