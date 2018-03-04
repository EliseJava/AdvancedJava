package java112.lab2;

import java.io.*;
import java.util.*;

import java112.javabackground.*;

/**
 * @author Eric Knapp
 * class Properties2
 */
public class Properties2 implements PropertiesLoaderInterface {

    private Properties properties;

    /**
     * Run the demo
     */
    public void run() {
        properties = loadProperties("/lab2-3.properties");

        String author = properties.getProperty("author");

        System.out.println("author: " + author);
    }

    /**
     * The start of the program
     * @param arguments The command line arguments.
     */
    public static void main(String[] arguments) {
        Properties2 demo = new Properties2();
        demo.run();
    }

}






