package java112.analyzer;

import java.io.*;
import java.util.*;

/**
 * This class will count the token in an input file and produce a summary report
 * @author Elise Strauss
 * class SummaryReport
 */
public class SummaryReport implements Analyzer {

    private int totalTokensCount;
    private Properties properties;

    /**
      * Empty constuctor for SummaryReport
      */
    public SummaryReport() {
    }

    /**
      * SummaryReport constructor with one Properties parameter
      * @param properties The Properties object loaded with the properties file
      *                    in the config directory
      */
    public SummaryReport(Properties properties) {
        this();
        this.properties = properties;
    }


    /**
     * get method for the total count of tokens
     * @return totalTokensCount The total count of tokens
     */
    public int getTotalTokensCount() {
        return totalTokensCount;
    }


    /**
     * get method for the total count of tokens
     * @param token  The individual token from the input file
     */
    public void processToken(String token) {

        totalTokensCount += 1;
    }


    /**
     * This method will open an output file and call a method to print the
     * summary report
     * @param inputFilePath The path of the input file
     */
    public void writeOutputFile(String inputFilePath) {

        String outputFilePath = properties.getProperty("output.dir")
                              + properties.getProperty("output.file.summary");

        try (PrintWriter summaryReport = new PrintWriter(
                new BufferedWriter(new FileWriter(outputFilePath)));
            )
        {

            createSummaryReport(summaryReport, inputFilePath);

        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    /**
     * This method will create a summary report on the anlaysis for the input
     * @param summaryReport The file path that PrintWriter opened
     * @param inputFilePath The path of the input file
     */
    public void createSummaryReport(PrintWriter summaryReport, String inputFilePath) {

        summaryReport.println("Application: "
                             + properties.getProperty("application.name"));
        summaryReport.println("Author: "
                             + properties.getProperty("author"));
        summaryReport.println("email: "
                             + properties.getProperty("author.email.address"));
        summaryReport.println("Input file: " + inputFilePath);
        summaryReport.println("Analyzed on: " + new Date());
        summaryReport.println("Total token count: " + getTotalTokensCount());
    }
}
