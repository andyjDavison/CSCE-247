/**
 * A bowl that holds ice cream
 * @author Andrew Davison
 */
public class Bowl extends IceCream {
    
    /**
     * Creates a new instance of a bowl
     */
    public Bowl() {
        this.description = "Bowl";
    }

    /**
     * The cost of the empty bowl
     * @return a double that represents the price of the empty bowl
     */
    @Override
    public double getCost() {
        return 0.0;
    }
}
