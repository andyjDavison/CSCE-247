/**
 * A vanilla ice cream
 * @author Andrew Davison
 */
public class Vanilla extends ScoopDecorator {
    
    /**
     * Creates a new instance of vanilla ice cream
     * @param iceCream The ice cream to be decorated
     * @param numScoops the number of vanilla ice cream scoops
     */
    public Vanilla(IceCream iceCream, int numScoops) {
        super(iceCream, numScoops);
        this.flavorCost = 1.25*numScoops;
        this.flavor = "vanilla";
    }

    /**
     * The cost of the vanilla scoops plus the other costs
     * @return A double that represents the total cost of the vanilla ice cream
     */
    @Override
    public double getCost() {
        return super.iceCream.getCost() + this.flavorCost;
    }
}
