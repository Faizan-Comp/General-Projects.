public class AgeLessThanZeroException extends IllegalArgumentException{

    public AgeLessThanZeroException(String message) {
        super(message);

    }

    public AgeLessThanZeroException() {

    }

    public AgeLessThanZeroException(String message, Throwable cause) {
        super(message,cause);
    }

    public AgeLessThanZeroException(Throwable cause) {
        super(cause);
    }
}
