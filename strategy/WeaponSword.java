import java.util.*;

/**
 * The Sword weapon behavior
 * @author Andrew Davison
 */
public class WeaponSword implements WeaponBehavior{

    /**
     * Creates a string representing the Sword's weapon behavior
     * @return a string representing the Sword's weapon behavior
     */
    public String attack() {
        Random random = new Random();
        int rand = random.nextInt(3);
        if(rand == 0) {
            return "Lunge and strike with sword";
        } else if (rand == 1) {
            return "Fancy turn and slice with sword";
        } else {
            return "Jam opponents blade with sword";
        }
    }
}
