package DAO;

import DataBase.Supplier;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by dreikaa on 11/13/16.
 */
public interface SupplierDAO {
    public void addSupplier(Supplier supplier) throws SQLException;
    public void updateSupplier(Supplier supplier) throws SQLException;
    public Supplier getSupplierById(Long id) throws SQLException;
    public Collection<Supplier> getAllSuppliers() throws SQLException;
    public void deleteSupplier(Supplier supplier) throws SQLException;
}
