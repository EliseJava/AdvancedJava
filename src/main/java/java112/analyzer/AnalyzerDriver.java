package java112.analyzer;


/**
 * This is the driver class for the FileRipperReader application
 *
 * @author Elise Strauss
 * class AnalyzerDriver
 */
public class AnalyzerDriver {

    /**

    * This is the driver for the FileRipperReader Application
     * @param arguments The command line arguments.
     */
    public static void main(String[] arguments) {

        AnalyzeFile analyzer = new AnalyzeFile();
        analyzer.runAnalysis(arguments);
    }
}

