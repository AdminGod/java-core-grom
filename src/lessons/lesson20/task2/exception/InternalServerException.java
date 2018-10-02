package lessons.lesson20.task2.exception;
/**
 * throw this exception when happened inner error in working of server
 *
 * in our example we will throw this exception when we wib't have enough space for transaction (array is full)
 */
public class InternalServerException extends Exception {

    public InternalServerException(String message) {
        super(message);
    }
}
