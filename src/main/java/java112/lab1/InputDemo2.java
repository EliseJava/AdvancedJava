package java112.lab1;


import java.io.*;


/**
 * @author Eric Knapp
 * class name
 */
public class InputDemo2 {

    public void run(String inputFilePath) {

       BufferedReader input = null;

       try {
           input = new BufferedReader(new FileReader(inputFilePath));

           while (input.ready()) {
            System.out.println(input.readLine());
           }

       } catch (FileNotFoundException fileNotFound) {
           fileNotFound.printStackTrace();
       } catch (IOException inputOutputException) {
           inputOutputException.printStackTrace();
       } catch (Exception exception) {
           exception.printStackTrace();
       } finally {
           try {
               if (input != null) {
               input.close();
               }
           } catch (Exception exception) {
               exception.printStackTrace();
           }

       }

    }
}
