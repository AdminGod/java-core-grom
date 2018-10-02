package lessons.lesson12;

public class UkrainianBankSystem implements BankSystem {

    @Override
    public void withdraw(User user, int amount) {
        if(!checkWithdraw(user, amount)){
            return;
        }
        user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommission(amount));
    }

    @Override
    public void fund(User user, int amount) {
        if(checkFunding(user, amount)){
            user.setBalance(user.getBalance() + amount);
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
}
