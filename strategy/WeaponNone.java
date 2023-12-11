/**
 * No weapon weapon behavior
 * @author Andrew Davison
 */
public class WeaponNone implements WeaponBehavior{

    /**
     * Creates a string representing the No weapon, weapon behavior
     * @return a string representation of the No weapon, weapon behavior
     */
    public String attack() {
        if(Math.round(Math.random()) == 0) {
            return "Oh no! I lost my weapon";
        } else {
            return "No one lets me have a weapon";
        }
    }
}
