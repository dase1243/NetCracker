package DAO.impl;

import DAO.EmployeeDAO;
import DataBase.Employee;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by administrator on 11/16/16.
 */
public class EmployeeDAOImpl implements EmployeeDAO {
    private Session session;

    public EmployeeDAOImpl() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void addEmployee(Employee employee) throws SQLException {
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
    }

    public void updateEmployee(Employee employee) throws SQLException {
        session.beginTransaction();
        session.update(employee);
        session.getTransaction().commit();
    }

    public Employee getEmployeeById(Long id) throws SQLException {
        Employee employee = null;
        employee = (Employee) session.load(Employee.class, id);
        return employee;
    }

    public Collection<Employee> getAllEmployeess() throws SQLException {
        List<Employee> employee = new ArrayList<Employee>();
        employee = session.createCriteria(Employee.class).list();
        return employee;
    }

    public void deleteEmployee(Employee employee) throws SQLException {
        session.beginTransaction();
        session.delete(employee);
        session.getTransaction().commit();
    }
}
