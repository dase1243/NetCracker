package DataBase;

import javax.persistence.*;

/**
 * Created by dreikaa on 11/9/16.
 */
@Entity
@Table(name = "suppliers")
public class Suppliers {
    @Id
    @Column(name = "supplier_id")
    private int supplier_id;
    @Column(name = "shop_id")
    @ManyToMany
    private int shop_id;
    @Column(name = "sup_name")
    private String sup_name;
    @Column(name = "sup_address")
    private String sup_address;

    public Suppliers() {
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public String getSup_name() {
        return sup_name;
    }

    public void setSup_name(String sup_name) {
        this.sup_name = sup_name;
    }

    public String getSup_address() {
        return sup_address;
    }

    public void setSup_address(String sup_address) {
        this.sup_address = sup_address;
    }
}
