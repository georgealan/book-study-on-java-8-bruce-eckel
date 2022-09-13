package random_number_streams;

import java.util.stream.Stream;

/*
Stream.iterate() starts with a seed (the first argument) and passes it to the
method (the second argument). The result is added to the stream and also stored
for use as the first argument the next time iterate() is called, and so on. We can
iterate() a Fibonacci sequence (which you first encountered in the last chapter):
 */
public class Fibonacci {
    int x = 1;

    Stream<Integer> numbers() {
        return Stream.iterate(0, i -> {
           int result = x + i;
           x = i;
           return result;
        });
    }

    public static void main(String[] args) {
        new Fibonacci().numbers()
                .skip(20)  // Don't use the first 20
                .limit(10)  // Then take 10 of them
                .forEach(System.out::println);
    }
}

/*
The Fibonacci sequence sums the last two elements in the sequence to produce the
next one. iterate() only remembers the result, so we must use x to keep track of
the other element.

In main(), we use the skip() operation, which you haven’t seen before. It simply
discards the number of stream elements specified by its argument. Here, we discard
the first 20 items.
 */
