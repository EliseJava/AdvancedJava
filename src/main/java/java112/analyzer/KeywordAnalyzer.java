package java112.analyzer;

import java.io.*;
import java.util.*;

/**
 * This class will determine positioning of keywords in a input file.
 *
 * @author Elise Strauss
 * class KeywordAnalyzer
 */
public class KeywordAnalyzer implements Analyzer {

    private Map<String, List <Integer>> keywordMap;
    private Properties properties;
    private int tokenOccurrence;


    /**
     * Empty constructor for KeywordAnalyzer
     */
    public KeywordAnalyzer() {
        keywordMap = new TreeMap<String, List <Integer>>();
    }


    /**
     * Basic constructor for KeywordAnalyzer
     * @param properties The properties file
     */
    public KeywordAnalyzer(Properties properties) {
        this();
        this.properties = properties;

        readKeyWordsFile();
    }


    /**
     * This method will read a keyword file and create a Map with the keywords
     * as keys
     */
    public void readKeyWordsFile() {

        try (BufferedReader keywordFile = new BufferedReader(new FileReader
                    (properties.getProperty("file.path.keywords")));) {

            processKeyword(keywordFile);

        } catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    /**
     * This method will initialize the Map keys with the keyword from the
     * input file
     * @param keywordFile The input keywords
     * @throws IOException The input output exception
     */
    public void processKeyword(BufferedReader keywordFile) throws IOException {

        String testStream = "";

        while (keywordFile.ready()) {

            testStream = keywordFile.readLine();
            buildKeywordMap(testStream);
        }
    }

    /**
     * This method will build the keyword Map
     * @param testStream The input line stream
     */
    public void buildKeywordMap(String testStream) {

        if (!testStream.isEmpty()) {
            keywordMap.put(testStream, new ArrayList<Integer>());
        }
    }


    /** This method will return the map
     * @return The map with keywords and their position in the input file
     */
    public Map<String, List <Integer>> getKeywordMap() {
        return keywordMap;
    }


    /** This method will check if the token is a keyword then it will record
     * the occurence in the file
     * @param token The token from the input file
     */
    public void processToken(String token) {

        tokenOccurrence += 1;

        if (keywordMap.containsKey(token)) {

            //autoboxing happening when adding occurence
            keywordMap.get(token).add(tokenOccurrence);
        }
    }


    /**
     * This method will format and write the Map to an output file
     * @param inputFilePath The input file from the command line
     */
    public void writeOutputFile(String inputFilePath) {

        try (PrintWriter keywordCount = new PrintWriter(new BufferedWriter(
                     new FileWriter(properties.getProperty("output.dir")
                     + properties.getProperty("output.file.keyword"))));) {

            formatMapOutput(keywordCount);

        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    /** This method will print the content of the Map.  The List of Integers
     * will be converted to a String[]
     * @param keywordCount The file to write the output to
     */
    public void formatMapOutput(PrintWriter keywordCount) {

        String listKeyword = null;
        String[] listKeywordArray = null;

        for (Map.Entry <String, List <Integer>> mapEntry : keywordMap.entrySet()) {

            //print map key
            keywordCount.println(mapEntry.getKey() + " " + "=");

            //process map value
            listKeyword = mapEntry.getValue().toString();
            listKeywordArray = listKeyword.split(" ");

            chopUpPrintLine(listKeywordArray, keywordCount);

            keywordCount.println();
            keywordCount.println();
        }
    }


    /**
     * This method will loop the the listKeywordArray
     * @param listKeywordArray The array of that hold all the keyword
     *                         positioning counts
     * @param keywordCount     The printwriter
     */
    public void chopUpPrintLine(String[] listKeywordArray,
                                PrintWriter keywordCount) {

        int lineCounter = 0;
        int countTheSpace = 1;
        int countAhead = 0;
        boolean printNewLine = false;
        boolean lastIndex = false;
        int nextIndex = 0;
        int size = 0;

        for (int index = 0; index < listKeywordArray.length; index++) {

            if (listKeywordArray[index].contains("]")) {
                lastIndex = true;
            }

            size = listKeywordArray[index].length();

            if (countAhead == 80) {
                lineCounter = countAhead;
            } else {
                lineCounter += size + countTheSpace;
            }

            if (lineCounter > 80) {
                printNewLine = true;
                lineCounter = size + countTheSpace;
            } else {
                keywordCount.print(listKeywordArray[index]);
            }

            if (!lastIndex) {

                nextIndex = index;
                nextIndex += 1;
                countAhead = lineCounter + listKeywordArray[nextIndex].length();
            } else {
                countAhead = lineCounter;
            }

            if ((!lastIndex) && (countAhead <= 80)) {
                keywordCount.print(" ");
            }

            if (printNewLine || countAhead > 80) {
                keywordCount.println();
                lineCounter = 0;
                printNewLine = false;
                countAhead = 0;
            }
        }
    }
}
