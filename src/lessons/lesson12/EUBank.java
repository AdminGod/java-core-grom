package lessons.lesson12;

public class EUBank extends Bank{

    public EUBank(long id, String bankCountry, Currency currency, int numberOfEmployees, double avrSalaryEmployee, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployees, avrSalaryEmployee, rating, totalCapital);
    }

    @Override
    public int getLimitOfWithdrawal() {
        if(getCurrency() == Currency.USD){
            return 2000;
        }
        return 2200;
    }

    @Override
    public int getLimitOfFunding() {
        if(getCurrency() == Currency.EUR){
            return 20000;
        }
        return 10000;
    }

    @Override
    public double getMonthlyRate() {
        if(getCurrency() == Currency.EUR){
            return 0.01;
        }
        return 0.00;
    }

    @Override
    public double getCommission(int amount) {
        if(getCurrency() == Currency.USD){
            if(amount <= 1000){
                return 0.05;
            }
            return 0.07;
        }else{
            if(amount <= 1000) {
                return 0.02;
            }
            return 0.04;
        }
    }
}
