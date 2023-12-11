/**
 * Subject that creates a list and gives updates to observers
 * @author Andrew Davison
 */
public interface Subject {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObserver();
}