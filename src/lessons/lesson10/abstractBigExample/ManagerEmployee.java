package lessons.lesson10.abstractBigExample;

public class ManagerEmployee extends Employee {

    public ManagerEmployee(String name, int age, int yearsOfExperience, String curPosition, int salaryPerMonth, BankAccount bankAccount, Company[] companiesWorked, String[] positionsWorked) {
        super(name, age, yearsOfExperience, curPosition, salaryPerMonth, bankAccount, companiesWorked, positionsWorked);
    }

    @Override
    void paySalery() {
        if(getBankAccount() == null){
            return;
        }
        int newBalance = getBankAccount().getBalance() + getSalaryPerMonth();
        newBalance += newBalance*0.25;
        getBankAccount().setBalance(newBalance);

    }
}
