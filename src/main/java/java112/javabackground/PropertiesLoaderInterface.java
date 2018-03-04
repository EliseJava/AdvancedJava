package java112.javabackground;

import java.io.*;
import java.util.*;

/**
 * This interfaces function is to ????
 * to write an output file
 * @author Elise Strauss
 * interface PropertiesLoaderInterface
 */

public interface PropertiesLoaderInterface {

    default Properties loadProperties(String propertiesFilePath) {

        Properties properties = new Properties();

        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
        } catch(IOException inputOutputException) {
            inputOutputException.printStackTrace();
            return null;
        } catch(Exception exception) {
            exception.printStackTrace();
            return null;
        }
        return properties;
    }
}