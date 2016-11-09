package DataBase;

/**
 * Created by dreikaa on 11/9/16.
 */
public class Goods {
    private int goods_id;
    private int supplier_id;
    private int customer_id;
    private String goods_name;
    private String groupname;

    public Goods() {
    }

    public Goods(int goods_id, int supplier_id, int customer_id, String goods_name, String groupname) {
        this.goods_id = goods_id;
        this.supplier_id = supplier_id;
        this.customer_id = customer_id;
        this.goods_name = goods_name;
        this.groupname = groupname;
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
