public class Book {
    private String title;
    private String author;
    private String language;
    private int published;
    private double saleInMillions;
    private String genre;

    public Book(String title, String author, String language, int published, double saleInMillions, String genre) {
        this.title = title;
        this.author = author;
        this.language = language;
        this.published = published;
        this.saleInMillions = saleInMillions;
        this.genre = genre;
    }
    public Book() {

    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public void setPublished(int published) {
        this.published = published;
    }
    public void setSaleInMillions(double saleInMillions) {
        this.saleInMillions = saleInMillions;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getLanguage() {
        return language;
    }
    public int getPublished() {
        return published;
    }
    public double getSaleInMillions() {
        return saleInMillions;
    }
    public String getGenre() {
        return genre;
    }
    @Override
    public String toString() {
        String msg = "{ Title: " + title + ", Author: " + author + ", Language: " + language + ", Year of Publishing: " + published +
                ", Sale in millions: " + saleInMillions + ", Genre: " + genre + " }";
        return msg;
    }

}
