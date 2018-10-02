package lessons.lesson30.task2;

import java.util.ArrayList;
import java.util.HashSet;

public class EmployeeDAO {
    private ArrayList<Employee> employees = new ArrayList<>();

    public EmployeeDAO() {
    }

    public Employee add (Employee empl){
        employees.add(empl);
        return empl;
    }

    public void remove(Employee empl){
        employees.remove(empl);
    }

    public ArrayList<Employee> getAll (){
        return employees;
    }

    public HashSet<Employee> employeesByProject(String projectName){
        HashSet<Employee> result = new HashSet<>();
        for(Employee e : employees){
            if(e != null) {
                for (Project project : e.getProjects()) {
                    if (project != null && project.getName().equals(projectName)) {
                        result.add(e);
                    }
                }
            }
        }
        return result;
    }

    public HashSet<Employee> employeesByDepartmentWithoutProject(DepartmentType depType){
        HashSet<Employee> result = new HashSet<>();

        for(Employee e : employees){
            if(e != null && e.getDepartment() != null && e.getDepartment().getDepType() == depType && e.getProjects().size() == 0){
                result.add(e);
            }
        }
        return result;
    }


    public HashSet<Employee> employeesWithoutProject(){
        HashSet<Employee> result = new HashSet<>();

        for(Employee e : employees){
            if(e != null){
                result.add(e);
            }
        }
        return result;
    }

    public HashSet<Employee> employeesByTeamLead(Employee lead){
        HashSet<Employee> result = new HashSet<>();

        for(Project project : lead.getProjects()){
            if(project != null) {
                for (Employee empl : employeesByProject(project.getName())) {
                    if (empl != null && empl.getPosition() != Position.TEAM_LEAD) {
                        result.add(empl);
                    }
                }
            }
        }

        return result;
    }

    public HashSet<Employee> employeesByProjectEmployee(Employee employee){
        HashSet<Employee> result = new HashSet<>();

        for (Project project : employee.getProjects()) {
            if(project != null) {
                result.addAll(employeesByProject(project.getName()));
            }
        }

        return result;
    }

    public HashSet<Employee> employeesByCustomerProjects(Customer customer){
        HashSet<Employee> result = new HashSet<>();

        for (Employee e : employees){
            if(e != null){
                for (Project project : e.getProjects()){
                    if (project != null && project.getCustomer().equals(customer)){
                        result.add(e);
                    }
                }
            }
        }

        return result;
    }

    public HashSet<Employee> teamLeadsByEmployee(Employee employee){
        HashSet<Employee> result = new HashSet<>();

        for(Project project : employee.getProjects()){
            for(Employee empl : employeesByProject(project.getName())){
                if(empl.getPosition() == Position.TEAM_LEAD){
                    result.add(empl);
                }
            }
        }

        return result;
    }

}
