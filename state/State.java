/**
 * A State class
 * @author Andrew Davison
 */
public abstract class State {
    protected Package pkg;
    protected int quantity;

    /**
     * Creates a new instance of the state class
     * @param pkg The package that is currently in this state
     * @param quantity The number of the packages in this state
     */
    public State(Package pkg, int quantity) {
        this.pkg = pkg;
        this.quantity = quantity;
    }

    public abstract String getStatus();

    public abstract String getETA();

    public abstract String delay();

    /**
     * Returns the singular or plural version of a verb depending on the number of packages
     * @param singular The singular version of the verb
     * @param plural The plural version of the verb
     * @return A String of the verb dependent on the number of packages
     */
    protected String getVerb(String singular, String plural) {
        return (this.quantity > 1) ? plural : singular;
    }
}
