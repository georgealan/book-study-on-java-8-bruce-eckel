package optional;

import java.util.stream.IntStream;
import java.util.stream.Stream;
/*
Certain standard stream operations return Optional objects because they cannot guarantee
the desired result will exist. These include:

• findFirst() returns an Optional containing the first element. If the stream is empty, it returns Optional.empty.
• findAny() returns an Optional containing any element, or Optional.empty if the stream is empty.
• max() and min() return an Optional containing the maximum or minimum values in the stream,
or an Optional.empty if the stream is empty.
• The version of reduce() that does not start with an "identity" object (the "identity" object becomes the default
result in the other version of reduce() so there’s no risk of an empty result) wraps its return value in an Optional.
• For the numerical streams IntStream, LongStream and DoubleStream, the average() operation wraps
its result in an Optional in case the stream is empty.

Here are simple tests of all of these operations upon empty streams:
 */
public class OptionalsFromEmptyStreams {
    public static void main(String[] args) {
        System.out.println(Stream.<String>empty().findFirst());

        System.out.println(Stream.<String>empty().findAny());

        System.out.println(Stream.<String>empty().max(String.CASE_INSENSITIVE_ORDER));

        System.out.println(Stream.<String>empty().min(String.CASE_INSENSITIVE_ORDER));

        System.out.println(Stream.<String>empty().reduce((s1, s2) -> s1 + s2));

        System.out.println(IntStream.empty().average());
    }
}

/*
Instead of throwing an exception because the stream is empty, you get an Optional.
empty object. Optional has a toString() which displays useful information.
Note the creation of the empty stream via Stream.<String>empty(). If you just say
Stream.empty() without any context information, Java doesn’t know what the type
is; this syntax solves the problem. If the compiler has enough context information,
as in:

Stream<String> s = Stream.empty();

It can infer the type for the empty() call.
 */
