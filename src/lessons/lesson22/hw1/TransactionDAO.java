package lessons.lesson22.hw1;

import lessons.lesson20.task2.exception.BadRequestException;
import lessons.lesson20.task2.exception.InternalServerException;
import lessons.lesson20.task2.exception.LimitExceeded;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TransactionDAO {

    private static Transaction[] transactions = new Transaction[10];

    public static Transaction save (Transaction transaction) throws BadRequestException, InternalServerException {

        validate(transaction);

        for(int i = 0; i<transactions.length; i++){
            if(transactions[i] == null){
                transactions[i] = transaction;
                return transactions[i];
            }
        }
        throw new InternalServerException("Transaction is denied. There is not enough free space in storage for transaction: " + transaction.getId());
    }

    public static Transaction[] transactionList(){
        int counter = 0;
        for(Transaction tr : transactions){
            if(tr != null){
                counter++;
            }
        }
        Transaction[] result = new Transaction[counter];
        int position = 0;
        for(Transaction tr : transactions){
            if(tr != null){
                result[position] = tr;
                position++;
            }
        }
        return result;
    }

    public static Transaction[] transactionList(String city){
        int counter = 0;
        for(Transaction tr : transactions){
            if(tr != null && tr.getCity() == city){
                counter++;
            }
        }
        Transaction[] result = new Transaction[counter];
        int position = 0;
        for(Transaction tr : transactions){
            if(tr != null && tr.getCity() == city){
                result[position] = tr;
                position++;
            }
        }
        return result;
    }

    public static Transaction[] transactionList(int amount){
        int counter = 0;
        for(Transaction tr : transactions){
            if(tr != null && tr.getAmount() == amount){
                counter++;
            }
        }
        Transaction[] result = new Transaction[counter];
        int position = 0;
        for(Transaction tr : transactions){
            if(tr != null && tr.getAmount() == amount){
                result[position] = tr;
                position++;
            }
        }
        return result;
    }

    private static void validate(Transaction transaction) throws BadRequestException {
        //sum of transaction is more than total limit
        if(transaction.getAmount() > Utils.getLimitSimpleTransactionAmount()){
            throw new LimitExceeded("Transaction limit is exceeded. Transaction " + transaction.getId() + " can't be saved");
        }
        //sum of transaction is more than limit per day
        int sum = 0;
        for(Transaction tr : getTransactionsPerDay(transaction.getDateCreated())){
            if(tr != null) {
                sum += tr.getAmount();
            }
        }

        if(sum + transaction.getAmount() > Utils.getLimitTransactionsPerDayAmount()){
            throw new LimitExceeded("Transaction limit sum is exceeded. Transaction " + transaction.getId() + " can't be saved");
        }

        //amount of transactions per day is more than limited
        int amount = getTransactionsPerDay(transaction.getDateCreated()).length;
        if((amount + 1) > Utils.getLimitTransactionsPerDayCount()){
            throw new LimitExceeded("Transaction limit amount is exceeded " + transaction.getId() + ". Can't be saved");
        }
        //validate is transaction city is allowed or not?  transactions city is not accepted >> BadRequestException
        validateTransactionCity(transaction.getCity(), transaction.getId());
        //validate is there any free space for new transaction in our storage  not enough space in array >> internalServerException;
        validateDublicates(transaction);
    }

    /**
     * Additional methods
     */

    private static Transaction[] getTransactionsPerDay(Date dateOfCurTransaction){
        int count = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YY");
        for (Transaction tr : transactions){
            if(tr != null && sdf.format(dateOfCurTransaction).equals(sdf.format(tr.getDateCreated()))){
                    count++;
            }
        }
        Transaction[] result = new Transaction[count];
        int position = 0;
        for (Transaction tr : transactions){
            if(tr != null && sdf.format(dateOfCurTransaction).equals(sdf.format(tr.getDateCreated()))){
                transactions[position] = tr;
                position++;
            }
        }
        return result;
    }

    private static void validateTransactionCity(String transactionCity, long id) throws BadRequestException {
        for (String city : Utils.getCities()){
            if(city == transactionCity){
                return;
            }
        }
        throw new BadRequestException("Transaction is denied. Not acceptable city for transaction: " + id);
    }

    private static void validateDublicates(Transaction transaction) throws BadRequestException {
        for(Transaction tr : transactions){
            if(tr != null && tr.equals(transaction)){
                throw new BadRequestException("Transaction is denied. Transaction: " + transaction.getId() + " already exist");
            }
        }
    }
}
