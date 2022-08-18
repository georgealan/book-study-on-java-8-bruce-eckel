package using_this_and_new;

/*
    It’s not possible to create an object of the inner class unless you already have an object
    of the outer class. This is because the object of the inner class is quietly connected to
    the object of the outer class it was made from. However, if you make a nested class
    (a static inner class), it doesn’t need a reference to the outer-class object.
 */

public class NewExample2 {
    class Contents {
        private int i = 11;
        public int value() { return i; }
    }
    static class StaticClassExample {} // Example can be created without outer-class reference.
    class Destination {
        private String label;

        Destination(String whereTo) {
            label = whereTo;
        }

        String readLabel() { return label; }
    }

    public static void main(String[] args) {
        NewExample2 ne = new NewExample2();
        // Here we must use instance of outer class to create an instance of the inner class.

        NewExample2.Contents c = ne.new Contents();
        NewExample2.Destination d = ne.new Destination("Brazil");

        // You don't need a reference to the outer-class object if the inner-class is static.
        StaticClassExample st = new StaticClassExample();
    }
}
