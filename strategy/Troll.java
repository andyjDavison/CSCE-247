/**
 * A Troll video game character
 * @author Andrew Davison
 */
public class Troll extends Character {
    
    /**
     * Creates an instance of a Troll video game character
     * @param name The name of the Troll
     */
    public Troll(String name) {
        super(name);
        weaponBehavior = new WeaponAxe();
    }

    /**
     * Creates a string representation of the Troll
     * @return a string representation of the Troll
     */
    @Override
    public String toString() {
        return this.name + " is a funny troll";
    }
}
