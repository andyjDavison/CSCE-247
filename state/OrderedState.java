/**
 * The OrderedState class
 * @author Andrew Davison
 */
public class OrderedState extends State {
    private int days = 2;

    /**
     * Creates an instance of an ordered state
     * @param pkg The package that is currently in the ordered state
     * @param quantity The number of items in the package in this state
     */
    public OrderedState(Package pkg, int quantity) {
        super(pkg, quantity);
    }

    /**
     * Gets the status of the package
     * @return A string representing the current status of the package
     */
    public String getStatus() {
        return "The " + this.pkg.getName() + this.getVerb(" was", " were") + " ordered";
    }

    /**
     * Gets the ETA of the package
     * @return A string representing the current ETA of the package
     */
    public String getETA() {
        return "The " + this.pkg.getName() + " will be shipped within " + this.days + " business days";
    }

    /**
     * Gets the delay on the package
     * @return A string representing the number of days of delay and status of the package
     */
    public String delay() {
        this.days += 2;
        return "The " + this.pkg.getName() + " experienced a slight delay in manufacturing." + "\n" +this.getETA();
    }
}
