import java.util.ArrayList;

/**
 * A Puzzle class
 * @author Andrew Davison
 */
public abstract class Puzzle {
    
    protected String name;
    protected String material;
    protected ArrayList<String> pieces;

    /**
     * Assembles the puzzle into a string of its name, material, and pieces
     * @return A String that represents the puzzle
     */
    public String assemble() {
        String temp = "";
        for(String piece : pieces) {
            temp += "\n-  " + piece;
        }
        return "Putting together a " + this.name + "\nThis puzzle is made out of " +
            this.material + "\nAdding the following pieces" + temp;
    }

    /**
     * Puts the puzzle in a box
     * @return A string that represents the puzzle in a box
     */
    public String boxPuzzle() {
        return "Putting the " + this.name + " in a box";
    }
}
