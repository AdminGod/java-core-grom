package lessons.lesson12;

public class USBank extends Bank {

    public USBank(long id, String bankCountry, Currency currency, int numberOfEmployees, double avrSalaryEmployee, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployees, avrSalaryEmployee, rating, totalCapital);
    }

    @Override
    public int getLimitOfWithdrawal() {
        if(getCurrency() == Currency.USD){
            return 1000;
        }
        return 1200;
    }

    @Override
    public int getLimitOfFunding() {
        if(getCurrency() == Currency.EUR){
            return 10000;
        }
        return Integer.MAX_VALUE;
    }

    @Override
    public double getMonthlyRate() {
        if(getCurrency() == Currency.EUR){
            return 0.02;
        }
        return 0.01;
    }

    @Override
    public double getCommission (int amount) {
        if(getCurrency() == Currency.USD){
            if(amount <= 1000){
                return 0.05;
            }
            return 0.07;
        }else{
            if(amount <= 1000){
                return 0.06;
            }
            return 0.08;
        }
    }
}
