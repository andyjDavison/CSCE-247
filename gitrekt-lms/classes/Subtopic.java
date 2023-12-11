package classes;
/**
 * A subtopic class
 */
public class Subtopic {
    private String name;
    private String info;

    /**
     * Creates an instance of a subtopic
     * @param name The name of the subtopic
     * @param info The info inside the subtopic
     */
    public Subtopic(String name, String info){
        this.name = name;
        this.info = info;
    }
    /**
     * Prints the topic to a string
     * @return A string that represents the subtopic
     */
    public String toString(){
        String result = "";
        result += this.name+"\n";
        result += this.info+"\n";
        return result;
    }
    /**
     * @return name
     */
    public String getName() {
        return this.name;
    }
    /**
     * @return info
     */
    public String getInfo() {
        return this.info;
    }
}
