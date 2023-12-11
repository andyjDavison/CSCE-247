/**
 * The Melissa and Doug Version of a Toy Store
 */
public class MelissaAndDougStore extends ToyStore {
    
    /**
     * Creates a new puzzle based on the type of the puzzle
     * @param type A string that represents the type of the puzzle
     * @return A new instance of the type of puzzle
     */
    public Puzzle createPuzzle(String type) {
        Puzzle puzzle;
        if(type.equals("color")) {
            puzzle = new WoodColorPuzzle();
        } else if(type.equals("animal")) {
            puzzle = new WoodAnimalPuzzle();
        } else {
            return null;
        }
        return puzzle;
    }
}
