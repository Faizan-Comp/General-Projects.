import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CSVReader {
    public static void main(String[] args) throws IOException {
            String path = scanInput();
            int choice = menuDisplay();
            ArrayList<Book> bestsellers = csvReader(path);
            userChoice(choice, bestsellers);
        }
        public static String scanInput () throws IOException {
            System.out.println("Enter the path of the CSV File: ");
            Scanner s = new Scanner(System.in);
            return s.nextLine();
        }
        public static int menuDisplay () {
            Scanner s = new Scanner(System.in);

            System.out.println("Choose an option from the following list: ");
            System.out.println("Show the list of books: [1]");
            System.out.println("Add a book to the list: [2]");
            System.out.println("Edit a book in the list: [3]");
            System.out.println("Delete a book in the list: [4]");
            System.out.println("Search a book in the list: [5]");
            System.out.println("Save the list: [6]");
            System.out.println("Exit the program: [7]");
            return s.nextInt();
        }

        public static void userChoice ( int choice, ArrayList<Book > bestsellers){
            Scanner s = new Scanner(System.in);

            switch (choice) {
                case 1:
                    printList(bestsellers);
                    break;
                case 2:
                    addBook(bestsellers, new Book());
                    break;

                case 3:
                    editBook(bestsellers, new Book());
                    break;

                case 4:
                    deleteBook(bestsellers, new Book());
                    break;

                case 5:
                    searchBook(bestsellers, new Book());
                    break;

                case 6:
                    saveList(bestsellers);
                    break;

                case 7:
                    break;
            }
        }

        public static ArrayList<Book> csvReader (String path) throws IOException {
            String line;
            ArrayList<Book> bestsellers = new ArrayList<>();
            try {
                BufferedReader br = new BufferedReader(new FileReader(path));
                br.readLine();
                while ((line = br.readLine()) != null) {
                    String[] data = lineReader(line);
                    String title = data[0];
                    String author = data[1];
                    String language = data[2];
                    int published = Integer.parseInt(data[3]);
                    double saleInMillions = Double.parseDouble(data[4]);
                    String genre = data[5];
                    Book book = new Book(title, author, language, published, saleInMillions, genre);
                    bestsellers.add(book);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bestsellers;
        }

        public static void printList (ArrayList < Book > bestsellers) {
            int index = 1;
            for (Book b : bestsellers) {
                System.out.println("[" + index + "] " + b.toString());
                index++;
            }
        }
        public static void addBook (ArrayList < Book > bestsellers, Book book){
            Scanner s = new Scanner(System.in);
            book = new Book();
            System.out.println("Book title:");
            book.setTitle(s.next());
            System.out.println("Author: ");
            book.setAuthor(s.next());
            System.out.println("Language: ");
            book.setLanguage(s.next());
            System.out.println("Year of Publication: ");
            book.setPublished(s.nextInt());
            System.out.println("Sale in millions: ");
            book.setSaleInMillions(s.nextDouble());
            System.out.println("Genre: ");
            book.setGenre(s.next());

            bestsellers.add(book);
        }
        public static void editBook (ArrayList < Book > bestsellers, Book book){
            Scanner s = new Scanner(System.in);
            System.out.println("Index of the book: ");
            int bookIndex = s.nextInt();
            bestsellers.remove(bookIndex);
            Book b = new Book();
            System.out.println("Book title:");
            b.setTitle(s.next());
            System.out.println("Author: ");
            b.setAuthor(s.next());
            System.out.println("Language: ");
            b.setLanguage(s.next());
            System.out.println("Year of Publication: ");
            b.setPublished(s.nextInt());
            System.out.println("Sale in millions: ");
            b.setSaleInMillions(s.nextDouble());
            System.out.println("Genre: ");
            b.setGenre(s.next());

            bestsellers.add(bookIndex - 1, b);
        }
        public static void deleteBook (ArrayList < Book > bestsellers, Book book){
            Scanner s = new Scanner(System.in);
            System.out.println("Index of the book: ");
            int bookIndex = s.nextInt();
            bestsellers.remove(bookIndex);
        }
        public static void searchBook (ArrayList < Book > bestsellers, Book book){
            Scanner s = new Scanner(System.in);
            System.out.println("Keyword: ");
            String keyword = s.next();
            ArrayList<Book> search = new ArrayList<>();
            for (Book searchBook : bestsellers) {
                if (searchBook.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                    search.add(searchBook);
                }
            }
            for (Book searchBook : search) {
                System.out.println(searchBook.toString());
            }
        }
        public static void saveList (ArrayList < Book > bestsellers) {
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter("output1.csv"));
                bw.write("Header: Title,Author,Language,Published,SaleInMillions,Genre\n");
                for (Book saveBook : bestsellers) {
                    String outputLine = String.join(",",
                            saveBook.getTitle(),
                            saveBook.getAuthor(),
                            saveBook.getLanguage(),
                            String.valueOf(saveBook.getPublished()),
                            String.valueOf(saveBook.getSaleInMillions()),
                            saveBook.getGenre());
                    bw.write(outputLine);
                    bw.newLine();
                }
                bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public static String[] lineReader (String line){
            String[] str = new String[6];
            int index = 0;
            final char chComma = ',';
            final char chQuotes = '"';
            int start = 0;
            int end = line.indexOf(chComma);
            String value;
            while (start < end) {
                if (line.charAt(start) == chQuotes) {
                    start++;
                    end = line.indexOf(chQuotes, start + 1);
                }
                value = line.substring(start, end);
                value = value.trim();
                str[index++] = value;
                if (line.charAt(end) == chQuotes)
                    start = end + 2;
                else
                    start = end + 1;
                end = line.indexOf(chComma, start + 1);
            }
            if (start < line.length()) {
                value = line.substring(start);
                str[index++] = value;
            }
            return str;
        }
}