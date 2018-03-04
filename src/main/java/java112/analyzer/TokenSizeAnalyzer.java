package java112.analyzer;

import java.io.*;
import java.util.*;


/**
  * This class will determine the size distribution of the tokens passed to it
  * from the input file
  * @author Elise Strauss
  * class TokenSizeAnalyzer
  */
public class TokenSizeAnalyzer implements Analyzer {

    private static final int MAX_HISTOGRAM_BAR = 76;
    private Properties properties;
    private Map<Integer, Integer> tokenSizes;
    private int maximumSize;


    /**
     * Empty Constructor for TokenSizeAnalyzer
     */
    public TokenSizeAnalyzer() {
        tokenSizes = new TreeMap<Integer, Integer>();
    }


    /**
     * Basic constructor for TokenSizeAnalyzer
     * @param properties The Properties object loaded with input file from
     *                   the config directory
     */
    public TokenSizeAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }


    /**
      * This is the get method and will return the tokensizes Map
      * @return tokenSizes The Map with counts
      */
    public Map<Integer, Integer> getTokenSizes() {
        return tokenSizes;
    }

    /**
      * Get method for maximumSize
      * @return maximumSize
      */
    public int getMaximumSize() {
        return maximumSize;
    }

    /**
      * This method will count the length of incoming tokens.  Unique token
      * lenghts will be the Key of the Map and the number of times they occur will
      * be written as the Value of the Map.
      * @param token The input token from the input file from the command line.
      */
    public void processToken(String token) {

        int length = token.length();

        if (tokenSizes.containsKey(length)) {
            Integer newValue = (tokenSizes.get(length) + 1);
            tokenSizes.replace(length, newValue);
        } else {
            tokenSizes.put(length, 1);
        }
    }

    /**
      * This method will loop thru the Map and print each entry
      * @param inputFilePath The file to write the output to
      */
    public void writeOutputFile(String inputFilePath) {

        try (
            PrintWriter printSizeFile = new PrintWriter(new BufferedWriter(
                    new FileWriter(properties.getProperty("output.dir")
                    + properties.getProperty("output.file.token.size"))));) {

            writeUniqueLengthCount(printSizeFile);
            writeHistogram(printSizeFile);

        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    /**
      * This method will loop thru Map and output each entry to output file
      * @param printSizeFile The output file
      */
    public void writeUniqueLengthCount(PrintWriter printSizeFile) {

        for (Map.Entry<Integer, Integer> mapEntry : tokenSizes.entrySet()) {

            printSizeFile.println( mapEntry.getKey()
                    + "\t"
                    + mapEntry.getValue());
        }
    }

    /**
      * This method will create a scaled histogram of the Map entries
      * @param printSizeFile The output file
      */
    public void writeHistogram(PrintWriter printSizeFile) {

        float asteriskScale = 0;
        int   asteriskCount = 0;
        int maximumSize = tokenSizes.values().stream().max(Integer::compare).get();

        asteriskScale = (float) maximumSize / MAX_HISTOGRAM_BAR;

        printSizeFile.println();

        for (Map.Entry<Integer, Integer> mapEntry : tokenSizes.entrySet()) {

            printSizeFile.print(mapEntry.getKey() + "\t");

            asteriskCount = (int) (mapEntry.getValue() / asteriskScale);

            if (asteriskCount == 0) {
                asteriskCount = 1;
            }

            writeEachHistogramBar(printSizeFile, asteriskCount);

            printSizeFile.println();
        }
    }

    /**
      * This method will print a line of asterisk depending on a count
      * @param printSizeFile The name of the File
      * @param asteriskCount The scaled number of asterisks to print
      */
    public void writeEachHistogramBar(PrintWriter printSizeFile,
                                      int asteriskCount)   {

            for (int counter = 0; counter < asteriskCount; counter++) {
                printSizeFile.print("*");
            }
    }
}
