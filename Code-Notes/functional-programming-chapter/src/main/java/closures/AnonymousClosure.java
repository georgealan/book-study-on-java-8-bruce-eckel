package closures;

import java.util.function.IntSupplier;

public class AnonymousClosure {
    IntSupplier makeFun(int x) {
        int i = 0;
        // Same rules apply:
        // i++; // Not "effectively final"
        // x++; // Ditto
        return new IntSupplier() {
            @Override
            public int getAsInt() {
                return x + i;
            }
        };
    }

    /*
    It turns out that as long as there have been inner classes, there have been closures
    (Java 8 just makes closures easier). Prior to Java 8, the requirement was that x and i
    be explicitly declared final. With Java 8, the rule for inner classes has been relaxed
    to include "effectively final."
     */
}
