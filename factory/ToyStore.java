/**
 * Toy Store that can order puzzles
 * @author Andrew Davison
 */
public abstract class ToyStore {
    
    /**
     * Returns the Puzzle assemebled and boxed
     * @param type A String that represents the type of puzzle being ordered
     * @return A string representation of the puzzle assembled and boxed
     */
    public String orderPuzzle(String type) {
        Puzzle puzzle = createPuzzle(type);

        return puzzle.assemble() + "\n" + puzzle.boxPuzzle();
    }

    public abstract Puzzle createPuzzle(String type);
}