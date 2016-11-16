package DAO;

import DataBase.Good;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by dreikaa on 11/13/16.
 */
public interface GoodDAO {
    public void addGoods(Good good) throws SQLException;
    public void updateGood(Good good) throws SQLException;
    public Good getGoodById(Long id) throws SQLException;
    public Collection<Good> getAllGood() throws SQLException;
    public void deleteGood(Good good) throws SQLException;

}
