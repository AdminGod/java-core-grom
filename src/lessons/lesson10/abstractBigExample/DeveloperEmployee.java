package lessons.lesson10.abstractBigExample;

public class DeveloperEmployee extends Employee{
    private String[] frameworks = new String[10];

    public DeveloperEmployee(String name, int age, int yearsOfExperience, String curPosition, int salaryPerMonth, BankAccount bankAccount, Company[] companiesWorked, String[] positionsWorked) {
        super(name, age, yearsOfExperience, curPosition, salaryPerMonth, bankAccount, companiesWorked, positionsWorked);
    }

    @Override
    void paySalery() {
        if(getBankAccount()== null){
            return;
        }
        int newBalance = getBankAccount().getBalance() + getSalaryPerMonth() + 1000;
        getBankAccount().setBalance(newBalance);
    }



}
