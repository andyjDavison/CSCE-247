/**
 * Shopowner that observes the watchman
 * @author Andrew Davison
 */
public class ShopOwner implements Observer {
    
    private Subject watchman;

    /**
     * Creates an instance of the Shopowner class
     * @param watchman The watchman that the knight observes
     */
    public ShopOwner(Subject watchman) {
        this.watchman = watchman;
        watchman.registerObserver(this);
    }

    /**
     * Updates the Shopowner's output based on the warning
     * @param warning Integer that determines the output
     */
    @Override
    public void update(int warning) {
        if(warning == 1) {
            System.out.println("Shop Owner: Close down shop and head home");
        } else {
            System.out.println("Shop Owner: Drops everything and find nearest hideout");
        }
    }
}
