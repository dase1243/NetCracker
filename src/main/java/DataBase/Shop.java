package DataBase;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dreikaa on 11/9/16.
 */
@Entity
@Table(name = "shops")
public class Shop {
    @Id
    @Column(name = "shop_id")
    private int shop_id;
    @Column(name = "goods_id")
    @ManyToMany
    private Set<Good> good_id = new HashSet<Good>();
    @Column(name = "yield")
    private int yield;
    @Column(name = "shop_name")
    private String shop_name;
    @Column(name = "shop_address")
    private String shop_address;

    public Shop() {
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public Set<Good> getGood_id() {
        return good_id;
    }

    public void setGood_id(Set<Good> good_id) {
        this.good_id = good_id;
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
