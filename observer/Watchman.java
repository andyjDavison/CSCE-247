import java.util.ArrayList;

/**
 * Watchman that updates it's subjects with trumpet calls
 * @author Andrew Davison
 */
public class Watchman implements Subject {
    
    ArrayList<Observer> observers;
    private int warning;

    /**
     * Creates a new watchman with a list of observers
     */
    public Watchman() {
        observers = new ArrayList<Observer>();
    }

    /**
     * Adds an observer to the watchman's observer list
     * @param observer The observer to be removed
     */
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * Removes an observer from the watchman's observer list
     * @param observer The observer to be removed
     */
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Notifys every observer in the watchman's observer list
     */
    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(this.warning);
        }
    }

    /**
     * Issues a warning to the observers in the list
     * @param warning An integer that represent a warning
     */
    public void issueWarning(int warning) {
        if(warning == 1) {
            System.out.println("WARNING: 1 trumpet was played!");
            //this.warning = 1;
            notifyObserver();
        } else {
            System.out.println("WARNING: 2 trumpets were played!");
            // this.warning = 2;
            notifyObserver();
        }
    }
}
