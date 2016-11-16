package DataBase;

import javax.persistence.*;

/**
 * Created by dreikaa on 11/9/16.
 */
@Entity
@Table(name = "goods")
public class Good {
    @Id
    @Column(name = "goods_id")
    private int good_id;
    @Column(name = "supplier_id")
    @ManyToMany
    private int supplier_id;
    @Column(name = "customer_id")
    private int customer_id;
    @Column(name = "goods_name")
    private String good_name;
    @Column(name = "groupname")
    private String groupname;

    public Good() {
    }

    public int getGood_id() {
        return good_id;
    }

    public void setGood_id(int good_id) {
        this.good_id = good_id;
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

    public String getGood_name() {
        return good_name;
    }

    public void setGood_name(String good_name) {
        this.good_name = good_name;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }
}
