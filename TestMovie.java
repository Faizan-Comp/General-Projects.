package CST8132Lab05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CST8132Lab05.Movie;
import CST8132Lab05.Netflix;
import CST8132Lab05.Plan;
import CST8132Lab05.User;

class TestMovie {

    Plan trialPlan = new Plan(false, Plan.plan.trial);
    Plan vipPlan = new Plan(true, Plan.plan.vip);
    Plan standardPlan = new Plan(true, Plan.plan.standard);
    @Test
    void testMovie() {
        System.out.println("Testing movies...................");
        Netflix netflix = new Netflix();
        Movie movie1 = netflix.createMovie("invalid", "", 0);
        assertNull(movie1);
        System.out.println("Movie test1: invalid Movie denied");
        movie1 = netflix.createMovie("My Movie", "Drama", Integer.parseInt("100"));
        assertNotNull(movie1);
        System.out.println("Movie test2: valid Movie created");
        Movie movie2 = netflix.createMovie("New Movie", "Sci-Fiction", Integer.parseInt("120"));
        assertNotNull(movie2);
        System.out.println("Movie test3: another valid Movie created");
        Plan plan = netflix.createPlan("vip", true);
        assertNotNull(plan);
        User user = netflix.createUser("Paulo", "paulo@mail.com", trialPlan);
        assertNotNull(user);
        user.addToWatchlist(movie1);
        user.addToWatchlist(movie2);
        int numMovies = user.getWatchListSize();
        assertEquals(2, numMovies);
        System.out.println("Movie test4: watchList updated.");
    }

}

