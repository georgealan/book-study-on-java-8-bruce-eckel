package optional;

import java.util.Optional;
import java.util.stream.Stream;

public class OptionalBasics {
    static void test(Optional<String> optString) {
        if (optString.isPresent()) {
            System.out.println(optString.get());
        } else {
            System.out.println("Nothing inside!");
        }
        /*
        When you receive an Optional, you first discover whether there’s anything inside
        by calling isPresent(). If there is, you fetch it using get().
         */
    }

    public static void main(String[] args) {
        test(Stream.of("Epithets").findFirst());
        test(Stream.<String>empty().findFirst());
    }

}

// TODO Continue in page: 542 Convenience Functions
