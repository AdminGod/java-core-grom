package lessons.lesson10.abstractBigExample;

public class BankAccount {

    private Employee employee;
    private int balance;

    public BankAccount(Employee employee, int balance) {
        this.employee = employee;
        this.balance = balance;
    }

    public int getBalance(){
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
