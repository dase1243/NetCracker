package DataBase;

import java.util.Date;

/**
 * Created by dreikaa on 11/9/16.
 */
public class Orders {
    private int order_id;
    private int shop_id;
    private int customer_id;
    private int employee_id;
    private int price;

    public Orders() {
    }

    public Orders(int order_id, int shop_id, int customer_id, int employee_id, int price, Date order_date) {

        this.order_id = order_id;
        this.shop_id = shop_id;
        this.customer_id = customer_id;
        this.employee_id = employee_id;
        this.price = price;
        this.order_date = order_date;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    private Date order_date;



}
