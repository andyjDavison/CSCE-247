/**
 * A Thirty Second Countdown Command for a StopWatch
 * @author Andy Davison, Jakob Jerzmanowski, Trevor Allison, and Callie Hribar
 */
public class ThirtySecCommand implements Command {
    
    private StopWatch watch;

    /**
     * Assigns the watch that will count down thirty seconds
     * @param watch The watch that will count down
     */
    public ThirtySecCommand(StopWatch watch){
        this.watch = watch;
    }

    /**
     * Makes the watch count down 30 seconds
     */
    public void execute() {
        watch.countDownThirtySec();
    }
}
