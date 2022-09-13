package intermediate_operations.combining_streams_during_map;

import java.util.stream.Stream;

/*
Suppose you’ve got a stream of incoming elements, and you’re applying a map()
function to them. You’ve found some lovely functionality for your function you can’t
find anywhere else, but there’s a problem: that functionality produces a stream. What
you want is to produce a stream of elements, but instead you’re producing a stream
of streams of elements.

flatMap() does two things: it takes your stream-producing function and applies it
to incoming elements (just like map() does), then it takes each stream and "flattens"
it into elements. So what comes out is just elements.

• flatMap(Function): Use when Function produces a stream.
• flatMapToInt(Function): For a Function that produces an IntStream.
• flatMapToLong(Function): For a Function that produces a LongStream.
• flatMapToDouble(Function): For a Function that produces a DoubleStream.

To see how this works, we’ll start with a contrived function for map(), which takes
in an Integer and produces a stream of Strings:
 */
public class StreamOfStreams {
    public static void main(String[] args) {
        System.out.println("stream of heads to other streams:");
        Stream.of(1, 2, 3)
                .map(i -> Stream.of("Gonzo", "Kermit", "Beaker"))
                .map(e -> e.getClass().getName())
                .forEach(System.out::println);

        System.out.println("\nstreams flattened:");
        Stream.of(1, 2, 3)
                .flatMap(i -> Stream.of("Gonzo", "Kermit", "Beaker"))
                .forEach(System.out::println);

    }
}

/*
So each stream that comes back from the mapping is automatically flattened into its
component Strings.
 */
