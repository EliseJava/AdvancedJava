package java112.lab1;

import java.io.*;
/**
 * @author Elise Strauss
 * class LabFive
 */

public class LabFive {




    public void run(String fileName, String fileMessage) {

        PrintWriter newFile = null;


        try {

            newFile = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
            newFile.println(fileMessage);

        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (newFile != null) {
                newFile.close();
            }
        }
    }

    /**
     * The start of the program. This main method will accept
     * 2 parameter from the command line a file name and
     * a message without any spaces.
     * @param arguments The command line arguments.
     */
    public static void main(String[] arguments) {
        if (arguments.length != 2) {
            System.out.println("Please enter two arguments on the command line, a file name and a message");
            return;
        }

        LabFive writeFile = new LabFive();
        writeFile.run(arguments[0], arguments[1]);
    }

}