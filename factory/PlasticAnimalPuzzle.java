import java.util.ArrayList;
import java.util.Arrays;

/**
 * A Plastic Animal Puzzle class
 * @author Andrew Davison
 */
public class PlasticAnimalPuzzle extends Puzzle {
    
    /**
     * Creates an instance of a Plastice Animal Puzzle
     */
    public PlasticAnimalPuzzle() {
        this.name = "Animal Puzzle by Fisher Price";
        this.material = "plastic";
        this.pieces = new ArrayList<String>(Arrays.asList("Fox", "Elephant", "Giraffe", "Owl", "Monkey"));
    }
}
