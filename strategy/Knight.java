/**
 * A knight video game Character
 * @author Andrew Davison
 */
public class Knight extends Character{

    /**
     * Creates an instance of the Knight video game character
     * @param name The name of the knight
     */
    public Knight(String name) {
        super(name);
        weaponBehavior = new WeaponBow();
    }

    /**
     * Creates a string representation of the knight
     * @return a string representation of the knight
     */
    @Override
    public String toString() {
        return this.name + " is a valiant knight";
    }
}
