package system.user;

import system.util.SystemUtil;

import java.util.Arrays;

/**
 * Represents a user's subscription plan, including its type and active status.
 */
public class UserPlan {

    /**
     * Enumeration of possible plan types.
     */
    public enum PlanType {
        trial, standard, vip;
    }

    private PlanType type;
    private boolean isActive;

    /**
     * Constructs a new UserPlan with the specified type and active status.
     *
     * @param type The type of the plan.
     * @param isActive The active status of the plan.
     */
    private UserPlan(PlanType type, boolean isActive) {
        this.type = type;
        this.isActive = isActive;
    }

    /**
     * Returns the type of the plan.
     *
     * @return The type of the plan.
     */
    public PlanType getType() {
        return type;
    }

    /**
     * Returns whether the plan is active.
     *
     * @return True if the plan is active, otherwise false.
     */
    public boolean isActive() {
        return isActive;
    }

    /**
     * Sets the type of the plan.
     *
     * @param type The new type of the plan.
     */
    public void setType(PlanType type) {
        this.type = type;
    }

    /**
     * Sets the active status of the plan.
     *
     * @param active The new active status of the plan.
     */
    public void setActive(boolean active) {
        isActive = active;
    }

    /**
     * Creates a UserPlan instance based on the provided plan data.
     *
     * @param planData An array of strings representing plan data.
     * @return A UserPlan instance if the data is valid, otherwise null.
     */
    public static UserPlan createPlan(String... planData) {
        if (Arrays.stream(planData).anyMatch(data -> !SystemUtil.isValid(data))) {
            return null;
        }

        PlanType type = switch (planData[0]) {
            case "1", "trial" -> PlanType.trial;
            case "2", "standard" -> PlanType.standard;
            case "3", "vip" -> PlanType.vip;
            default -> null;
        };

        Boolean isActive = switch (planData[1]) {
            case "1", "true" -> true;
            case "2", "false" -> false;
            default -> null;
        };

        if (isActive == null && type == null) {
            return null;
        }

        return new UserPlan(type, isActive);
    }

    /**
     * Returns a string representation of the UserPlan.
     *
     * @return A string describing the plan's active status and type.
     */
    @Override
    public String toString() {

        return String.format("Plan: IsActive: %b, Type: %s", isActive, type);
    }
}
