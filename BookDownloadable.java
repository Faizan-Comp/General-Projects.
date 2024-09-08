package system.book;

import system.user.User;

/**
 * Interface representing the ability to download a book.
 */
public interface BookDownloadable {

    /**
     * Determines if the book can be downloaded by the given user.
     *
     * @param user The user attempting to download the book.
     * @return True if the book can be downloaded by the user, otherwise false.
     */
    public boolean download(User user);
}
