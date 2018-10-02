package lessons.lesson10.abstractBigExample;

public abstract class Employee {

    private String name;
    private int age;
    private int yearsOfExperience;

    private String curPosition;

    private int salaryPerMonth;
    private BankAccount bankAccount;
    private Company[] companiesWorked;
    private String[] positionsWorked;

    public Employee(String name, int age, int yearsOfExperience, String curPosition, int salaryPerMonth, BankAccount bankAccount, Company[] companiesWorked, String[] positionsWorked) {
        this.name = name;
        this.age = age;
        this.yearsOfExperience = yearsOfExperience;
        this.curPosition = curPosition;
        this.salaryPerMonth = salaryPerMonth;
        this.bankAccount = bankAccount;
        this.companiesWorked = companiesWorked;
        this.positionsWorked = positionsWorked;
    }

    abstract void paySalery();

    public void changePosition(String newPosition){
        //save current position to history
        //change position

        //changePosition(newPosition);
        if(newPosition != null) {
            curPosition = newPosition;
        }
        if(newPosition != null) {
            savePositionToHistory();
        }
    }

    public void savePositionToHistory(){
        int index = 0;
        if (positionsWorked == null){
            return;
        }
        for(String position : positionsWorked){
            if(position == null){
                positionsWorked[index] = curPosition;
                break;
            }
            index++;
        }
    }

    int getBalance(){
        if(bankAccount != null) {
            return bankAccount.getBalance();
        }
        return 0;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public int getSalaryPerMonth() {
        return salaryPerMonth;
    }

    public String getName() {
        return name;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getCurPosition() {
        return curPosition;
    }

    public int getAge() {
        return age;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public Company[] getCompaniesWorked() {
        return companiesWorked;
    }

    public String[] getPositionsWorked() {
        return positionsWorked;
    }
}
