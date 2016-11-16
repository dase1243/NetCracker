package DataBase;

import javax.persistence.*;

/**
 * Created by dreikaa on 11/9/16.
 */
@Entity
@Table(name = "goods")
public class Goods {
    @Id
    @Column(name="goods_id")
    private int goods_id;
    @Column(name="supplier_id")
    @ManyToMany
    private int supplier_id;
    @Column(name="customer_id")
    private int customer_id;
    @Column(name="goods_name")
    private String goods_name;
    @Column(name="groupname")
    private String groupname;

    public Goods() {
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }
}
