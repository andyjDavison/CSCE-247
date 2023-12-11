/**
 * The InTransitState class
 * @author Andrew Davison
 */
public class InTransitState extends State {
    private int days = 5;

    /**
     * Creates an instance of an InTransitState 
     * @param pkg The package that is currently in the transit state
     * @param quantity The number of items in the package in this state
     */
    public InTransitState(Package pkg, int quantity) {
        super(pkg, quantity);
    }

    /**
     * Gets the status of the package
     * @return A string representing the current status of the package
     */
    public String getStatus() {
        return "The " + this.pkg.getName() + this.getVerb(" is", " are") + " out for delivery";
    }

    /**
     * Gets the ETA of the package
     * @return A string representing the current ETA of the package
     */
    public String getETA() {
        return "The " + this.pkg.getName() + " should arrive within " + this.days + " days";
    }

    /**
     * Gets the delay on the package
     * @return A string representing the number of days of delay and status of the package
     */
    public String delay() {
        this.days += 3;
        return "The " + this.pkg.getName() + this.getVerb(" has", " have") + " experienced a delay in shipping" + "\n" + this.getETA();
    }
}
