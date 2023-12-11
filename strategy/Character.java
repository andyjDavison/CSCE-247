/**
 * A video game character
 * @author Andrew Davison
 * 
 */
public abstract class Character {
    protected String name;
    protected WeaponBehavior weaponBehavior;

    /**
     * Creates a new instance of a Video Game character
     * @param name The string representing the characters name
     */
    public Character(String name) {
        this.name = name;
    }
    
    /**
     * Creates a string represntation of the attack used by the character
     * @return A string representation of the attack used by the character
     */
    public String attack() {
        return weaponBehavior.attack();
    }

    /**
     * Sets the weapong behavior of the characters weapon
     * @param wb A weapon behavior
     */
    public void setWeaponBehavior(WeaponBehavior wb) {
        this.weaponBehavior = wb;
    }

    public abstract String toString();

}
