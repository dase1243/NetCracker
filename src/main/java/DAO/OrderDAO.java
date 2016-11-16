package DAO;

import DataBase.Order;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by dreikaa on 11/13/16.
 */
public interface OrderDAO {
    public void addOrder(Order order) throws SQLException;
    public void updateOrder(Order order) throws SQLException;
    public Order getOrderById(Long id) throws SQLException;
    public Collection<Order> getAllOrders() throws SQLException;
    public void deleteOrder(Order order) throws SQLException;
}
