package java112.javabackground;

/** This class is used to increment a value that will be used to update
  * the value in a Map that is of type Counter
  * @author Elise Strauss
  * class Counter
  */
public class Counter {

    private int value;

    /**
     * Constructor for Counter
     */
    public Counter() {
        value = 1;
    }

    /**
      * The get method
      * @return value The value added 1
      */
    public int getCounter() {
        return value;
    }

    /** This method will add one to the value
      *
      */
    public void increment() {
        value += 1;
    }
}