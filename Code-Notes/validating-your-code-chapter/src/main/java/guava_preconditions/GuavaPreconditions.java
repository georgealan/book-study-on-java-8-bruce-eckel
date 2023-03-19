package guava_preconditions;

import java.util.function.Consumer;
import static com.google.common.base.Preconditions.*;

/*
    Google’s Guava library incorporates a nice set of precondition tests that are not only
    easy to use, but also descriptively well-named. Here you see simple usages of all of
    them. The library designers recommend you import the preconditions statically
 */
public class GuavaPreconditions {
    static void test(Consumer<String> c, String s) {
        try {
            System.out.println(s);
            c.accept(s);
            System.out.println("Success");
        } catch (Exception e) {
            String type = e.getClass().getSimpleName();
            String message = e.getMessage();
            System.out.println(type + (message == null ? "" : ": " + message));
        }
    }

    public static void main(String[] args) {
        System.out.println("checkNotNull() Method");
        test(s -> s = checkNotNull(s), "X");
        test(s -> s = checkNotNull(s), null);
        test(s -> s = checkNotNull(s, "s was null"), null);
        // Note that checkNotNull() returns its argument, so you can use it inline in an expression.
        test(s -> s = checkNotNull(s, "s was null, %s %s", "arg2", "arg3"), null);

        System.out.println("\ncheckArgument() Method");
        test(s -> checkArgument(s == "Fozzie"), "Fozzie");
        test(s -> checkArgument(s == "Fozzie"), "X");
        test(s -> checkArgument(s == "Fozzie"), null);
        test(s -> checkArgument(s == "Fozzie", "Bear left! %s Right!", "Frog"), null);
        test(s -> checkArgument(s == "Fozzie", "Bear left! %s Right!", "Frog"), null);

        System.out.println("\ncheckState() Method");
        test(s -> checkState(s.length() > 6), "Mortimer");
        test(s -> checkState(s.length() > 6), "Mort");
        test(s -> checkState(s.length() > 6), null);

        System.out.println("\ncheckElementIndex() Method");
        test(s -> checkElementIndex(5, s.length()), "Robert");
        test(s -> checkElementIndex(6, s.length()), "Bob");
        test(s -> checkElementIndex(6, s.length()), null);

        System.out.println("\ncheckPositionIndex() Method");
        test(s -> checkPositionIndex(6, s.length()), "Robert");
        test(s -> checkPositionIndex(6, s.length()), "Bob");
        test(s -> checkPositionIndex(6, s.length()), null);

        System.out.println("\ncheckPositionIndexes() Method");
        test(s -> checkPositionIndexes(0, 6, s.length()), "Hieronymus");
        test(s -> checkPositionIndexes(0, 10, s.length()), "Hieronymus");
        test(s -> checkPositionIndexes(0, 11, s.length()), "Hieronymus");
        test(s -> checkPositionIndexes(-1, 6, s.length()), "Hieronymus");
        test(s -> checkPositionIndexes(7, 6, s.length()), "Hieronymus");
        test(s -> checkPositionIndexes(0, 6, s.length()), null);
    }
}
