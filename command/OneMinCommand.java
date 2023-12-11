/**
 * A One Minute Countdown Command for a StopWatch
 * @author Andy Davison, Jakob Jerzmanowski, Trevor Allison, and Callie Hribar
 */
public class OneMinCommand implements Command{

    private StopWatch watch;

    /**
     * Assigns the watch that will count down 1 minutes
     * @param watch The watch that will count down
     */
    public OneMinCommand(StopWatch watch){
        this.watch = watch;
    }

    /**
     * Makes the watch count down 1 minute
     */
    public void execute() {
        watch.countDownOneMin();
    }
    
}
