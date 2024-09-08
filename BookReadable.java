package system.book;

import system.user.User;

/**
 * Interface representing the ability to read a book.
 */
public interface BookReadable {

    /**
     * Determines if the book can be read by the given user.
     *
     * @param user The user attempting to read the book.
     * @return True if the book can be read by the user, otherwise false.
     */
    public boolean read(User user);
}
