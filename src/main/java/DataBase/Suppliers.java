package DataBase;

/**
 * Created by dreikaa on 11/9/16.
 */
public class Suppliers {
    private int supplier_id;
    private int shop_id;
    private String sup_name;
    private String sup_address;

    public Suppliers() {
    }

    public Suppliers(int supplier_id, int shop_id, String sup_name, String sup_address) {
        this.supplier_id = supplier_id;
        this.shop_id = shop_id;
        this.sup_name = sup_name;
        this.sup_address = sup_address;
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
