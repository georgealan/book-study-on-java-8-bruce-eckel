package Final_keyword;

import java.util.Random;

/**
 * The effects of final on fields
 */

class Value {
    int i; // Package access
    Value(int i) { this.i = i; }
}

public class FinalData {
    private static Random rand = new Random(47);
    private String id;
    public FinalData(String id) { this.id = id; }

    /**
     * Can e compile-time constants
     *
     * The constants above are final primitives with compile-time values, so they can both be used as compile-time
     * constants and are not different in any important way.
     */
    private final int valueOne = 9;
    private static final int VALUE_TWO = 99;

    /**
     * Typical public constants
     *
     * This is more typical way you'll see such constants defined: public so they are usable outside the package,
     * static to emphasize there's only one, and final to say it's a constant.
     */
    public static final int VALUE_THREE = 39;

    /**
     * Cannot be compile-time constants
     *
     * Just because something is final doesn't mean its value is know at compile time, this is demonstrated above, by
     * initializing i4 and INT_5 at runtime using randomly generated numbers.
     */
    private final int i4 = rand.nextInt(20);
    static final int INT_5 = rand.nextInt(20);
    private Value v1 = new Value(11);

    /**
     * Because v2 is final doesn't mean you can't change its value, because it's a reference, final just means
     * you cannot rebind v2 to a new object.
     */
    private final Value v2 = new Value(22);
    private static final Value VAL_3 = new Value(33);

    /**
     * Arrays
     *
     * The same meaning holds true for an array, which is just another kind of reference. (There is no way I know
     * of to make the array references themselves final.) Making references final seems less useful than
     * making primitives final.
     */
    private final int[] a = {1, 2, 3, 4, 5, 6};
    @Override public String toString() {
        return id + ": " + "i4 = " + i4 + ", INT_5 = " + INT_5;
    }

    public static void main(String[] args) {
        FinalData fd1 = new FinalData("fd1");
        //- fd1.valueOne++; // Error: can't change value
        fd1.v2.i++; // Object isn't constant!
        fd1.v1 = new Value(9); // OK not final

        for (int i = 0; i < fd1.a.length; i++) {
            fd1.a[i]++; // Object isn't constant!

            //- fd1.v2 = new Value(0); // Error: Can't
            //- fd1.VAL_3 = new Value(1); // change reference
            //- fd1.a = new int[3];

            System.out.println(fd1);
            System.out.println("Creating new FinalData");
            FinalData fd2 = new FinalData("fd2");
            System.out.println(fd1);
            System.out.println(fd2);
        }
    }
}
