package DataBase;

/**
 * Created by dreikaa on 11/9/16.
 */
public class Employees {
    private int employee_id;
    private int shop_id;
    private int salary;
    private String name;
    private String surname;
    private String job_name;

    public Employees() {
    }

    public Employees(int employee_id, int shop_id, int salary, String name, String surname, String job_name) {
        this.employee_id = employee_id;
        this.shop_id = shop_id;
        this.salary = salary;
        this.name = name;
        this.surname = surname;
        this.job_name = job_name;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
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
