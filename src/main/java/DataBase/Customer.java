package DataBase;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by dreikaa on 11/9/16.
 */
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @Column(name = "customer_id")
    private int customer_id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "red_date")
    @Temporal(value = TemporalType.DATE)
    private Date red_date;

    public Customer() {
    }

    public void getFullName() {
        System.out.println(this.name + " " + this.surname);
    }

    public int getCustomer_id() {
        return customer_id;
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
