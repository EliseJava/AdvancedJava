package java112.analyzer;


import java.io.*;
import java.util.*;


/** This class will produce an output file of words greater or equal to 18 chars
  * @author Elise Strauss
  * class BigWordAnalyzer
  */
public class BigWordAnalyzer implements Analyzer {

    private Properties properties;
    private Set<String> bigWords;
    private int minimumWordLength;

    /**
     * Empty Constructor
     */
    public BigWordAnalyzer() {
        bigWords = new TreeSet<String>();
    }


    /**
     * Basic constructor for that will populate the properties files
     * @param properties The properties files in the config directory
     */
    public BigWordAnalyzer(Properties properties) {
        this();
        this.properties = properties;
        minimumWordLength = Integer.parseInt(properties.getProperty
                            ("bigwords.minimum.length"));
    }


    /**
      * This is the get method for the Set of Big words
      * @return bigWords The Set of big words
      */
    public Set getBigWords() {
        return bigWords;
    }

   /**
     * This method will call a method to write the token to a output file
     * if greater or equal to 18 characters
     * @param token The token from the input file
     */
    public void processToken(String token) {

        if (token.length() >= minimumWordLength) {
            bigWords.add(token);
        }
    }


    /**
      * This method will open a file to write the tokens
      * @param inputFilePath The input file that was entered on the command line
      */
    public void writeOutputFile(String inputFilePath) {

        String outputFilePath = properties.getProperty("output.dir")
                              + properties.getProperty("output.file.bigwords");

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

        for (String token : bigWords) {
            printToken.println(token);
        }
    }
}
