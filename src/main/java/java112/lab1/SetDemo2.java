package java112.lab1;

import java.util.*;
/**
 * @author Eric Knapp
 * class name
 */
public class SetDemo2 {
    
    
    /**
     * Run the demo
     */
    public void run() {
        //change to HashSet
        Set<String> set = new TreeSet<String>();        
        set.add("one");
        set.add("two");
        set.add("three");
        set.add("four");
        set.add("five");
        set.add("four");  
        set.add("four");
        
        System.out.println();
        System.out.println(set);
        System.out.println();
        
        
        for (String word : set) {
            System.out.println(word);
        }
    }
    
    /**
     * The start of the program
     * @param arguments The command line arguments.
     */
    public static void main(String[] arguments) {
        SetDemo2 demo = new SetDemo2();
        demo.run();
    }
    
}
