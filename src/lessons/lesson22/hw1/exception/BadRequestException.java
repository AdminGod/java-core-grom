package lessons.lesson22.hw1.exception;
/**
 * throw this exception when transaction doesn't pass a validations rules, for example wrong city
 */
public class BadRequestException extends Exception {

    public BadRequestException(String message) {
        super(message);
    }
}
