package forin_and_iterators;

import java.util.Arrays;

public class ArrayIsNotIterable {
    static <T> void test(Iterable<T> ib) {
        for (T t : ib) {
            System.out.print(t + " ");
        }
    }

    public static void main(String[] args) {
        test(Arrays.asList(1, 2, 3));
        String[] strings = { "A", "B", "C" };

        // An array works in for-in, but it's not Iterable.
        //- test(strings);
        // You must explicitly convert it to an Iterator
        test(Arrays.asList(strings));

        /*
        Trying to pass an array as an Iterable argument fails. There is no automatic
        conversion to an Iterable; you must do it by hand.
         */
    }
}
