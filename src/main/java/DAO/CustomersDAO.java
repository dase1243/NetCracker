package DAO;

import DataBase.Customers;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by dreikaa on 11/13/16.
 */
public interface CustomersDAO {
    public void addCustomer(Customers customer) throws SQLException;
    public void updateCustomer(Customers customer) throws SQLException;
    public Customers getCustomerById(Long id) throws SQLException;
    public Collection<Customers> getAllCustomers() throws SQLException;
    public void deleteCustomer(Customers customer) throws SQLException;
}
