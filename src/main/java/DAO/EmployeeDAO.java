package DAO;

import DataBase.Employee;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by dreikaa on 11/13/16.
 */
public interface EmployeeDAO {
    public void addEmployee(Employee employee) throws SQLException;

    public void updateEmployee(Employee employee) throws SQLException;

    public Employee getEmployeeById(Long id) throws SQLException;

    public Collection<Employee> getAllEmployeess() throws SQLException;

    public void deleteEmployee(Employee employee) throws SQLException;
}
