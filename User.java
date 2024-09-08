package CST8132Lab05;

import java.util.ArrayList;

public class User {
    private String name;
    private String email;
    private Plan plan;
    private ArrayList<Movie> watchlist = new ArrayList<Movie>();

    public User(String name, String email, Plan plan) {
        this.name = name;
        this.email = email;
        this.plan = plan;
    }
    public String getName() {

        return name;
    }

    public String getEmail() {
        return email;
    }
    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public Plan getPlan() {
        return plan;
    }
    public ArrayList<Movie> getWatchlist() {
        return watchlist;
    }

    public void addToWatchlist(Movie movie) {
        watchlist.add(movie);
    }
    public void removeFromWatchlist(Movie movie) {
        watchlist.remove(movie);
    }

    @Override
    public String toString() {
        String str = "Users: " + "\n";
        str += "CST8132Lab05.User: " + name +  ", Email: " + email + "\n";
        str+= "\tCST8132Lab05.Plan: " + "IsActive: " + plan.getIsActive() + ", Type: " + plan;
        return str;
    }

    public int getWatchListSize() {
        return watchlist.size();
    }
}
