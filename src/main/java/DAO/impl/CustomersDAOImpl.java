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
import util.HibernateUtil;

/**
 * Created by dreikaa on 11/13/16.
 */
public class CustomersDAOImpl implements CustomersDAO {
    private Session session;

    public CustomersDAOImpl(){
        session =
        //session = HibernateUtil.getSessionFactory().openSession();
    }

    public void addCustomer(Customers customer) throws SQLException {

    }

    public void updateCustomer(Customers customer) throws SQLException {

    }

    public Customers getCustomerById(Long id) throws SQLException {
        return null;
    }

    public Collection<Customers> getAllCustomers() throws SQLException {
        return null;
    }

    public void deleteCustomer(Customers customer) throws SQLException {

    }
}
