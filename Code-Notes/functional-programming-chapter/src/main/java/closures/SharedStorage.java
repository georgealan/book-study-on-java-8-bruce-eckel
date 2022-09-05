package closures;

import java.util.function.IntSupplier;

/*
Of course, if you call makeFun() multiple times for the same object, you’ll end up with
several functions all sharing the same storage for i:
 */
public class SharedStorage {
    public static void main(String[] args) {
        Closure1 c1 = new Closure1();
        IntSupplier f1 = c1.makeFun(0);
        IntSupplier f2 = c1.makeFun(0);
        IntSupplier f3 = c1.makeFun(0);

        System.out.println(f1.getAsInt());
        System.out.println(f2.getAsInt());
        System.out.println(f3.getAsInt());
    }

    /*
    Every call to getAsInt() increments i, demonstrating that the storage is shared.
     */

}

/*
If x and i are changed elsewhere in the method (but not inside the returned function),
the compiler still considers it an error. Each increment produces a separate error message:
 */

/*class Closure5 { // wouldn't compile.
    IntSupplier makeFun(int x) {
        int i = 0;
        i++;
        x++;
        return () -> x + i;
    }
 }*/

    /*
    To be effectively final means you could apply the final keyword to the variable
    declaration without changing any of the rest of the code. It’s actually final, you just
    haven’t bothered to say so.

    We can actually fix the issue in Closure5.java by assigning x and i to final
    variables before using them in the closure:
     */

class Closure6 {
    IntSupplier makeFun(int x) {
        int i = 0;
        i++;
        x++;
        final int iFinal = i;
        final int xFinal = x;
        return () -> xFinal + iFinal;
    }
    /*
    We never change iFinal and xFinal after assignment so the use of final here is redundant.
    What if you’re using references? We can change from int to Integer:

    class Closure7 { // Wouldn't compile
        IntSupplier makeFun(int x) {
            Integer i = 0;
            i = i + 1;
            return () -> x + i;
        }
    }
    The compiler is still smart enough to see that i is being changed.
     */

}
