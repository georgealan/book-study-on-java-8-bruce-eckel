package closures;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Closure8 {
    Supplier<List<Integer>> makeFun() {
        final List<Integer> ai = new ArrayList<>();
        ai.add(1);
        return () -> ai;
    }

    public static void main(String[] args) {
        Closure8 c7 = new Closure8();
        List<Integer>
            l1 = c7.makeFun().get(),
            l2 = c7.makeFun().get();

        System.out.println(l1);
        System.out.println(l2);

        l1.add(42);
        l2.add(96);
        System.out.println(l1);
        System.out.println(l2);
    }

    /*
    This time it works: we modify the contents of the List without producing a compile-time
    error. When you look at the output from this example, it does seem pretty
    safe, because each time makeFun() is called, a brand new ArrayList is created
    and returned—which means it is not shared, so each generated closure has its own
    separate ArrayList and they can’t interfere with each other.

    And notice I’ve declared ai to be final, although for this example you can take
    final off and get the same results (try it!). The final keyword applied to object
    references only says that the reference doesn’t get reassigned. It doesn’t say you
    can’t modify the object itself.

     */
}
