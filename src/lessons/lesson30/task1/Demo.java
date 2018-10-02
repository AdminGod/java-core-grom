package lessons.lesson30.task1;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        Bank usBank = new USBank(1222, "Sweden", Currency.EUR, 100, 1400, 4, 444343434);

        User user1 = new User(1001, "Denis", 10000, 40, "GMD", 1500, usBank);
        User user2 = new User(1002, "Andrey", 10000, 40, "GMD", 1500, usBank);

        BankSystem bankSystem = new UkrainianBankSystem();
        bankSystem.withdraw(user1, 150);

        Thread.sleep(2000);

        bankSystem.withdraw(user1, 10);

        System.out.println(((UkrainianBankSystem) bankSystem).getTransactions());
    }
}
