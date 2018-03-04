package java112.lab1;

import java.io.*;

/**
 * @author Elise Strauss
 * LabSix
 */
public class LabSix {



    public void run(String inputFilePath, String outputFilePath) {

        BufferedReader inputFile = null;
        PrintWriter outputFile = null;

        try {

            inputFile = new BufferedReader(new FileReader(inputFilePath));
            outputFile = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)));

            while (inputFile.ready()) {
                outputFile.println(inputFile.readLine());
            }

        } catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (outputFile != null) {
                outputFile.close();
            }
            try {
                if (inputFile != null) {
                    inputFile.close();
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
    /**
     * The start of the program
     * @param arguments The command line arguments.
     */
    public static void main(String[] arguments) {
        if (arguments.length != 2) {
            System.out.println("Please enter two arguments on the command line, an input file name and an output file name");
            return;
        }

        LabSix lab = new LabSix();
        lab.run(arguments[0], arguments[1]);
    }

}
