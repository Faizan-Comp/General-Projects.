package system.exception;

import java.io.Serial;
import java.io.Serializable;

/**
 * Represents an exception related to book operations.
 * Extends Throwable to allow custom exception handling.
 */
public class BookException extends Throwable {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Private constructor to prevent direct instantiation without an error message.
     */
    private BookException() { }

    /**
     * Constructs a new BookException with a specified error message.
     *
     * @param errorMessage The detail message for the exception.
     */
    public BookException(String errorMessage) {
        System.err.println("BookException: " + errorMessage);
    }
}
