package closures;

import java.util.function.IntSupplier;

/*
What if i is local to makeFun()? Under normal circumstances, i is gone when
makeFun() completes. It still compiles, however:
 */
public class Closure2 {
    IntSupplier makeFun(int x) {
        int i = 0;
        return () -> x + i;
    }

    /*
    The IntSupplier returned by makeFun() closes over i and x, thus both are still
    valid when you invoke the returned function. Notice, however, I didn’t increment i
    as in Closure1.java. Trying to increment it produces a compile-time error:

    "local variables referenced from a lambda expression must be final or effectively final"
    But if we make the i or x final, we can't increment it anyway.
     */
}
