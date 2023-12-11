import java.util.ArrayList;
import java.util.Arrays;

/**
 * A Wood Color Puzzle class
 * @author Andrew Davison
 */
public class WoodColorPuzzle extends Puzzle {
    
    /**
     * Creates an instance of a Wood Color Puzzle
     */
    public WoodColorPuzzle() {
        this.name = "Color Puzzle by Melissa and Doug";
        this.material = "wood";
        this.pieces = new ArrayList<String>(Arrays.asList("Red Fish", "Yellow Fish", "Green Fish", "Purple Fish", "Pink Fish",
            "Orange Fish", "Brown Fish", "White Fish", "Black Fish"));
    }
}
