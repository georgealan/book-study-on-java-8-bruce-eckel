package currying_and_partial_evaluation;

import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

public class CurriedIntAdd {
    public static void main(String[] args) {
        IntFunction<IntUnaryOperator> curriedIntAdd = a -> b -> a + b;

        IntUnaryOperator add4 = curriedIntAdd.apply(4);
        System.out.println(add4.applyAsInt(5));
    }

    /*
    You can find more examples of currying on the Internet. Usually these are in
    languages other than Java, but if you understand the basic concepts they should be
    fairly easy to translate.
     */
}
