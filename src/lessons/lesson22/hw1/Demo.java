package lessons.lesson22.hw1;

import lessons.lesson20.task2.exception.BadRequestException;
import lessons.lesson20.task2.exception.InternalServerException;

import java.util.Date;

public class Demo {
    public static void main(String[] args) throws BadRequestException, InternalServerException {

        Transaction tr1 = new Transaction(1, "Kiev", 40, "test1", TransactionType.OUTCOME, new Date());
        Transaction tr2 = new Transaction(1, "Odessa", 30, "test1", TransactionType.INCOME, new Date());
        Transaction tr3 = new Transaction(1, "Odessa", 100, "test1", TransactionType.INCOME, new Date());

        Transaction res1 = Controller.save(tr1);
        Transaction res2 = Controller.save(tr3);

        System.out.println(res1.getId() + res1.getCity());
        if (res2 != null) {
            System.out.println(res2.getId() + res2.getCity());
        }


    }
}
