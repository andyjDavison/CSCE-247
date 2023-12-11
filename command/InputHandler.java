import java.util.HashMap;

/**
 * An Input Handler Class for dealing with StopWatch Input
 * @author Andy Davison, Jakob Jerzmanowski, Trevor Allison, and Callie Hribar
 */
public class InputHandler {
    
    private HashMap<String, Command> commands = new HashMap<>();

    /**
     * Populates the commands hashmap with appropriate keys
     * for appropriate commands
     * @param watch this watch that will count down
     */
    public InputHandler(StopWatch watch) {
        this.commands.put("1", new OneMinCommand(watch));
        this.commands.put("5", new FiveMinCommand(watch));
        this.commands.put("30", new ThirtySecCommand(watch));
    }

    /**
     * Validates and executes functions on the watch based on input
     * @param data the user input time for count down
     * @return The boolean validity of the input
     */
    public boolean inputEntered(String data) {
        if(this.commands.containsKey(data)) {
            this.commands.get(data).execute();
            return true;
        }
        return false;
    }
}
