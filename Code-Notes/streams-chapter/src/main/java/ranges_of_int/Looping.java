package ranges_of_int;

import java.util.stream.IntStream;

class Repeat {
    public static void repeat(int n, Runnable action) {
        IntStream.range(0, n).forEach(i -> action.run());
    }
}

public class Looping {
    static void hi() {
        System.out.println("Hi!");
    }

    public static void main(String[] args) {
        Repeat.repeat(3, () -> System.out.println("Looping!"));
        Repeat.repeat(2, Looping::hi);
    }
}

/*
It might not be worth it, however, to include and explain repeat() in your code.
It seems like a reasonably transparent tool, but it depends on how your team and
company works.
 */
