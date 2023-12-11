/**
 * A Fisher Price version of a Toy Store
 * @author Andrew Davison
 */
public class FisherPriceStore extends ToyStore {
    
    /**
     * Creates a new puzzle based on the type of the puzzle
     * @param type A string that represents the type of puzzle
     * @return A new instance of that type of puzzle
     */
    public Puzzle createPuzzle(String type) {
        Puzzle puzzle;
        if(type.equals("color")) {
            puzzle = new PlasticColorPuzzle();
        } else if(type.equals("animal")) {
            puzzle = new PlasticAnimalPuzzle();
        } else {
            return null;
        }
        return puzzle;
    }
}
