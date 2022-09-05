package currying_and_partial_evaluation;

import java.util.function.Function;

public class CurryingAndPartials {
    // Uncurried
    static String uncurried(String a, String b) {
        return a + b;
    }

    public static void main(String[] args) {
        // Curried function
        Function<String, Function<String, String>> sum = a -> b -> a + b; // [1]

        System.out.println(uncurried("Hi ", "George"));

        Function<String, String> hi = sum.apply("Hi ");  // [2]
        System.out.println(hi.apply("George"));

        // Partial application
        Function<String, String> sumHi = sum.apply("Hup ");
        System.out.println(sumHi.apply("Ho"));
        System.out.println(sumHi.apply("Hey"));
    }

    /*
    • [1] This is the tricky line: a cascade of arrows. And notice how, in the function
    interface declaration, Function has another Function as its second argument.

    • [2] The goal of currying is to be able to create a new function by providing a
    single argument, so you now have an "argumented function" and the remaining
    "free argument." In effect, you start with a two-argument function and end up
    with a one-argument function.
     */
}
