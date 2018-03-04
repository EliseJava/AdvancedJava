package java112.lab1;

import java.util.*;
/**
 * @author Eric Knapp
 * class name
 */
public class ListDemo2 {

    /**
     * Run the demo
     */
    public void run() {
        List<String> list = new ArrayList();

        list.add("one");
        list.add("two");
        list.add("three");

        System.out.println();
        System.out.println(list);

        for (String word : list) {
            System.out.println(word);
        }

        Set set = new TreeSet(list);
        System.out.println(set);
    }


    /**
     * The start of the program
     * @param arguments The command line arguments.
     */
    public static void main(String[] arguments) {
        ListDemo2 demo = new ListDemo2();
        demo.run();
    }
}
