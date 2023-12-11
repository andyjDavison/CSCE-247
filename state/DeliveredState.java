/**
 * The DeliveredState class
 * @author Andrew Davison
 */
public class DeliveredState extends State {

    /**
     * Creates a new instance of a DeliveredState
     * @param pkg The package that is currently in the delivered state
     * @param quantity The number of items in the package in this state
     */
    public DeliveredState(Package pkg, int quantity) {
        super(pkg, quantity);
    }

    /**
     * Gets the status of the package
     * @return A string representing the current status of the package
     */
    public String getStatus() {
        return "The " + this.pkg.getName() + this.getVerb(" is", " are") + " here for you";
    }

    /**
     * Gets the ETA of the package
     * @return A string representing the current ETA of the package
     */
    public String getETA() {
        return "The " + this.pkg.getName() + this.getVerb(" is", " are") + " here";
    }

    /**
     * Gets the delay on the package
     * @return A string representing the number of days of delay and status of the package
     */
    public String delay() {
        return "The " + this.pkg.getName() + this.getVerb(" has", " have") + " already been delivered";
    }
}
