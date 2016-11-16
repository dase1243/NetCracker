package DAO;

import DataBase.Customer;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by dreikaa on 11/13/16.
 */
public interface CustomerDAO {
    public void addCustomer(Customer customer) throws SQLException;
    public void updateCustomer(Customer customer) throws SQLException;
    public Customer getCustomerById(Long id) throws SQLException;
    public Collection<Customer> getAllCustomers() throws SQLException;
    public void deleteCustomer(Customer customer) throws SQLException;
}
