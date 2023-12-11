/**
 * A package class
 * @author Andrew Davison
 */
public class Package {
    private String name;
    private int quantity;
    private State state;
    private State orderedState;
    private State inTransitState;
    private State deliveredState;

    /**
     * Creates a new instance of the package class
     * @param name A string representing the name of the package
     * @param quantity An integer representing the number of packages
     */
    public Package(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
        setState(this.state);
        this.orderedState = new OrderedState(this, this.quantity);
        this.inTransitState = new InTransitState(this, this.quantity);
        this.deliveredState = new DeliveredState(this, this.quantity);
    }

    /**
     * Returns the status of the ordered package
     * @return A string representing the packages status
     */
    public String order() {
        setState(this.orderedState);
        return this.state.getStatus() + "\n" + this.state.getETA();
    }

    /**
     * Returns the status of the in transit package
     * @return A string representing the packages status
     */
    public String mail() {
        setState(this.inTransitState);
        return this.state.getStatus() + "\n" + this.state.getETA();
    }

    /**
     * Returns the status of the package once it's recieved
     * @return A string representing the packages status
     */
    public String received() {
        setState(this.deliveredState);
        return this.state.getStatus();
    }

    /**
     * Returns the status of the package after a delay
     * @return A string representing the packages status
     */
    public String delay() {
        return this.state.delay();
    }

    /**
     * Sets the current state of the package
     * @param state The state that the package is currently in
     */
    public void setState(State state) {
        this.state = state;
    }

    /**
     * Gets the packages name
     * @return A string representing the packages name
     */
    public String getName() {
        return this.name;
    }
}