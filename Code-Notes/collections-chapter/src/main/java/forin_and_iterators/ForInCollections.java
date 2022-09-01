package forin_and_iterators;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/*
So far, the for-in syntax is primarily used with arrays, but it also works with any
Collection object. You’ve actually seen a few examples of this using ArrayList,
but here’s a general proof:
 */

public class ForInCollections {
    public static void main(String[] args) {
        Collection<String> cs = new LinkedList<>();
        Collections.addAll(cs, "Take the long way home".split(" "));

        for (String s : cs) {
            System.out.print("'" + s + "' ");
        }
    }

    /*
    cs is a Collection so this code shows that working with for-in is a characteristic
    of all Collection objects.

    The reason this works is that Java 5 introduced an interface called Iterable
    containing an iterator() method that produces an Iterator. for-in uses this
    Iterable interface to move through a sequence.
     */
}
