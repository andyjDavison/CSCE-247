/**
 * A scoop decorator that will decorator the scoops of ice cream
 * @author Andrew Davison
 */
public abstract class ScoopDecorator extends IceCream {
    
    protected IceCream iceCream;
    protected int numScoops;
    protected String flavor;
    protected double flavorCost;

    /**
     * Creates a new instance of a scoop decorator
     * @param iceCream The ice cream that the scoop decorator will decorate
     * @param numScoops The number of scoops of that ice cream that will be decorated
     */
    public ScoopDecorator(IceCream iceCream, int numScoops) {
        this.iceCream = iceCream;
        this.numScoops = numScoops;
        String temp = "";
        if (this.numScoops == 1) {
            temp = ", a scoop of ";
        } else {
            temp = ", " + this.numScoops + " scoops of ";
        }
        this.description = temp;
    }

    /**
     * Gives the description of the ice cream after decoration
     * @return A string that represents the decorated ice cream
     */
    @Override
    public String toString() {
        return iceCream.toString() + this.description + this.flavor + " ice cream";
    }
}
