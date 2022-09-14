package optional.streams_of_optionals;

import java.util.Optional;

public class StreamOfOptionals {
    public static void main(String[] args) {
        Signal.stream()
                .limit(10)
                .forEach(System.out::println);
        System.out.println(" ---");

        Signal.stream()
                .limit(10)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(System.out::println);
    }
}

/*
Here, I use filter() to keep only the non-empty Optionals, then use map() to
get() the values. Because each situation requires you to decide the meaning of "no
value," you usually need a different approach for each application.
 */
