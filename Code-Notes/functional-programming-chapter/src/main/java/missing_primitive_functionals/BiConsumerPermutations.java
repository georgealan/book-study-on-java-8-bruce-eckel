package missing_primitive_functionals;

import java.util.function.BiConsumer;

public class BiConsumerPermutations {
    static BiConsumer<Integer, Double> bicid = (i, d) -> System.out.format("%d, %f%n", i, d);
    static BiConsumer<Double, Integer> bicdi = (d, i) -> System.out.format("%d, %f%n", i, d);
    static BiConsumer<Integer, Long> bicil = (i, l) -> System.out.format("%d, %d%n", i, l);

    public static void main(String[] args) {
        bicid.accept(47, 11.34);
        bicdi.accept(22.45, 92);
        bicil.accept(1, 11L);
    }

    /*
    For display, I use System.out.format() which is like System.out.println()
    except it provides far more display options. Here, %d says that I’m giving it i to be
    displayed as an integral value and %f says that the corresponding argument d should
    be displayed as a floating-point value. I’m able to include spaces, and it doesn’t add
    a newline unless you put in a %n—it will also accept the traditional \n for newlines,
    but %n is automatically cross-platform, which is another reason to use format().

    The example uses the appropriate wrapper types, and boxing and unboxing converts
    back and forth between primitives.
     */
}
