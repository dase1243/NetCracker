package DAO.impl;

import DAO.SupplierDAO;
import DataBase.Supplier;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by administrator on 11/16/16.
 */
public class SupplierDAOImpl implements SupplierDAO {

    private Session session;

    public SupplierDAOImpl() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void addSupplier(Supplier supplier) throws SQLException {
        session.beginTransaction();
        session.save(supplier);
        session.getTransaction().commit();
    }

    public void updateSupplier(Supplier supplier) throws SQLException {
        session.beginTransaction();
        session.update(supplier);
        session.getTransaction().commit();
    }

    public Supplier getSupplierById(Long id) throws SQLException {
        Supplier supplier = null;
        supplier = (Supplier) session.load(Supplier.class, id);
        return supplier;
    }

    public Collection<Supplier> getAllSuppliers() throws SQLException {
        List<Supplier> suppliers = new ArrayList<Supplier>();
        suppliers = session.createCriteria(Supplier.class).list();
        return null;
    }

    public void deleteSupplier(Supplier supplier) throws SQLException {
        session.beginTransaction();
        session.delete(supplier);
        session.getTransaction().commit();
    }
}
