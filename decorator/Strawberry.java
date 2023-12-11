/**
 * A strawberry ice cream
 * @author Andrew Davison
 */
public class Strawberry extends ScoopDecorator {
    
    /**
     * Creates a new instance of strawberry ice cream
     * @param iceCream the ice cream to be decorated
     * @param numScoops the number of strawberry ice cream scoops
     */
    public Strawberry(IceCream iceCream, int numScoops) {
        super(iceCream, numScoops);
        this.flavor = "strawberry";
        this.flavorCost = 1.4*numScoops;
    }

    /**
     * The cost of the strawberry ice cream
     * @return a double that is the cost of the strawberry ice cream
     */
    @Override
    public double getCost() {
        return super.iceCream.getCost() + this.flavorCost;
    }
}
