package adding_groups_of_elements;

import java.util.*;

/*
The Arrays and Collections classes in java.util contain utility methods to add
groups of elements to a Collection. Arrays.asList() takes either an array or
a comma-separated list of elements (using varargs) and turns it into a List object.
Collections.addAll() takes a Collection object and either an array or a commaseparated
list and adds the elements to the Collection. Here you see both methods,
and the more conventional addAll() method that’s part of all Collection
types:
 */

public class AddingGroups {
    public static void main(String[] args) {
        /*
        The constructor for a Collection can accept another Collection which it uses for
        initializing itself, so you can use Arrays.asList() to produce input for the constructor.
        However, Collections.addAll() runs much faster, and it’s just as easy to construct the Collection
        with no elements, then call Collections.addAll(), so this is the preferred approach.
         */
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        Integer[] moreInts = { 6, 7, 8, 9, 10 };

        collection.addAll(Arrays.asList(moreInts));

        // Below runs significantly faster, but you can't construct a Collection this way:
        Collections.addAll(collection, 11, 12, 13, 14, 15);
        Collections.addAll(collection, moreInts);

        // Produces a list "backed by" an array:
        List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
        list.set(1, 99); // OK, modify an element.

        //list.add(21); // Runtime error, the underlying array cannot be resized.

    }

    /*
    The Collection.addAll() method can only take an argument of another Collection
    object, so it is not as flexible as Arrays.asList() or Collections.addAll(),
    which use variable argument lists.
     */
}
