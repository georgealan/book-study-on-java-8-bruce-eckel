package generics_and_typesafe_collections;

/*
    In this example, Apples and Oranges are placed into the collection, then pulled out.
    Normally, the Java compiler will give you a warning because the example does not
    use generics. Here, a special annotation is used to suppress the warning. Annotations
    start with an @ sign, and can take an argument; this one is @SuppressWarnings and
    the argument indicates that unchecked warnings only should be suppressed.

    The classes Apple and Orange are distinct; they have nothing in common except
    they are both Objects. (Remember that if you don’t explicitly say what class you’re
    inheriting from, you automatically inherit from Object.) ArrayList holds Objects
    so you can not only add Apple objects into this collection using the ArrayList
    method add(), but you can also add Orange objects without complaint at either
    compile time or runtime. When you go to fetch out what you think are Apple objects
    using the ArrayList method get(), you get back a reference to an Object you must
    cast to an Apple. Then you must surround the entire expression with parentheses to
    force the evaluation of the cast before calling the id() method for Apple; otherwise,
    you’ll get a syntax error.

    At runtime, when you try to cast the Orange object to an Apple, you get the error
    as shown in the output.
 */

import java.util.ArrayList;

class Apple {
    private static long counter;
    private final long id = counter++;
    public long id() { return id; }
}

class Orange {}

public class AppleAndOrangesWithoutGenerics {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList apples = new ArrayList();

        for (int i = 0; i < 3; i++) {
            apples.add(new Apple());
        }

        // No problem adding an Orange to Apples
        apples.add(new Orange());
        for (Object apple : apples) {
            ((Apple)apple).id();
            // Orange is detected only at runtime
        }
    }
}
