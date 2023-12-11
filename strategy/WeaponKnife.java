import java.util.*;

/**
 * The Knife weapon behavior
 * @author Andrew Davison
 */
public class WeaponKnife implements WeaponBehavior{

    /**
     * Creates a string representing the Knife's weapon behavior
     * @return a string representation of the Knife's weapon behavior
     */
    public String attack() {
        Random random = new Random();
        int rand = random.nextInt(3);
        if(rand == 0) {
            return "Slice with knife";
        } else if (rand == 1) {
            return "Jab with knife";
        } else {
            return "Sneak up on opponent with knife";
        }
    }
}
