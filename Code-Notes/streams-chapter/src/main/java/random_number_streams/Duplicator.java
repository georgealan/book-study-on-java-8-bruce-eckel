package random_number_streams;

import java.util.stream.Stream;

/*
If you want to create a stream of identical objects, simply pass a lambda that produces
those objects to generate():
 */
public class Duplicator {
    public static void main(String[] args) {
        Stream.generate(() -> "Duplicate")
                .limit(3)
                .forEach(System.out::println);
    }
}
