package terminal_operations;

import static terminal_operations.RandInts.*;

public class ForEach {
    static final int SZ = 14;

    public static void main(String[] args) {
        rands().limit(SZ)
                .forEach(n -> System.out.format("%d ", n));
        System.out.println();

        rands().limit(SZ)
                .parallel()
                .forEach(n -> System.out.format("%d ", n));
        System.out.println();

        rands().limit(SZ)
                .parallel()
                .forEachOrdered(n -> System.out.format("%d ", n));
    }
}

/*
In the first stream, we don’t use parallel() and so display the results in the order
they appear from rands(). The second stream does introduce parallel() and, even for
such a small stream, you see that the output is not in the same order as before.

That’s because multiple processors are working on the problem, and if you run the program multiple times you’ll
see that this output is different, due to the non-deterministic factors produced by having more than one
processor working on the problem at the same time.

The final stream still uses parallel() but forces the result back into its original order
using forEachOrdered(). Thus, using forEachOrdered() for non-parallel() streams doesn’t have any effect.
 */
