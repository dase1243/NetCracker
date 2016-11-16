package DAO;

import DataBase.Employees;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by dreikaa on 11/13/16.
 */
public interface EmployeesDAO {
    public void addEmployee(Employees employee) throws SQLException;
    public void updateEmployee(Employees employee) throws SQLException;
    public Employees getEmployeeById(Long id) throws SQLException;
    public Collection<Employees> getAllEmployeess() throws SQLException;
    public void deleteEmployee(Employees employee) throws SQLException;
}
