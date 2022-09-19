package terminal_operations;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// If you must select the last element in a stream, use reduce():
public class LastElement {
    public static void main(String[] args) {
        OptionalInt last = IntStream.range(10, 20)
                .reduce((n1, n2) -> n2);
        System.out.println(last.orElse(-1));

        // Non-numeric object:
        Optional<String> lastObj = Stream.of("One", "Two", "Three")
                .reduce((n1,  n2) -> n2);
        System.out.println(lastObj.orElse("Nothing there!"));
    }
}

/*
The argument to reduce() just replaces the last two elements with the last element,
ultimately producing only the last element. If the stream is numeric, you must use
the appropriate numeric optional type, otherwise you use a typed Optional as in
Optional<String>.
 */
