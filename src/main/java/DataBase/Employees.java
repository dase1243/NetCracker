package DataBase;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dreikaa on 11/9/16.
 */
@Entity
@Table(name = "employees")
public class Employees {
    @Id
    @Column(name = "employee_id")
    private int employee_id;
    @Column(name = "shop_id")
    @OneToMany
    private Set<Shops> shop_id = new HashSet<Shops>();
    @Column(name = "salary")
    private int salary;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "job_name")
    private String job_name;

    public Employees() {
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public Set<Shops> getShop_id() {
        return shop_id;
    }

    public void setShop_id(Set<Shops> shop_id) {
        this.shop_id = shop_id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return this.name + this.surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getJob_name() {
        return job_name;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }
}
