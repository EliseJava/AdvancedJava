package java112.lab1;

import java.io.*;
import java.util.*;

/**
 * @author Elise Strauss
 * class name
 */

public class LabSeven {
    private List<String> countList;


    public void run(String outputFile) {

        countList = new ArrayList<String>();

        countList.add("one");
        countList.add("two");
        countList.add("three");
        countList.add("four");
        countList.add("five");
        countList.add("six");
        countList.add("seven");
        countList.add("eight");
        countList.add("nine");
        countList.add("ten");

        System.out.println(countList);

        writeListToOutputFile(outputFile);
    }

     public void writeListToOutputFile(String file) {

        PrintWriter fileCreatedWithList = null;

        try {

            fileCreatedWithList = new PrintWriter(new BufferedWriter(new FileWriter(file)));

            for (String element: countList) {
                fileCreatedWithList.println(element);
            }

        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (fileCreatedWithList !=null) {
                fileCreatedWithList.close();
            }
        }
    }

    /**
     * The start of the program.  This main method will instantiate this class
     * and pass a file name to its run method.
     * @param arguments The command line arguments.
     */
    public static void main(String[] arguments) {

        if (arguments.length != 1) {
            System.out.println("Please enter one argument on the command line, an output file name");
            return;
        }

        LabSeven lab7 = new LabSeven();
        lab7.run(arguments[0]);
    }

}