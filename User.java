package system.user;

import system.book.Book;
import system.util.SystemUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Represents a user in the system with email, password, and a list of books.
 */
public class User {
    private String email;
    private String password;
    private final List<Book> bookList = new ArrayList<>();
    private UserPlan plan;

    private final String path = "src/system/user/";

    /**
     * Private constructor to create a new user.
     *
     * @param email    the user's email.
     * @param password the user's password.
     * @param userPlan the user's plan.
     */
    private User(String email, String password, UserPlan userPlan) {
        this.email = email;
        this.password = password;
        this.plan = userPlan;
    }

    /**
     * Creates a new user with the given data.
     *
     * @param userData the user data as a variable-length argument list.
     * @return the created user, or null if any data is invalid.
     */
    public static User createUser(String... userData) {
        if (Arrays.stream(userData).anyMatch(data -> !SystemUtil.isValid(data))) {
            return null;
        }

        String email = userData[0];
        String password = userData[1];

        if (userData.length < 3) {
            return new User(email, password, null);
        }

        UserPlan userPlan = UserPlan.createPlan(Arrays.stream(userData, 2, 4).toArray(String[]::new));
        return new User(email, password, userPlan);
    }

    /**
     * Gets the user's email.
     *
     * @return the user's email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the user's password.
     *
     * @return the user's password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the user's plan.
     *
     * @return the user's plan.
     */
    public UserPlan getPlan() {
        return plan;
    }

    /**
     * Sets the user's email.
     *
     * @param email the new email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets the user's password.
     *
     * @param password the new password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets the user's plan.
     *
     * @param plan the new plan.
     */
    public void setPlan(UserPlan plan) {
        this.plan = plan;
    }

    /**
     * Adds a book to the user's book list.
     *
     * @param book the book to add.
     */
    public void addToBooklist(Book book) {
        bookList.add(book);
    }

    /**
     * Displays the user's book list.
     */
    public void displayBookList() {
        bookList.forEach(System.out::println);
    }

    /**
     * Finds a book by its index in the user's book list.
     *
     * @param index the index of the book.
     * @return the book with the given index, or null if not found.
     */
    public Book findBookByIndex(int index) {
        Optional<Book> result = bookList.stream().filter(book -> book.getIndex() == index).findFirst();
        return result.orElse(null);
    }

    /**
     * Loads the user's book list from a file.
     */
    public void loadBookList() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(path + this.getEmail() + ".csv"));
            String line;
            while ((line = reader.readLine()) != null) {
                Book book = Book.createBook(SystemUtil.lineReader(line));
                bookList.add(book);
            }
        } catch (Exception ignored) {
        }
    }

    /**
     * Saves the user's book list to a file.
     */
    public void saveBookList() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(path + this.getEmail() + ".csv"));
            StringBuilder builder = new StringBuilder();
            String comma = ",";
            bookList.forEach(book -> {
                builder.append(book.getIndex() + comma);
                builder.append(SystemUtil.addQuotesIfNeeded(book.getName()) + comma);
                builder.append(book.getAuthor() + comma);
                builder.append(book.getLanguage() + comma);
                builder.append(book.getPublished() + comma);
                builder.append(book.getMillionSales() + comma);
                builder.append(SystemUtil.addQuotesIfNeeded(book.getGenre()) + "\n");
            });
            writer.write(builder.toString());
            writer.close();
        } catch (Exception ignored) {
        }
    }

    /**
     * Returns a string representation of the user.
     *
     * @return the string representation of the user.
     */
    @Override
    public String toString() {
        return String.format("Email: %s, %s", email, plan);
    }

    /**
     * Gets the size of the user's book list.
     *
     * @return the size of the book list.
     */
    public int getBookListSize() {
        return bookList.size();
    }
}
