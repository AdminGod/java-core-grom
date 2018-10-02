package lessons.lesson30.task2;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Firm {
    private Date dateFounded;
    private ArrayList<Department> departments;
    private ArrayList<Customer> customers;

    public Firm(Date dateFounded, ArrayList<Department> departments, ArrayList<Customer> customers) {
        this.dateFounded = dateFounded;
        this.departments = departments;
        this.customers = customers;
    }

    public Date getDateFounded() {
        return dateFounded;
    }

    public void setDateFounded(Date dateFounded) {
        this.dateFounded = dateFounded;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(ArrayList<Department> departments) {
        this.departments = departments;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Firm firm = (Firm) o;
        return Objects.equals(dateFounded, firm.dateFounded) &&
                Objects.equals(departments, firm.departments) &&
                Objects.equals(customers, firm.customers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateFounded, departments, customers);
    }
}
