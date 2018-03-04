package java112.analyzer;


import java.io.*;
import java.util.*;
import java112.javabackground.*;

/**
  * This class will write unique token to an output file with a count on how many times
  * they occured.
  * @author Elise Strauss
  * class TokenCountAnalyzer
  */
public class TokenCountAnalyzer implements Analyzer {

    private Properties properties;
    private Map<String, Counter> tokenCounts;

    /**
     * Empty Constructor
     */
    public TokenCountAnalyzer() {
        tokenCounts = new TreeMap<String, Counter>();
    }


    /**
     * Basic constructor for
     * @param properties The Properties object loaded with the properties file
     *                   from the config directory
     */
    public TokenCountAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }

    /**
      * This is the get method
      * @return tokenCounts
      */
    public Map getTokenCounts() {
        return tokenCounts;
    }


    /**
     * This method will check for entries in a map.  If the token is already
     * in the map it will add 1 to the value count, otherwise a new entry
     * will be added to the map.
     * @param token  The input file tokens
     */
    public void processToken(String token) {

       if (tokenCounts.containsKey(token)) {
          //This code is causing boxing and unboxing
          //Integer newValue = (tokenCounts.get(token) + 1);
          //tokenCounts.replace(token, newValue);

          tokenCounts.get(token).increment();

       } else {

         tokenCounts.put(token, new Counter());
       }
    }

    /**
     * This method will loop thru the Set Collections object and will write
     * each element to the output file line by line.
     * @param inputFilePath  The file to write the token to.
     */
    public void writeOutputFile(String inputFilePath) {

        try (
            PrintWriter printToken = new PrintWriter(new BufferedWriter(
                new FileWriter(properties.getProperty("output.dir")
                             + properties.getProperty("output.file.token.count"))));
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

       for (Map.Entry<String, Counter> mapEntry : tokenCounts.entrySet()) {

           printToken.println(mapEntry.getKey()
                             + "\t"
                             + mapEntry.getValue().getCounter());
       }
    }
}
