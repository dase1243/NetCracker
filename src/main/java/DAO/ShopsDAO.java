package DAO;

import DataBase.Shops;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by dreikaa on 11/13/16.
 */
public interface ShopsDAO {
    public void addShop(Shops shop) throws SQLException;
    public void updateShop(Shops shop) throws SQLException;
    public Shops getShopById(Long id) throws SQLException;
    public Collection<Shops> getAllSuppliers() throws SQLException;
    public void deleteShop(Shops shop) throws SQLException;
}
