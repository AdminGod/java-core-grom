package lessons.lesson30.task2;

import java.util.ArrayList;
import java.util.Objects;

public class Department {

    private DepartmentType depType;
    private ArrayList<Employee> employees;

    public Department(DepartmentType depType, ArrayList<Employee> employees) {
        this.depType = depType;
        this.employees = employees;
    }

    public DepartmentType getDepType() {
        return depType;
    }

    public void setDepType(DepartmentType depType) {
        this.depType = depType;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return depType == that.depType &&
                Objects.equals(employees, that.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(depType, employees);
    }
    /**
    @Override
    public String toString() {
        return "Department{" +
                "depType=" + depType +
                ", employees=" + employees +
                '}';
    }
    */
}
