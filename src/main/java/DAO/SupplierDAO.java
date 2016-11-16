package DAO;

import DataBase.Suppliers;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by dreikaa on 11/13/16.
 */
public interface SuppliersDAO {
    public void addSupplier(Suppliers supplier) throws SQLException;
    public void updateSupplier(Suppliers supplier) throws SQLException;
    public Suppliers getSupplierById(Long id) throws SQLException;
    public Collection<Suppliers> getAllSuppliers() throws SQLException;
    public void deleteSupplier(Suppliers supplier) throws SQLException;
}
