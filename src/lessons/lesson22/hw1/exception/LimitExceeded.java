package lessons.lesson22.hw1.exception;

/**
 * throw this exception when transaction exceed an allowed limit
 */
public class LimitExceeded extends BadRequestException {

    public LimitExceeded(String message) {
        super(message);
    }
}
