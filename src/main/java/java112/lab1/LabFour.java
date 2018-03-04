package java112.lab1;

import java.io.*;

/**
 * @author Elise Strauss
 * class LabFour
 */
public class LabFour {

    private static final int VALID_ARGUMENT_COUNT = 1;

    public void run(String inputFilePath) {

       BufferedReader input = null;

       try {
           input = new BufferedReader(new FileReader(inputFilePath));

           while (input.ready()) {
            System.out.println(input.readLine());
           }

       } catch (FileNotFoundException fileNotFound) {
           fileNotFound.printStackTrace();
       } catch (IOException inputOutputException) {
           inputOutputException.printStackTrace();
       } catch (Exception exception) {
           exception.printStackTrace();
       } finally {
           try {
               if (input != null) {
               input.close();
               }
           } catch (Exception exception) {
               exception.printStackTrace();
           }

       }

    }

    /**
     * This main method will accept only one argument from the
     * command line and will call a method to print it.
     * @param arguments The command line arguments.
     */
    public static void main(String[] arguments) {
        if (arguments.length != VALID_ARGUMENT_COUNT) {
            System.out.println("Please enter one argument on the command line");
            return;
        }

        LabFour readFile = new LabFour();
        readFile.run(arguments[0]);
    }
}

