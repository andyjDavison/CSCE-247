import java.util.ArrayList;
import java.util.Arrays;

/**
 * A Plastice Color Puzzle class
 * @author Andrew Davison
 */
public class PlasticColorPuzzle extends Puzzle {
    
    /**
     * Creates an instance of the Plastice Color Puzzle
     */
    public PlasticColorPuzzle() {
        this.name = "Color Puzzle by Fisher Price";
        this.material = "plastic";
        this.pieces = new ArrayList<String>(Arrays.asList("Green Dog", "Orange Dog", "Red Dog", "Blue Dog", "Yellow Dog", "Brown Dog"));
    }
}
