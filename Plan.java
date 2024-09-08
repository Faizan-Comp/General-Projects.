package CST8132Lab05;

public class Plan {
    private boolean isActive;
    private plan type;
    public enum plan {
        trial, standard, vip;
    }

    public Plan(boolean isActive, plan Type) {
        this.isActive = isActive;
        this.type = Type;
    }

    public boolean getIsActive() {
        if (type == plan.trial) {
            isActive = false;
            return isActive;
        }
        else{
            isActive = true;
            return isActive;
        }
    }
    public plan getType() {
        return type;
    }

    @Override
    public String toString() {
        return "IsActive: " + isActive + ", Type: " + type;
    }
}
