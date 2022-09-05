package currying_and_partial_evaluation;

import java.util.function.Function;

// You can curry a three-argument function by adding another level:
public class Curry3Args {
    public static void main(String[] args) {
        Function<String, Function<String, Function<String, String>>> sum = a -> b -> c -> a + b + c;

        Function<String, Function<String, String>> hi = sum.apply("Hi ");

        Function<String, String> ho = hi.apply("Ho ");

        System.out.println(ho.apply("Hup"));
    }

    //For each level of arrow-cascading, you wrap another Function around the type declaration.
}
