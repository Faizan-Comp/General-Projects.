package system;

import system.book.Book;
import system.book.BookList;
import system.exception.BookException;
import system.exception.UserException;
import system.user.User;
import system.user.UserList;

import java.util.Scanner;

/**
 * SystemManager class manages the main operations of the library system.
 */
public class SystemManager {

    // Menu options
    private final int OPTION1 = 1;
    private final int OPTION2 = 2;
    private final int OPTION3 = 3;
    private final int OPTION4 = 4;
    private final int OPTION5 = 5;
    private final int OPTION6 = 6;
    private final int OPTION7 = 7;
    private final int OPTION8 = 8;
    private final int OPTION9 = 9;
    private final int OPTION10 = 10;
    private final int OPTION11 = 11;
    private final int OPTION12 = 12;
    private final int OPTION13 = 13;
    private final int OPTION14 = 14;
    private final int OPTION15 = 15;
    private final int OPTION16 = 16;

    private final Scanner scanner = new Scanner(System.in);
    private final BookList bookList = new BookList();
    private final UserList userList = new UserList();

    /**
     * Manages the main system operations.
     *
     * @throws UserException if there is an error related to user operations.
     * @throws BookException if there is an error related to book operations.
     */
    public void manageSystem() throws UserException, BookException {
        boolean run = true;

        while (run) {
            printMenuSystem();
            int userChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userChoice) {
                case OPTION1:
                    createBookList();
                    break;
                case OPTION2:
                    showBookList();
                    break;
                case OPTION3:
                    searchInBookList();
                    break;
                case OPTION4:
                    createUser();
                    break;
                case OPTION5:
                    showUserList();
                    break;
                case OPTION6:
                    saveUserList();
                    break;
                case OPTION7:
                    loadUserList();
                    break;
                case OPTION8:
                    manageUser(loginUser());
                    break;
                case OPTION9:
                    run = false;
                    exit();
                    break;
                default:
                    throw new BookException("Invalid Choice");
            }
        }
    }

    /**
     * Manages the user operations after login.
     *
     * @param user The logged-in user.
     * @throws BookException if there is an error related to book operations.
     * @throws UserException if there is an error related to user operations.
     */
    public void manageUser(User user) throws BookException, UserException {
        boolean run = true;
        user.loadBookList();

        while (run) {
            printMenuUser();
            int userChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userChoice) {
                case OPTION10:
                    search();
                    break;
                case OPTION11:
                    addBookInMyList(user);
                    break;
                case OPTION12:
                    showMyBookList(user);
                    break;
                case OPTION13:
                    readBook(user);
                    break;
                case OPTION14:
                    downloadBook(user);
                    break;
                case OPTION15:
                    changePassword(user);
                    break;
                case OPTION16:
                    run = false;
                    user.saveBookList();
                    logoff();
                    break;
                default:
                    throw new UserException("Invalid Choice");
            }
        }
    }

    // System operations

    /**
     * Creates a book list from a specified file.
     */
    public void createBookList() {
        System.out.print("Name of file to create booklist: ");
        String fileName = scanner.next();
        bookList.loadBookList(fileName);
    }

    /**
     * Displays the book list.
     *
     * @throws BookException if there is an error displaying the book list.
     */
    public void showBookList() throws BookException {
        System.out.println(bookList);
    }

    /**
     * Searches for a book in the book list by a keyword.
     *
     * @throws BookException if there is an error during the search.
     */
    public void searchInBookList() throws BookException {
        System.out.print("Enter one string for search in the list: ");
        String searchString = scanner.nextLine();
        System.out.println("Results from search...");
        bookList.searchInBookList(searchString).forEach(System.out::println);
    }

    /**
     * Creates a new user and adds them to the user list.
     */
    public void createUser() {
        System.out.println("Enter the User data:");
        System.out.print("- Email: ");
        String email = scanner.next();
        System.out.print("- Password: ");
        String password = scanner.next();
        System.out.print("- Plan type: [1]: trial, [2]: standard, [3]: vip: ");
        String planType = scanner.next();
        System.out.print("- Activation: [1]: activated, [2]: deactivated: ");
        String activation = scanner.next();

        if (userList.getUsers().stream().anyMatch(user -> user.getEmail().equals(email))) {
            new UserException("User already exists");
        } else {
            userList.addUser(User.createUser(email, password, planType, activation));
            System.out.println("User successfully created!");
        }
    }

    /**
     * Displays the user list.
     */
    public void showUserList() {
        System.out.println(userList);
    }

    /**
     * Saves the user list to a specified file.
     */
    public void saveUserList() {
        System.out.print("Enter the user file name: ");
        userList.saveUserList(scanner.next());
    }

    /**
     * Loads the user list from a specified file.
     */
    public void loadUserList() {
        System.out.print("Enter the user file name: ");
        userList.loadUserList(scanner.next());
    }

    /**
     * Logs in a user by their email and password.
     *
     * @return The logged-in user.
     */
    public User loginUser() {
        System.out.print("Enter the user name: ");
        String userName = scanner.next();
        System.out.print("Enter the password: ");
        String password = scanner.next();

        User loginedUser = userList.login(userName, password);
        if (loginedUser != null) {
            System.out.printf("User %s logged!\n", loginedUser.getEmail());
        } else {
            System.out.println("User logged fail!\n");
        }
        return loginedUser;
    }

    /**
     * Exits the system.
     */
    public void exit() {
        printEnd();
    }

    // User operations

    /**
     * Searches for a book in the user's book list by a keyword.
     */
    public void search() {
        System.out.print("Enter one string for search in the list [Empty: all]: ");
        String keyWord = scanner.nextLine();
        System.out.println("Results from search...");
        bookList.searchInBookList(keyWord).forEach(System.out::println);
    }

    /**
     * Adds a book to the user's book list by index.
     *
     * @param user The user to whom the book will be added.
     */
    public void addBookInMyList(User user) {
        System.out.print("Enter the book index: ");
        int bookIndex = scanner.nextInt();
        user.addToBooklist(bookList.findBookByIndex(bookIndex));
    }

    /**
     * Displays the user's book list.
     *
     * @param user The user whose book list will be displayed.
     */
    public void showMyBookList(User user) {
        user.displayBookList();
    }

    /**
     * Allows the user to read a book from their book list by index.
     *
     * @param user The user who will read the book.
     */
    public void readBook(User user) {
        System.out.print("Enter the book index: ");
        int bookIndex = scanner.nextInt();
        Book book = user.findBookByIndex(bookIndex);
        if (book.read(user)) {
            System.out.printf("%s read!\n", book.getName());
        } else {
            System.out.println("You are not active!");
        }
    }

    /**
     * Allows the user to download a book from their book list by index.
     *
     * @param user The user who will download the book.
     */
    public void downloadBook(User user) {
        System.out.print("Enter the book index: ");
        int bookIndex = scanner.nextInt();
        Book book = user.findBookByIndex(bookIndex);
        if (book.download(user)) {
            System.out.printf("%s download!\n", book.getName());
        } else {
            System.out.printf("%s cannot be downloaded!\n", book.getName());
        }
    }

    /**
     * Changes the user's password.
     *
     * @param user The user whose password will be changed.
     * @throws UserException if there is an error changing the password.
     */
    public void changePassword(User user) throws UserException {
        System.out.print("Enter the new password: ");
        user.setPassword(scanner.next());
    }

    /**
     * Logs off the user.
     */
    public void logoff() {
        printLogOff();
    }

    /**
     * Prints the system menu.
     */
    public void printMenuSystem() {
        System.out.print("""
                ================================
                || Menu - Mini-System: OOP/A2 ||
                ================================
                1. Load Booklist
                2. Show Booklist
                3. Search in the list
                4. Create user
                5. Show users
                6. Save users
                7. Load users
                8. Login user
                9. Exit
                Choose an option:\s""");
    }

    /**
     * Prints the user menu.
     */
    public void printMenuUser() {
        System.out.print("""
                ================================
                || Menu - User .............. ||
                ================================
                10. Show all books
                11. Add book in my list
                12. Show my booklist
                13. Read book
                14. Download book
                15. Change password
                16. Logoff
                Choose an option:\s""");
    }

    /**
     * Prints the end message when the application ends.
     */
    public void printEnd() {
        System.out.println("""
                ================================
                ||    [Application Ended]     ||
                ================================""");
    }

    /**
     * Prints the logoff message when the user logs off.
     */
    public void printLogOff() {
        System.out.println("""
                ================================
                ||    [ User logoff ... ]     ||
                ================================""");
    }

    /**
     * Main method to run the SystemManager application.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        try {
            new SystemManager().manageSystem();
        } catch (UserException | BookException ignored) {
        }
    }
}
