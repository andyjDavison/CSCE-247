/**
 * A Five Minute Countdown Command for a StopWatch
 * @author Andy Davison, Jakob Jerzmanowski, Trevor Allison, and Callie Hribar
 */
public class FiveMinCommand implements Command {

    private StopWatch watch;

    /**
     * Assigns the watch that will count down 5 minutes
     * @param watch The watch that will count down
     */
    public FiveMinCommand(StopWatch watch){
        this.watch = watch;
    }

    /**
     * Makes the watch count down 5 minutes
     */
    public void execute() {
        watch.countDownFiveMin();
    }
}
