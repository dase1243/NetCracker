package DataBase;

import java.util.Date;

/**
 * Created by dreikaa on 11/9/16.
 */
public class Customers {
    private int customer_id;
    private String name;
    private String surname;
    private Date red_date;

    public void getFullName() {
        System.out.println(this.name + " " + this.surname);
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public Customers() {
    }

    public Customers(int customer_id, String name, String surname, Date red_date) {

        this.customer_id = customer_id;
        this.name = name;
        this.surname = surname;
        this.red_date = red_date;
    }

    public void setCustomer_id(int customer_id) {

        this.customer_id = customer_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getRed_date() {
        return red_date;
    }

    public void setRed_date(Date red_date) {
        this.red_date = red_date;
    }
}
