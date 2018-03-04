package java112.lab1;

/**
 * @author Elise Strauss
 * class LabThree
 */
public class LabThree {

    private static final int VALID_ARGUMENT_COUNT = 1;

    public void run(String input) {
        System.out.println("input: " + input);
    }

    /**
     * This main method will accept only one argument and pass it
     * to the run method in this class
     * @param arguments The command line arguments.
     */
    public static void main(String[] arguments) {
        if (arguments.length != VALID_ARGUMENT_COUNT) {
            System.out.println("Please enter one argument on the command line");
            return;
        }

        LabThree labThree = new LabThree();
        labThree.run(arguments[0]);

    }

}