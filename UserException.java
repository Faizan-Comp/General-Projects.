package system.exception;

import java.io.Serial;
import java.io.Serializable;

/**
 * Represents an exception related to user operations.
 * Extends Throwable to allow custom exception handling.
 */
public class UserException extends Throwable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Private constructor to prevent direct instantiation without an error message.
     */
    private UserException() { }

    /**
     * Constructs a new UserException with a specified error message.
     *
     * @param errorMessage The detail message for the exception.
     */
    public UserException(String errorMessage) {
        System.err.println("UserException: " + errorMessage);
    }
}
