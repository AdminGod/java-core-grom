package lessons.lesson30.task1;

import java.util.Date;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class UkrainianBankSystem implements BankSystem {

    private Set<Transaction> transactions = new TreeSet<>();

    @Override
    public void withdraw(User user, int amount) {
        if(!checkWithdraw(user, amount)){
            return;
        }
        user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommission(amount));

        createAndSavetransaction(new Date(),  TransactionType.WITHDRAWAL, amount, "sdfghsdfhgh");
    }

    @Override
    public void fund(User user, int amount) {
        if(checkFunding(user, amount)){
            user.setBalance(user.getBalance() + amount);

            createAndSavetransaction(new Date(),  TransactionType.FUNDING, amount, "sdfghsdfhgh");
        }
    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {
        Currency fromUserCurency = fromUser.getBank().getCurrency();
        Currency toUserCurency = toUser.getBank().getCurrency();
        if(checkWithdraw(fromUser, amount) && checkFunding(toUser, amount) && fromUserCurency == toUserCurency){
            withdraw(fromUser, amount);
            fund(toUser, amount);
        }
    }

    @Override
    public void paySalary(User user) {
       fund(user, user.getSalary());
        createAndSavetransaction(new Date(),  TransactionType.SALARY_INCOME, user.getSalary(), "salary pay");
    }

    private boolean checkFunding(User user, int amount){
        return amount <= user.getBank().getLimitOfFunding();
    }

    private boolean checkWithdraw(User user, int amount){
        return checkWithdrawLimits(user, amount, user.getBank().getLimitOfWithdrawal()) && checkWithdrawLimits(user, amount, user.getBalance());
    }

    private boolean checkWithdrawLimits(User user, int amount, double limit){
        if((amount + (user.getBank().getCommission(amount))*amount) > limit){
            printWithdrawalErrorMsg(user, amount);
            return false;
        }
        return true;
    }

    private void printWithdrawalErrorMsg (User user, int amount){
        System.err.println("Can't withdraw money " + amount + " from user " + user.toString());
    }

    private Transaction createAndSavetransaction (Date dateCreated, TransactionType type, int amount, String desc){
        Transaction tr = new Transaction(new Random().nextInt(), dateCreated, null, type, amount, desc);
        transactions.add(tr);
        return tr;
    }

    public Set<Transaction> getTransactions (){
        return transactions;
    }
}
