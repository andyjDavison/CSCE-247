/**
 * A chocolate ice cream
 * @author Andrew Davison
 */
public class Chocolate extends ScoopDecorator {
    
    /**
     * Creates an instance of the chocolate ice cream
     * @param iceCream the ice cream to be decorated
     * @param numScoops the nuber of scoops of chocolate ice cream
     */
    public Chocolate(IceCream iceCream, int numScoops) {
        super(iceCream, numScoops);
        this.flavorCost = 1.5*numScoops;
        this.flavor = "chocolate";
    }

    /**
     * The cost of the chocolate ice cream with everything else
     * @return A double that represents the total cost with the chocolate added
     */
    @Override
    public double getCost() {
        return super.iceCream.getCost() + this.flavorCost;
    }
}
