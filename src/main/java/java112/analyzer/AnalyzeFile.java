package java112.analyzer;


import java.io.*;
import java.util.*;
import java112.javabackground.*;


/** The FileRipperReader application is a command line application which will
 *  process a text file and output analysis results on the contents of the file:
 *
 * - The summary report will print a summary of the anlysis that was performed on
 *   the input file.
 * - The unique tokens output file will contain a list of all unique tokens.
 * - The token count output takes count of all unique token
 * - The Big word output file will list all word greater or equal to 18 char
 *
 * @author Elise Strauss
 * class AnalyzeFile
 */
public class AnalyzeFile implements PropertiesLoaderInterface {

    private static final int VALID_COMMAND_LINE_ARGUMENT_COUNT = 2;
    private String inputFilePath;
    private Properties properties;
    private List<Analyzer> analyzers;

    /**
     * This method will perform a check that 2 arguments were entered on the
     * command line
     * @param arguments  The command line arguments
     */
    public void runAnalysis(String[] arguments) {

        System.out.println("argument: " + arguments[0]);
        System.out.println("argument: " + arguments[1]);
        if (arguments.length != VALID_COMMAND_LINE_ARGUMENT_COUNT) {
            System.out.println("Please enter the file path to analyze.");
            return;
        }

        inputFilePath = arguments[0];
        System.out.println("Elise inputFilePath: " + inputFilePath);

        properties = loadProperties(arguments[1]);

        createAnalyzers();
        readInputFile();
        writeAllOutputFiles();
    }


    /**
     * This method will open an input file that was entered on the command line
     * and call a method to process the file until the end.  It will also
     * instantiate 2 classes.
     */
    public void createAnalyzers() {

        analyzers = new ArrayList<Analyzer>();
        analyzers.add(new SummaryReport(properties));
        analyzers.add(new UniqueTokenAnalyzer(properties));
        analyzers.add(new BigWordAnalyzer(properties));
        analyzers.add(new TokenCountAnalyzer(properties));
        analyzers.add(new TokenSizeAnalyzer(properties));
        analyzers.add(new KeywordAnalyzer(properties));
    }


    /**
      * This method will read the input file from the command line
      */
    public void readInputFile() {
        try (BufferedReader readInputFile = new BufferedReader(
                new FileReader(inputFilePath));) {

            processInputStreams(readInputFile);

        } catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        }
        catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    /**
     * This method will process each input stream read from the input file and
     * assign it to an array to create individual tokens.  The array will be
     * sent to the processToken() method for processing.
     *
     * @param readInputFile The input file path that was entered on the command line
     * @throws IOException  If an input or output exception ocurred
     */
    public void processInputStreams(BufferedReader readInputFile)
            throws IOException {

        String textLine = null;
        String[] textTokenArray = null;

        while (readInputFile.ready()) {
            textLine = readInputFile.readLine();
            textTokenArray = textLine.split("\\W");

            processTokens(textTokenArray);
        }
    }

   /**
     * This method will count all the tokens in the array passed.
     * @param textTokenArray a primitive array of Strings that holds an input stream
     */
    public void processTokens(String[] textTokenArray) {

        for (String token : textTokenArray) {

           if (!token.isEmpty()) {
               forEachAnalyzer(token);
            }
        }
    }


    /**
     * This method will process an array of Strings
     * @param token The token from the input file
     */
    public void forEachAnalyzer(String token) {

        for (Analyzer analyzerFile : analyzers) {

            analyzerFile.processToken(token);
        }
    }


   /**
     * This method will write all the output files for this application
     */
    public void writeAllOutputFiles() {

        for (Analyzer analyzerFile : analyzers) {
             analyzerFile.writeOutputFile(inputFilePath);

        }
    }
}
