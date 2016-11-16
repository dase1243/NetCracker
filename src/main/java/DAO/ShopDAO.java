package DAO;

import DataBase.Shop;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by dreikaa on 11/13/16.
 */
public interface ShopDAO {
    public void addShop(Shop shop) throws SQLException;
    public void updateShop(Shop shop) throws SQLException;
    public Shop getShopById(Long id) throws SQLException;
    public Collection<Shop> getAllSuppliers() throws SQLException;
    public void deleteShop(Shop shop) throws SQLException;
}
