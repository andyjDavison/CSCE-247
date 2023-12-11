import java.util.Scanner;

/**
 * A program to run the Stop Watch
 */
public class Program {
    private Scanner reader;

    /**
     * Creates a new Program that will read input from the user and invoke the
     * correct stopwatch functionality
     */
    public Program() {
        reader = new Scanner(System.in);
    }

    /**
     * Will ask the user how much time they want on the stopwatch Then it will count
     * down.
     */
    public void run() {
        StopWatch watch = new StopWatch();
        InputHandler inHandler = new InputHandler(watch);

        System.out.println("Welcome to our Timer System");

        while (true) {
            System.out.print("Enter (1)minute, (5)minutes, (30)seconds or (q)uit: ");
            String command = reader.nextLine().trim();

            if (command.equals("q"))
                break;

            if (!inHandler.inputEntered(command)) {
                System.out.println("Invalid input");
            }

        }

        System.out.println("Goodbye");
    }

    public static void main(String[] args) {
        Program program = new Program();
        program.run();
    }
}