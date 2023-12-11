/**
 * A video game character that represents a King character
 * @author Andrew Davison
 */
public class King extends Character{
    
    /**
     * Creates a new instance of a King video game character
     * @param name The name of the king
     */
    public King(String name) {
        super(name);
        weaponBehavior = new WeaponSword();
    }

    /**
     * Creates a string representation of the King
     * @return a string representation of the King
     */
    @Override
    public String toString() {
        return this.name + " is a Noble King";
    }
}
