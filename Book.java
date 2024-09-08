package system.book;

import system.user.User;
import system.user.UserPlan;
import system.util.SystemUtil;

import java.util.Arrays;

/**
 * Represents a book with various attributes and provides methods for downloading and reading based on user permissions.
 * Implements the BookDownloadable and BookReadable interfaces.
 */
public class Book implements BookDownloadable, BookReadable {
    private int index;
    private String name;
    private String author;
    private String language;
    private int published;
    private float millionSales;
    private String genre;

    /**
     * Constructs a new Book with the specified attributes.
     *
     * @param index The index of the book.
     * @param name The name of the book.
     * @param author The author of the book.
     * @param language The language in which the book is written.
     * @param published The year the book was first published.
     * @param millionSales The approximate number of sales in millions.
     * @param genre The genre of the book.
     */
    private Book(int index, String name, String author, String language, int published, float millionSales, String genre) {
        setIndex(index);
        setName(name);
        setAuthor(author);
        setLanguage(language);
        setPublished(published);
        setMillionSales(millionSales);
        setGenre(genre);
    }

    // Getter methods

    /**
     * Returns the index of the book.
     *
     * @return The index of the book.
     */
    public int getIndex() {
        return index;
    }

    /**
     * Returns the name of the book.
     *
     * @return The name of the book.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the author of the book.
     *
     * @return The author of the book.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Returns the language in which the book is written.
     *
     * @return The language of the book.
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Returns the year the book was first published.
     *
     * @return The year of publication.
     */
    public int getPublished() {
        return published;
    }

    /**
     * Returns the approximate number of sales in millions.
     *
     * @return The sales in millions.
     */
    public float getMillionSales() {
        return millionSales;
    }

    /**
     * Returns the genre of the book.
     *
     * @return The genre of the book.
     */
    public String getGenre() {
        return genre;
    }

    // Setter methods

    /**
     * Sets the genre of the book.
     *
     * @param genre The new genre of the book.
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Sets the approximate number of sales in millions.
     *
     * @param millionSales The new sales in millions.
     */
    public void setMillionSales(float millionSales) {
        this.millionSales = millionSales;
    }

    /**
     * Sets the year the book was first published.
     *
     * @param published The new year of publication.
     */
    public void setPublished(int published) {
        this.published = published;
    }

    /**
     * Sets the language in which the book is written.
     *
     * @param language The new language of the book.
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Sets the author of the book.
     *
     * @param author The new author of the book.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Sets the name of the book.
     *
     * @param name The new name of the book.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the index of the book.
     *
     * @param index The new index of the book.
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * Returns a string representation of the book.
     *
     * @return A string describing the book's attributes.
     */
    @Override
    public String toString() {
        return String.format("Book [%d] {Book='%s', Author(s)=%s, Original language=%s, First published=%d, Approximate sales in millions=%.2f, Genre=%s}",
                getIndex(), getName(), getAuthor(), getLanguage(), getPublished(), getMillionSales(), getGenre());
    }

    /**
     * Creates a Book instance based on the provided book information.
     *
     * @param bookInfo An array of strings representing book information.
     * @return A Book instance if the data is valid, otherwise null.
     */
    public static Book createBook(String... bookInfo) {
        if (Arrays.stream(bookInfo, 0, 6).anyMatch(info -> !SystemUtil.isValid(info))) {
            return null;
        }

        int index = Integer.parseInt(bookInfo[0]);
        String name = bookInfo[1];
        String author = bookInfo[2];
        String language = bookInfo[3];
        int published = Integer.parseInt(bookInfo[4]);
        float millionSales = Float.parseFloat(bookInfo[5]);
        String genre = bookInfo[6] == null ? null : bookInfo[6];

        return new Book(index, name, author, language, published, millionSales, genre);
    }

    /**
     * Determines if the book can be downloaded by the given user.
     *
     * @param user The user attempting to download the book.
     * @return True if the user is active and is not on the trial plan, otherwise false.
     */
    @Override
    public boolean download(User user) {
        // user is active and is a VIP user, which enable true
        return user.getPlan().isActive() && user.getPlan().getType() != UserPlan.PlanType.trial;
    }

    /**
     * Determines if the book can be read by the given user.
     *
     * @param user The user attempting to read the book.
     * @return True if the user is active, otherwise false.
     */
    @Override
    public boolean read(User user) {
        // user is active, enable true
        return user.getPlan().isActive();
    }
}
