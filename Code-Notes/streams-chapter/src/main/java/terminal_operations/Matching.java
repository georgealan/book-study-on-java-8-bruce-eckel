package terminal_operations;

import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
BiPredicate is a binary predicate, which only means it takes two arguments and
returns true or false. The first argument is the stream of numbers we are going
to test, and the second argument is the Predicate itself. Because Matcher fits
the pattern of all the Stream::*Match functions, we can pass each one to show().
The call to match.test() is translated into an invocation of the Stream::*Match
function.

show() takes a Matcher and a val indicating the maximum number in the predicate’s
test n < val. It generates a stream of Integers from 1 through 9. The peek()
indicates how far the test gets before it short-circuits.
The output shows the short-circuiting behavior.
 */
interface Matcher extends BiPredicate<Stream<Integer>, Predicate<Integer>> {}

public class Matching {
    static void show(Matcher match, int val) {
        System.out.println(
                match.test(
                        IntStream.rangeClosed(1, 9)
                                .boxed()
                                .peek(n -> System.out.format("%d", n)),
                        n -> n < val));
    }

    public static void main(String[] args) {
        show(Stream::allMatch, 10);
        show(Stream::allMatch, 4);
        show(Stream::anyMatch, 2);
        show(Stream::anyMatch, 0);
        show(Stream::noneMatch, 5);
        show(Stream::noneMatch, 0);
    }
}
