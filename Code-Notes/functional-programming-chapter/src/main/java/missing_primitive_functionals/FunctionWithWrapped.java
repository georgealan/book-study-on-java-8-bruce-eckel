package missing_primitive_functionals;

import java.util.function.Function;
import java.util.function.IntToDoubleFunction;

public class FunctionWithWrapped {
    public static void main(String[] args) {
        Function<Integer, Double> fid = i -> (double)i;
        IntToDoubleFunction fid2 = i -> i;
    }

    /*
    Without the cast, you get an error message: Integer cannot be converted to Double,
    whereas the IntToDoubleFunction version has no such problem.

    Because we can simply write Function<Integer,Double> and produce working
    results, it’s clear that the only reason for the primitive variants of the functionals is
    to prevent the autoboxing and autounboxing involved with passing arguments and
    returning results. That is, for performance.

    It seems safe to conjecture that the reason some functional types have
    definitions and others don’t is because of projected frequency of use.

    Of course, if performance becomes a problem because of a missing primitive
    functional, you can easily write your own interface using the Java library sources
    for reference—although it seems unlikely this is your actual performance bottleneck.
     */
}
