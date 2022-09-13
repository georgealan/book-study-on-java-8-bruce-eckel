package intermediate_operations.applying_function_to_every_element;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

/*
• map(Function): Applies Function to every object in the input stream, passing on the result values as the output stream.
• mapToInt(ToIntFunction): As above, but results in an IntStream.
• mapToLong(ToLongFunction): As above, but results in a LongStream.
• mapToDouble(ToDoubleFunction): As above, but results in a DoubleStream.
 */
public class FunctionMap {
    static String[] elements = { "12", "", "23", "45" };
    static Stream<String> testStream() {
        return Arrays.stream(elements);
    }
    static void test(String descr, Function<String, String> func) {
        System.out.println(" ---( " + descr + " )--- ");
        testStream()
                .map(func)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        test("add brackets", s -> "[" + s + "]");

        test("Increment", s -> {
            try {
                return Integer.parseInt(s) + 1 + "";
            } catch (NumberFormatException e) {
                return s;
            }
        });

        test("Replace", s -> s.replace("2", "9"));

        test("Take last digit", s -> s.length() > 0 ? s.charAt(s.length() - 1) + "" : s);
    }
}

/*
In the "Increment" test, we use Integer.parseInt() to attempt to turn the String
into an Integer. If the String can’t be represented as an Integer it throws a
NumberFormatException and we just fall back to putting the original String back
on the output stream.

In the above example, the map() maps from a String to a String, but there’s no
reason you can’t produce a different type than you take in, thus changing the type
of the stream from that point on.
 */
