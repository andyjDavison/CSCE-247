/**
 * Knight that observes the Watchman
 * @author Andrew Davison
 */
public class Knight implements Observer {
    
    private Subject watchman;

    /**
     * Creates a new instance of the Knight
     * @param watchman The watchman that the knight observes
     */
    public Knight(Subject watchman) {
        this.watchman = watchman;
        watchman.registerObserver(this);
    }

    /**
     * Updates the output based on the warning
     * @param warning An integer that determines the output
     */
    @Override
    public void update(int warning) {
        if(warning == 1) {
            System.out.println("Knight: Helps everyone get home safe");
        } else {
            System.out.println("Knight: Prepares for battle");
        }
    }
}
