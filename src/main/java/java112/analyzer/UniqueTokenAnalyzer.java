package java112.analyzer;


import java.io.*;
import java.util.*;


/**
  * This class will will create a list of unique tokens from the input file
  * @author Elise Strauss
  * class UniqueTokenAnalyzer
  */
public class UniqueTokenAnalyzer implements Analyzer {

    private Set<String> uniqueTokensList;
    private Properties properties;


    /**
     * Constructor to instantiate a Set collections object
     */
    public UniqueTokenAnalyzer() {
        uniqueTokensList = new TreeSet<String>();
    }


    /**
      * Constructor with one Properties parameter
      * @param properties The Properties object loaded with the properties file
      *                   in the config directory
      */
    public UniqueTokenAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }


    /**
     * This method will return the Set collections object
     * @return uniqueTokensList  The collections Set of unique tokens
     */
    public Set getUniqueTokensList() {
        return uniqueTokensList;
    }


    /**
     * This method will add each inidivual token to the Set collecions object
     * when it not empty
     * @param token The individual token from the input file
     */
    public void processToken(String token) {

        uniqueTokensList.add(token);
    }


    /**
     *  This method will open an output file and call a method to write the Set
     * collections object to it
     * @param inputFilePath   The input file path
     */
    public void writeOutputFile(String inputFilePath) {

        String outputFilePath = properties.getProperty("output.dir")
                              + properties.getProperty("output.file.unique");

        try (
            PrintWriter printToken = new PrintWriter(new BufferedWriter(
                new FileWriter(outputFilePath)));
            )
        {

            writeUniqueTokenToFile(printToken);

        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    /**
     * This method will loop thru the Set Collections object and will write
     * each element to the output file line by line.
     * @param printToken  The file to write the token to.
     */
    public void writeUniqueTokenToFile(PrintWriter printToken) {

        for (String token : uniqueTokensList) {
            printToken.println(token);
        }
    }
}
