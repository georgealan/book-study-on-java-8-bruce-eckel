package optional.operations_on_optional_objects;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class OptionalFilter {
    static String[] elements = { "Foo", "", "Bar", "Baz", "Bingo" };
    static Stream<String> testStream() {
        return Arrays.stream(elements);
    }
    static void test(String descr, Predicate<String> pred) {
        System.out.println(" ---( " + descr + " )---");
        for (int i = 0; i <= elements.length; i++) {
            System.out.println(testStream()
                    .skip(i)
                    .findFirst()
                    .filter(pred));
        }
    }

    public static void main(String[] args) {
        test("true", str -> true);
        test("false", str -> false);
        test("str != \"\"", str -> str != "");
        test("str.lenght() == 3", str -> str.length() == 3);
        test("startsWith(\"B\")", str -> str.startsWith("B"));
    }
}

/*
Although the output looks like a stream, pay special attention to the for loop inside
test(). It’s restarting the stream each time through the for loop, and skipping the
number of elements set by the for-loop index, which is what makes it end up on
each successive element in the stream. Then it does a findFirst() to take the first
remaining element, which comes back wrapped in an Optional.

Unlike the usual for loop, this index isn’t bounded by i < elements.length, but
rather i <= elements.length, so the final element actually overruns the stream.
Conveniently, this automatically becomes an Optional.empty, which you see at the
end of each test.
 */
