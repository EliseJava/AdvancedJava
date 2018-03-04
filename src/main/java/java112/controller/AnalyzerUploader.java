package java112.controller;

import java.io.*;
import java.util.*;
import java.net.*;
import java.nio.file.Paths;
import java.util.logging.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java112.javabackground.*;
import java112.analyzer.*;

/**
 * This servlet will upload a file and save it to a directory created in this
 * servlet, then run the File Ripper Reader application and store the
 * output.
 *
 *@author   Elise Strauss
 */
@MultipartConfig
@WebServlet(
    name = "UploadServlet",
    urlPatterns = {"/upload"}
)

public class AnalyzerUploader extends HttpServlet implements PropertiesLoaderInterface {

    private static final String WEB_PROPERTIES_FILE = "/webanalyzer.properties";
    private static final String KEYWORDS            = "/keywords.txt";
    private Properties properties;

    private static final Logger LOGGER =
            Logger.getLogger(AnalyzerUploader.class.getCanonicalName());


    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        // Create path components to save the file
        final String path = request.getParameter("destination");
        final Part filePart = request.getPart("file");
        final String fileName = getFileName(filePart);

        ServletContext context = request.getServletContext();
        context.setAttribute("realpath", path + "/big_words.txt");

        OutputStream out = null;
        InputStream filecontent = null;
        final PrintWriter writer = response.getWriter();

        try {
            out = new FileOutputStream(new File(path + File.separator
                    + fileName));

            filecontent = filePart.getInputStream();
            System.out.println("filecontent: " + filecontent);

            int read = 0;
            final byte[] bytes = new byte [1024];

            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            //writer.println("New file " + fileName + " created at " + path);
            LOGGER.log(Level.INFO, "File{0}being uploaded to {1}",
            new Object[] {fileName, path});

            runAnalyzer(path, fileName);

            String sumfile = properties.getProperty("output.dir")
                           + properties.getProperty("output.file.summary");
            File file1 = new File(sumfile);
            request.setAttribute("SumFilePath", file1.toURI());

            String bigfile = properties.getProperty("output.dir")
                           + properties.getProperty("output.file.bigwords");
            File file2 = new File(bigfile);
            request.setAttribute("BigFilePath", file2.toURI());

            String keyfile = properties.getProperty("output.dir")
                           + properties.getProperty("output.file.keyword");
            File file3 = new File(keyfile);
            request.setAttribute("KeyFilePath", file3.toURI());

            String countfile = properties.getProperty("output.dir")
                             + properties.getProperty("output.file.token.count");
            File file4 = new File(countfile);
            request.setAttribute("CountFilePath", file4.toURI());

            String sizefile = properties.getProperty("output.dir")
                            + properties.getProperty("output.file.token.size");
            File file5 = new File(sizefile);
            request.setAttribute("SizeFilePath", file5.toURI());

            String uniquefile = properties.getProperty("output.dir")
                              + properties.getProperty("output.file.unique");
            File file6 = new File(uniquefile);
            request.setAttribute("UniqueFilePath", file6.toURI());

            String url = "/analyzer-display-output.jsp";

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);

        } catch (FileNotFoundException fne) {
            writer.println("You either did not specify a file to upload or are "
            + "trying to upload a file to a protected or nonexistent "
            + "location.");
            writer.println("<br/> ERROR: " + fne.getMessage());

            LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}",
            new Object[] {fne.getMessage()});
        } finally {
            if (out != null) {
                out.close();
            }
            if (filecontent != null) {
                filecontent.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
    }

    /**
     * This method will return the file name
     * @param part the Part
     * @return null
     */
    private String getFileName(final Part part) {

        final String partHeader = part.getHeader("content-disposition");

        LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);

        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=')
                        + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

    /**
     * This method will run the File Ripper Reader application
     * @param path the path
     * @param fileName the file name
     */
    public void runAnalyzer(String path, String fileName) {

            AnalyzeFile analyzer = new AnalyzeFile();
            File file = createDirectoryOutput(path);
            String output = file.getAbsolutePath();
            String outputDirectory = output + "/";

            URL url = getClass().getResource(KEYWORDS);
            //String keywordsFilePath = url.toExternalForm();
            String keywordsFilePath = url.getPath();

            updatePropertiesFile(outputDirectory, keywordsFilePath);

            String[] arguments = {path + "/" + fileName, WEB_PROPERTIES_FILE};
            analyzer.runAnalysis(arguments);
    }


    /**
     * This method will create the output directory
     * @param path The path
     * @return theDirectory The directory
     */
    public File createDirectoryOutput(String path) {

        File theDirectory = new File(path + "/analyzer");
        System.out.println("theDirectory: " + theDirectory);

        // if the directory does not exist, create it
        if (!theDirectory.exists()) {

            boolean result = false;

            try {
                theDirectory.mkdir();
                result = true;
            }
            catch(SecurityException securityException){
                securityException.printStackTrace();
            }
        }

        return theDirectory;
     }

     /**
      * This method will create a new properties file with the file locations
      * @param keywordsFilePath The path to the keywords.txt file
      * @param outputDirectory  Where the reports must go
      */
     public void updatePropertiesFile(String outputDirectory, String keywordsFilePath) {

         FileOutputStream stream = null;
         properties = loadProperties(WEB_PROPERTIES_FILE);

         try {

             URL url = this.getClass().getResource(WEB_PROPERTIES_FILE);
             stream = new FileOutputStream(new File(url.toURI()));

             properties.setProperty("output.dir", outputDirectory);
             properties.setProperty("file.path.keywords", keywordsFilePath);
             properties.store(stream, "Modified web version of analyzer properties file");

        } catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();

        } catch (URISyntaxException uriSyntaxException) {
            uriSyntaxException.printStackTrace();

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();

        } catch (IOException ioException) {
            ioException.printStackTrace();

        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }
}
