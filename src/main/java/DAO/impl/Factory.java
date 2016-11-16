package DAO.impl;

import DAO.*;

/**
 * Created by dreikaa on 11/16/16.
 */
public class Factory {
    private static Factory instance = null;
    private static CustomerDAO customerDAO = null;
    private static EmployeeDAO employeeDAO = null;
    private static GoodDAO goodDAO = null;
    private static OrderDAO orderDAO = null;
    private static ShopDAO shopDAO = null;
    private static SupplierDAO supplierDAO = null;

    public static synchronized Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public static CustomerDAO getCustomerDAO() {
        if (customerDAO == null) {
            customerDAO = new CustomerDAOImpl();
        }
        return customerDAO;
    }

    public static EmployeeDAO getEmployeeDAO() {
        if (employeeDAO == null) {
            employeeDAO = new EmployeeDAOImpl();
        }
        return employeeDAO;
    }

    public static GoodDAO getGoodDAO() {
        if (goodDAO == null) {
            goodDAO = new GoodDAOImpl();
        }
        return goodDAO;
    }

    public static OrderDAO getOrderDAO() {
        if (orderDAO == null) {
            orderDAO = new OrderDAOImpl();
        }
        return orderDAO;
    }

    public static ShopDAO getShopDAO() {
        if (shopDAO == null) {
            shopDAO = new ShopDAOImpl();
        }
        return shopDAO;
    }

    public static SupplierDAO getSupplierDAO() {
        if (supplierDAO == null) {
            supplierDAO = new SupplierDAOImpl();
        }
        return supplierDAO;
    }

}
