package function_composition;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class PredicateComposition {
    static Predicate<String>
        p1 = s -> s.contains("bar"),
        p2 = s -> s.length() < 5,
        p3 = s -> s.contains("foo"),
        p4 = p1.negate().and(p2).or(p3);

    public static void main(String[] args) {
        Stream.of("bar", "foobar", "foobaz", "fongopuckey")
                .filter(p4).forEach(System.out::println);
    }

    /*
    p4 takes all the predicates and combines them into a more complex predicate, which
    reads: "If the String does NOT contain 'bar' AND the length is less than 5, OR it
    contains 'foo', the result is true."

    Because it produces such clear syntax, I’ve cheated a bit in main() and borrowed
    from the next chapter. First I create a "stream" (a sequence) of String objects, then
    feed each one to the filter() operation. filter() uses our p4 predicate to decide
    which object in the stream to keep, and which to discard. Finally, forEach() applies
    the println method reference to each surviving object.

    You can see from the output how p4 works: anything with a "foo" survives, even if
    its length is greater than five. "fongopuckey" is too long and doesn’t have a "bar" to
    save it.
     */
}
