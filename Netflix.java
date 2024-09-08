package CST8132Lab05;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Netflix {
    List<User> users;
    List<Movie> movies;
    HashSet<String> genreSet;

    public static void main(String[] args) {

        Netflix n = new Netflix();

        Movie movie1 = new Movie("Inception", "Sci-Fi", 148);
        Movie movie2 = new Movie("The Matrix", "Sci-Fi", 136);
        Movie movie3 = new Movie("Interstellar", "Sci-Fi", 169);

        n.addMovie(movie1);
        n.addMovie(movie2);
        n.addMovie(movie3);
        Plan trialPlan = new Plan(false, Plan.plan.trial);
        Plan vipPlan = new Plan(true, Plan.plan.vip);
        Plan standardPlan = new Plan(true, Plan.plan.standard);

        User u1 = new User("Alice", "alice@example.com", trialPlan);
        User u2 = new User("Bob", "bob@example.com", vipPlan);

        n.addUser(u1);
        n.addUser(u2);

        u1.addToWatchlist(movie1);
        u1.addToWatchlist(movie2);
        u2.addToWatchlist(movie3);

        System.out.println("=================================");
        System.out.println("===== [CST8132Lab05.Netflix simulation] ====");
        System.out.println("=================================");

        n.displayUsers();
        n.displayMovies();
        n.printGenreSet();
    }
    public Netflix() {
        this.users = new ArrayList<User>();
        this.movies = new ArrayList<Movie>();
        this.genreSet = new HashSet<>();
    }
    public void addUser(User user) {
        users.add(user);
    }
    public void addMovie(Movie movie) {
        movies.add(movie);
        genreSet.add(movie.getGenre());
    }

    public Movie createMovie(String title, String genre, int duration) {
        if(title.isEmpty() || genre.isEmpty() || duration <= 0) {
            return null;
        }
        Movie movie = new Movie(title, genre, duration);
        addMovie(movie);
        return movie;
    }

    public Plan createPlan(String type, boolean isActive) {
        if (type.equals("vip")) {
            return new Plan(true, Plan.plan.vip);
        }
        else if(type.equals("standard")) {
            return new Plan(true, Plan.plan.standard);
        }
        else if(type.equals("trial")) {
            return new Plan(true, Plan.plan.trial);
        }
        return null;
    }

    public User createUser(String name, String email, Plan plan) {
        if (name == null || name.trim().isEmpty() || email == null || email.trim().isEmpty() || plan == null) {
            return null;
        }
        User user = new User(name, email, plan);
        addUser(user);
        return user;
    }

    public void printGenreSet() {
        System.out.println("Genres: " + genreSet.toString());
    }

    public void displayUsers() {
        for(User u : users) {
            System.out.println(u);
        }

    }
    public void displayMovies() {
        for (User user : users) {
            System.out.println(user);
            System.out.println(user.getWatchlist());
        }
        System.out.println("=================================");
    }

    public String findUserByName(String userName) {
        for(User u : users) {
            if(u.getName().equals(userName)) {
                return userName;
            }
        }
        return "No user found.";
    }
}