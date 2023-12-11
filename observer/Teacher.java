/**
 * A teacher that observes the Watchman
 * @author Andrew Davison
 */
public class Teacher implements Observer {
    
    private Subject watchman;

    /**
     * Creates a new instance of the Teacher observer
     * @param watchman The watchman that the teacher observes
     */
    public Teacher(Subject watchman) {
        this.watchman = watchman;
        watchman.registerObserver(this);
    }

    /**
     * Updates the teachers output based on the subjects warning
     * @param warning An integer that determines the teachers actions
     */
    @Override
    public void update(int warning) {
        if(warning == 1) {
            System.out.println("Teacher: Helps get every kid home safe");
        } else {
            System.out.println("Teacher: Brings all students to the underground shelter");
        }
    }
}
