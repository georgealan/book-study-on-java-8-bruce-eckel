package optional.convenience_functions;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

/*
There are a number of convenience functions for unpacking Optionals, which
simplifies the above process of checking and doing something with the contained
object:

• ifPresent(Consumer): Call the Consumer with the value if it’s there, otherwise do nothing.
• orElse(otherObject): Produce the object if it’s there, otherwise produce otherObject.
• orElseGet(Supplier): Produce the object if it’s there, otherwise produce a replacement
object using the Supplier function.
• orElseThrow(Supplier): Produce the object if it’s there, otherwise produce
an exception using the Supplier function.

Here are simple demonstrations for the different convenience functions:
 */
public class Optionals {
    static void basics(Optional<String> optString) {
        if (optString.isPresent()) {
            System.out.println(optString.get());
        } else {
            System.out.println("Nothing inside!");
        }
    }

    static void ifPresent(Optional<String> optString) {
        optString.ifPresent(System.out::println);
    }

    static void orElse(Optional<String> optString) {
        System.out.println(optString.orElse("Nothing"));
    }

    static void orElseGet(Optional<String> optString) {
        System.out.println(optString.orElseGet(() -> "Generated"));
    }

    static void orElseThrow(Optional<String> optString) {
        try {
            System.out.println(optString.orElseThrow(() -> new Exception("Supplied")));
        } catch (Exception e) {
            System.out.println("Caught " + e);
        }
    }

    static void test(String testName, Consumer<Optional<String>> cos) {
        System.out.println(" === " + testName + " === ");
        cos.accept(Stream.of("Epithets").findFirst());
        cos.accept(Stream.<String>empty().findFirst());
    }

    public static void main(String[] args) {
        test("basics", Optionals::basics);
        test("ifPresent", Optionals::ifPresent);
        test("orElse", Optionals::orElse);
        test("orElseGet", Optionals::orElseGet);
        test("orElseThrow", Optionals::orElseThrow);
    }
}
