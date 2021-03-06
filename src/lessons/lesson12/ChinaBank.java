package lessons.lesson12;

public class ChinaBank extends Bank {

    public ChinaBank(long id, String bankCountry, Currency currency, int numberOfEmployees, double avrSalaryEmployee, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployees, avrSalaryEmployee, rating, totalCapital);
    }

    @Override
    public int getLimitOfWithdrawal() {
        if(getCurrency() == Currency.USD){
            return 100;
        }
        return 150;
    }

    @Override
    public int getLimitOfFunding() {
        if(getCurrency() == Currency.EUR){
            return 5000;
        }
        return 10000;
    }

    @Override
    public double getMonthlyRate() {
        if(getCurrency() == Currency.USD){
            return 0.01;
        }
        return 0.00;
    }

    @Override
    public double getCommission (int amount) {
        if(getCurrency() == Currency.USD){
            if(amount <= 1000){
                return 0.03;
            }
            return 0.05;
        }else{
            if(amount <= 1000) {
                return 0.10;
            }
            return 0.11;
        }
    }
}
