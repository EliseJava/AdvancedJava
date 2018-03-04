package java112.lab1;

import java.io.*;
import java.util.*;

/**
 * @author Elise Strauss
 * class name:  LabEight will demonstrate the Set interface
 */

public class LabEight {

    SortedSet<String> setSortList;


    public void run(String outputFile) {
        setSortList = new TreeSet<String>();

        setSortList.add("one");
        setSortList.add("one");
        setSortList.add("five");
        setSortList.add("two");
        setSortList.add("four");
        setSortList.add("two");
        setSortList.add("three");
        setSortList.add("three");
        setSortList.add("four");
        setSortList.add("three");

        System.out.println(setSortList);

        writeSetToOutputFile(outputFile);
    }


    public void writeSetToOutputFile(String file) {

        PrintWriter fileCreatedWithSortList = null;

        try {
            fileCreatedWithSortList = new PrintWriter(new BufferedWriter(new FileWriter(file)));

            for (String element: setSortList) {
                fileCreatedWithSortList.println(element);
            }
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (fileCreatedWithSortList != null) {
                fileCreatedWithSortList.close();
            }
        }
    }

    /**
     * The start of the program.  This program will instantiate an instance of
     * this class and pass an file name to it
     * @param arguments The command line arguments.
     */
    public static void main(String[] arguments) {

        if (arguments.length != 1) {
            System.out.println("Please enter one argument on the command line, an output file name");
            return;
        }

        LabEight lab = new LabEight();
        lab.run(arguments[0]);
    }

}