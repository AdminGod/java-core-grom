package lessons.lesson30.task2;

import java.util.ArrayList;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        //customers
        Customer customer1 = new Customer("Customer_test1", "UA", 1000);
        Customer customer2 = new Customer("Customer_test2", "RUS", 2000);
        //Projects
        Project project1 = new Project("CRM", customer1);
        Project project2 = null;
        Project project3 = new Project("CRM", customer2);

        ArrayList<Project> projects1 = new ArrayList<>();
        ArrayList<Project> projects2 = new ArrayList<>();
        ArrayList<Project> projects3 = new ArrayList<>();

        projects1.add(project1);
        projects1.add(project2);

        projects3.add(project1);
        projects3.add(project2);
        projects3.add(project3);
        //Departments
        Department devDep = new Department(DepartmentType.IT, new ArrayList<>());
        Department financeDep = new Department(DepartmentType.FINANCE, new ArrayList<>());
        //EMPLOYEES
        Employee empl_1 = new Employee("Employee-1 FirstName", "Employee-1 SecondName", new Date(), Position.DEVELOPER, devDep, projects1);
        Employee empl_2 = new Employee("Employee-2 FirstName", "Employee-2 SecondName", new Date(), Position.DEVELOPER, null, new ArrayList<>());
        Employee empl_3 = new Employee("Employee-3 FirstName", "Employee-3 SecondName", new Date(), Position.TEAM_LEAD, devDep, projects3);
        Employee empl_5 = new Employee("Employee-5 FirstName", "Employee-3 SecondName", new Date(), Position.TEAM_LEAD, financeDep, new ArrayList<>());
        Employee empl_4 = new Employee("Employee-4 FirstName", "Employee-4 SecondName", new Date(), Position.DEVELOPER, financeDep, projects3);
        //DAOs
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.add(empl_1);
        employeeDAO.add(empl_2);
        employeeDAO.add(empl_3);
        employeeDAO.add(empl_4);
        employeeDAO.add(empl_5);

        ProjectDAO projectDAO = new ProjectDAO();
        projectDAO.add(project1);
        projectDAO.add(project2);
        projectDAO.add(project3);

        //testing project DAO

        System.out.println(projectDAO.projectsByCustomer(customer2));
        System.out.println(projectDAO.projectsByEmployee(empl_1));

        //testing employees DAO

        System.out.println("test employeesByProject: " + employeeDAO.employeesByProject("CRM"));
        System.out.println("test employeesByDepartmentWithoutProject: " + employeeDAO.employeesByDepartmentWithoutProject(DepartmentType.IT));
        System.out.println("test employeesWithoutProject: " + employeeDAO.employeesWithoutProject());
        System.out.println("test employeesByTeamLead: " + employeeDAO.employeesByTeamLead(empl_3));
        System.out.println("test employeesByProjectEmployee: " + employeeDAO.employeesByProjectEmployee(empl_3));
        System.out.println("test employeesByCustomer: " + employeeDAO.employeesByCustomerProjects(customer1));

    }
}
