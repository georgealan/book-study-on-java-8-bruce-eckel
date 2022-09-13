package intermediate_operations.combining_streams_during_map;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
I’ve introduced concat() here, which combines two streams in argument order.
At the end of each stream of random Integer, I add -1 as a marker, so you can see that
the final stream is indeed being created from a group of flattened streams.
Because rand.ints() produces an IntStream, I must use the special Integer
versions of flatMap(), concat(), and of().
 */
public class StreamOfRandoms {
    static Random rand = new Random(47);

    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 5)
                .flatMapToInt(i -> IntStream.concat(
                        rand.ints(0, 100).limit(i), IntStream.of(-1)))
                .forEach(n -> System.out.format("%d ", n));
    }
}
