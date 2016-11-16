package DAO;

import DataBase.Goods;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by dreikaa on 11/13/16.
 */
public interface GoodsDAO {
    public void addGoods(Goods goods) throws SQLException;
    public void updateGoods(Goods goods) throws SQLException;
    public Goods getGoodsById(Long id) throws SQLException;
    public Collection<Goods> getAllGoods() throws SQLException;
    public void deleteGoods(Goods goods) throws SQLException;

}
