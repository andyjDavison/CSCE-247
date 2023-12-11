/**
 * The Bow weapon behavior
 * @author Andrew Davison
 */
public class WeaponBow implements WeaponBehavior{

    /**
     * Creates a string representation of the Bow's weapon behavior
     * @return a string representing the Bow's weapon behavior
     */
    public String attack() {
        if(Math.round(Math.random()) == 0) {
            return "Draw and lose an arrow";
        } else {
            return "Shoot arrow high into the sky";
        }
    }
}
