package DataBase;

import javax.persistence.*;

/**
 * Created by dreikaa on 11/9/16.
 */
@Entity
@Table(name = "shops")
public class Shops {
    @Id
    @Column(name = "shop_id")
    private int shop_id;
    @Column(name = "goods_id")
    @ManyToMany
    private int goods_id;
    @Column(name = "yield")
    private int yield;
    @Column(name = "shop_name")
    private String shop_name;
    @Column(name = "shop_address")
    private String shop_address;

    public Shops() {
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public int getYield() {
        return yield;
    }

    public void setYield(int yield) {
        this.yield = yield;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getShop_address() {
        return shop_address;
    }

    public void setShop_address(String shop_address) {
        this.shop_address = shop_address;
    }
}
