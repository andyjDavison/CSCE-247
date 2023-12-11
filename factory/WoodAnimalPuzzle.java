import java.util.ArrayList;
import java.util.Arrays;

/**
 * A Wood Animal Puzzle class
 * @author Andrew Davison
 */
public class WoodAnimalPuzzle extends Puzzle {
    
    /**
     * Creates an instance of a Wood Animal Puzzle
     */
    public WoodAnimalPuzzle() {
        this.name = "Animal Puzzle by Melissa and Doug";
        this.material = "wood";
        this.pieces = new ArrayList<String>(Arrays.asList("Horse", "Sheep", "Dog", "Cat", "Cow", "Chicken"));
    }
}
