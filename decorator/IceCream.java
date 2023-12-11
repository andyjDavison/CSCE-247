/**
 * An ice cream that can be decorated
 * @author Andrew Davison
 */
public abstract class IceCream {
    protected String description;

    /**
     * Gives the description of the ice cream
     * @return A string that represents the ice cream's description
     */
    public String toString() {
        return this.description;
    }

    public abstract double getCost();
}
