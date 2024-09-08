package system.book;

import system.exception.BookException;
import system.util.SystemUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Manages a list of books, including loading from a CSV file, searching, and displaying book information.
 */
public class BookList {
    private final ArrayList<Book> bestsellers = new ArrayList<Book>();
    private String[] title;
    private final String path = "src/system/book/";

    private final BookGenreSet bookGenreSet = new BookGenreSet();
    private final BookLanguageSet bookLanguageSet = new BookLanguageSet();

    /**
     * Constructs a new BookList with empty lists for books, genres, and languages.
     */
    public BookList() {}

    /**
     * Loads a list of books from a CSV file and updates genre and language sets.
     *
     * @param csvFile The name of the CSV file containing book data.
     */
    public void loadBookList(String csvFile) {
        BufferedReader readFile;
        try {
            readFile = new BufferedReader(new FileReader(path + csvFile));
            String line;
            int index = 0;
            title = SystemUtil.lineReader(readFile.readLine());
            while ((line = readFile.readLine()) != null) {
                ArrayList<String> valueList = new ArrayList<>();

                valueList.add(String.valueOf(index));
                Arrays.stream(SystemUtil.lineReader(line), 0, 6).forEach(valueList::add);
                Book book = Book.createBook(valueList.toArray(new String[0]));

                bookGenreSet.addGenre(book.getGenre());
                bookLanguageSet.addLanguage(book.getLanguage());
                bestsellers.add(book);
                index++;
            }
            readFile.close();
        } catch (Exception e) {
            new BookException("Does not exist the file");
        }
        System.out.println("Book list created successfully!");
    }

    /**
     * Returns a string representation of the book list, including genres and languages.
     *
     * @return A string listing all books, genres, and languages in the list.
     */
    @Override
    public String toString() {
        StringBuilder listBooks = new StringBuilder("BOOK LIST ............\n");
        try {
            if (bestsellers.isEmpty()) {
                throw new BookException("The book list is empty");
            }
            bestsellers.forEach(book -> listBooks.append(book).append("\n"));
            listBooks.append("LANGUAGE LIST ............\n");
            listBooks.append(bookLanguageSet).append("\n");
            listBooks.append("GENRE LIST ...............\n");
            listBooks.append(bookGenreSet).append("\n");
            listBooks.append("............................");
        } catch (BookException ignored) { }
        return listBooks.toString();
    }

    /**
     * Finds a book by its index.
     *
     * @param index The index of the book to be found.
     * @return The book at the specified index, or null if the index is out of bounds.
     */
    public Book findBookByIndex(int index) {
        try {
            return bestsellers.get(index);
        } catch (Exception e) {
            new BookException("Book does not exist in this index");
        }
        return null;
    }

    /**
     * Searches for books in the list that contain the specified word in their description.
     *
     * @param word The word to search for in the book descriptions.
     * @return A list of books containing the specified word.
     */
    public ArrayList<Book> searchInBookList(String word) {
        if (word.isBlank()) {
            new BookException("The data is empty");
        }
        ArrayList<Book> subList = new ArrayList<>();
        bestsellers.forEach(book -> {
            if (word.isBlank() || book.toString().contains(word)) {
                subList.add(book);
            }
        });
        return subList;
    }
}
