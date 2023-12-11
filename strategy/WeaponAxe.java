/**
 * The Axe weapon behavior
 * @author Andrew Davison
 */
public class WeaponAxe implements WeaponBehavior {

    /**
     * Creates a string reperesenting the Axe's weapon behavior
     * @return a string that represents the Axe's weapon behavior
     */
    public String attack() {
        if(Math.round(Math.random()) == 0) {
            return "Swing an axe";
        } else {
            return "Twirl with an axe";
        }
    }
}
