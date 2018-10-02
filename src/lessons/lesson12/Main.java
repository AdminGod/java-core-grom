package lessons.lesson12;

public class Main {
    public static void main(String[] args) {
        Bank usBank = new USBank(1222, "Sweden", Currency.EUR, 100, 1400, 4, 444343434);

        User user1 = new User (1001, "Denis", 10000, 40, "GMD", 1500, usBank);
        User user2 = new User (1002, "Andrey", 10000, 40, "GMD", 1500, usBank);

        BankSystem bankSystem = new UkrainianBankSystem();

        //bankSystem.withdraw(user1, 150);
        System.out.println(user1.getBalance());
        //Sys.out.println("**************************");
        bankSystem.transferMoney(user2, user1, 100);
        //bankSystem.fund(user1, 150);
        System.out.println(user1.getName() + " balance: " + user1.getBalance());
        System.out.println(user2.getName() + " balance: " + user2.getBalance());
        String s = "";
        int a =4;
        int b = 2;
        if(b+ a > a){
            System.out.println("test");
        }
    }
}
