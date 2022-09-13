package stream_creation;

import java.util.stream.Stream;

/*
Because bubbler() is interface-compatible with Supplier<Bubble>, we can pass
its method reference to Stream.generate():
 */
public class Bubbles {
    public static void main(String[] args) {
        Stream.generate(Bubble::bubbler)
                .limit(5)
                .forEach(System.out::println);
    }
}

/*
This is an alternative approach to creating a separate factory class. In many ways it’s
neater, but it’s a matter of taste and code organization—you can always just create a
completely different factory class.
 */
