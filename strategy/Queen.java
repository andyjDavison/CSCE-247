/**
 * A Queen video game character
 * @author Andrew Davison
 */
public class Queen extends Character{

    /**
     * Creates an instance of the Queen video game character
     * @param name The name of the Queen
     */
    public Queen(String name) {
        super(name);
        weaponBehavior = new WeaponKnife();
    }
    
    /**
     * Creates a string representation of the Queen
     * @return a string representation of the Queen
     */
    @Override
    public String toString(){
        return this.name + " is a beautiful queen";
    }
}
