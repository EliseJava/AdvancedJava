package java112.lab1;

/**
 * @author Eric Knapp
 * class name
 */
public class MysteryClassOne {
   
    /**
     * Run the demo
     */
    public void run() {
        System.out.println("Hi");
        
    }
    
    public int mysteryMethodOne() {
        int test = 1;
        return test;
    }
    
    /**
     * The start of the program
     * @param arguments The command line arguments.
     */
    public static void main(String[] arguments) {
        MysteryClassOne demo = new MysteryClassOne(); 
        demo.run();
    }
    
}
