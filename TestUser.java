package CST8132Lab05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CST8132Lab05.Netflix;
import CST8132Lab05.Plan;
import CST8132Lab05.User;

class TestUser {
    Plan trialPlan = new Plan(false, Plan.plan.trial);
    Plan vipPlan = new Plan(true, Plan.plan.vip);
    Plan standardPlan = new Plan(true, Plan.plan.standard);

    @Test
    void testUser() {
        System.out.println("Testing users...................");
        Netflix netflix = new Netflix();
        Plan plan = netflix.createPlan("invalid", false);
        assertNull(plan);
        System.out.println("User test1: invalid Plan denied");
        plan = netflix.createPlan("vip", true);
        assertNotNull(plan);
        System.out.println("User test2: valid Plan created");
        User user = netflix.createUser(" ", null, vipPlan);
        assertNull(user);
        System.out.println("User test3: invalid User denied");
        user = netflix.createUser("Paulo", "paulo@mail.com", trialPlan);
        assertNotNull(user);
        System.out.println("User test4: valid User created");
        user.setPlan(plan);
    }

}