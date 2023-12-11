/**
 * A cone that holds ice cream
 * @author Andrew Davison
 */
public class Cone extends IceCream {
    
    private ConeType coneType;

    /**
     * Creates a new instance of a cone
     * @param coneType The type of cone that you will create
     */
    public Cone(ConeType coneType) {
        switch(coneType) {
            case WAFFLE_CONE:
                this.coneType = ConeType.WAFFLE_CONE;
                this.description = "Waffle Cone";
                break;
            case SUGAR_CONE:
                this.coneType = ConeType.SUGAR_CONE;
                this.description = "Sugar Cone";
                break;
            case PRETZEL_CONE:
                this.coneType = ConeType.PRETZEL_CONE;
                this.description = "Pretzel Cone";
                break;
            case CHOCOLATE_DIPPED_CONE:
                this.coneType = ConeType.CHOCOLATE_DIPPED_CONE;
                this.description = "Chocolate Dipped Cone";
                break;
            default:
                break;
        }
    }
    
    /**
     * Returns a cost of a cone depending on what type of cone it is
     * @return A double that represents the cost of the cone
     */
    @Override
    public double getCost() {
        switch(this.coneType) {
            case WAFFLE_CONE:
                return 1.2;
            case SUGAR_CONE:
                return 0.75;
            case PRETZEL_CONE:
                return 1.8;
            case CHOCOLATE_DIPPED_CONE:
                return 1.5;
            default:
                return 0;
        }
    }
}
