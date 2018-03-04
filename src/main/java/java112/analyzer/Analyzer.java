package java112.analyzer;


/**
 * This interface has 2 methods, one that should process a token and the other
 * to write an output file
 * @author Elise Strauss
 * interface Analyzer
 */
public interface Analyzer {

    /** This is an abstract method that will process a token
     * @param token The input token
     */
    public void processToken(String token);


    /** This is an abstract method that will be used the write an output file
     * @param inputFilePath    The input file path name
     */
    public void writeOutputFile(String inputFilePath);
}
