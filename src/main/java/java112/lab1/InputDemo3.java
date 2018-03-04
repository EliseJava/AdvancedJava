package java112.lab1;

import java.io.*;

/** 
 * @author Elise Strauss
 * class InputDemo3
 */

public class InputDemo3 {
        private String fileName;
        private String fileMessage;

        PrintWriter newFile;

        public void run(String[] arguments) throws IOException {

            fileName = arguments[0];
            fileMessage = arguments[1];

            newFile = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
            newFile.print("This is my first Java file written");
            newFile.println(fileMessage);
            newFile.println("That feels good huh?");
            newFile.close();
        }
}