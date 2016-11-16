package DAO;

import DataBase.Orders;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by dreikaa on 11/13/16.
 */
public interface OrdersDAO {
    public void addOrder(Orders order) throws SQLException;
    public void updateOrder(Orders orders) throws SQLException;
    public Orders getOrderById(Long id) throws SQLException;
    public Collection<Orders> getAllOrders() throws SQLException;
    public void deleteOrder(Orders orders) throws SQLException;
}
