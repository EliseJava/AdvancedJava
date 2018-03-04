package java112.lab2;

import java.util.*;

/**
 * @author Eric Knapp
 * class MapDemo
 */
public class MapDemo {


    /**
     * Run the demo
     */
    public void run() {
        Map<String, Integer> map = new TreeMap<String, Integer>();

        map.put("one", new Integer(1));
        map.put("two", new Integer(2));
        map.put("three", new Integer(3));
        map.put("four", new Integer(4));
        map.put("five", 5);

        Integer one = new Integer(1);
        Integer two = new Integer(2);

        int total = one + two;

        System.out.println("total: " + total);

        System.out.println();
        System.out.println(map);
        System.out.println();

        System.out.println(map.get("two"));

        System.out.println();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("key: " + entry.getKey() + ", value: "
                    + entry.getValue());
        }



    }

    /**
     * The start of the program
     * @param arguments The command line arguments.
     */
    public static void main(String[] arguments) {
        MapDemo demo = new MapDemo();
        demo.run();
    }

}
