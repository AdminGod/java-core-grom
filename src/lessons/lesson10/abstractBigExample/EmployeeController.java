package lessons.lesson10.abstractBigExample;

public class EmployeeController {

    private Employee[] employees = new Employee[100];

    void paySalariesToEmployees(){
        if(employees == null){
            return;
        }
        for(Employee employee: employees){
            if(employee != null) {
                employee.paySalery();
                System.out.println("Salary was paid successfully to " + employee.getName() + "employee");
            }
        }
    }

    public EmployeeController(Employee[] employees) {
        this.employees = employees;
    }

    public EmployeeController() {
    }

    public Employee[] getEmployees() {
        return employees;
    }
}
