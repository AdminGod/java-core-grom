package lessons.lesson10.abstractBigExample;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        Company [] companies = new Company [5];
        String [] positions = new String[2];
        BankAccount bankAccount = new BankAccount(null, 0);
        DeveloperEmployee developerEmployee = new DeveloperEmployee("devEmpl", 25, 2, "midle", 1000, null, companies, positions);

        developerEmployee.paySalery();//oay salary to a user with null bank account
        System.out.println(developerEmployee.getBalance());
        bankAccount.setEmployee(developerEmployee);
        developerEmployee.setBankAccount(bankAccount);


        developerEmployee.paySalery();//pay to account who has an user
        System.out.println(developerEmployee.getBalance());
        developerEmployee.changePosition("junior");//cahnge position
        System.out.println(developerEmployee.getCurPosition());
        developerEmployee.changePosition(null);//change position with null
        System.out.println(developerEmployee.getCurPosition());

        //testing Employee.savePositionToHistory
        developerEmployee.savePositionToHistory();//save positions
        System.out.println(Arrays.deepToString(developerEmployee.getPositionsWorked()));
        DeveloperEmployee developerEmployee1 = new DeveloperEmployee("devEmpl", 25, 2, "midle", 1000, null, companies, null);
        developerEmployee1.savePositionToHistory();//save positions to null history
        System.out.println(Arrays.deepToString(developerEmployee.getPositionsWorked()));

        developerEmployee.savePositionToHistory();//save position to full array
        System.out.println(Arrays.deepToString(developerEmployee.getPositionsWorked()));


        EmployeeController employeeController = new EmployeeController();
        for(Employee empl : employeeController.getEmployees()){
            System.out.println(empl.getBalance());
        }

        employeeController.paySalariesToEmployees();//pay to null
        for(Employee empl : employeeController.getEmployees()){
            System.out.println(empl.getBalance());
        }

        DeveloperEmployee developerEmployee22 = new DeveloperEmployee("devEmpl", 25, 2, "midle", 1000, null, companies, positions);
        BankAccount bankAccount11 = new BankAccount(null, 0);
        bankAccount11.setEmployee(developerEmployee22);
        developerEmployee22.setBankAccount(bankAccount11);
        Employee[] employers = new Employee[5];
        employers[0] = developerEmployee22;

        EmployeeController eController = new EmployeeController(employers);

        for(Employee empl : eController.getEmployees()){
            System.out.println(empl.getBalance());
        }

        eController.paySalariesToEmployees();//pay to employers;

        for(Employee empl : eController.getEmployees()){
            System.out.println(empl.getBalance());
        }

        eController.paySalariesToEmployees();//pay to employers in array where is null;

        for(Employee empl : eController.getEmployees()){
            System.out.println(empl.getBalance());
        }


        String end = "";


    }
}
