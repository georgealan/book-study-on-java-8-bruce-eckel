package set;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/*
A Set refuses to hold more than one instance of each object value. If you try to add
more than one instance of an equivalent object, the Set prevents duplication. The
most common use for a Set is to test for membership, so you can easily ask whether
an object is in a Set. Because of this, lookup is typically the most important operation
for a Set, so you’ll usually choose a HashSet implementation, which is optimized
for rapid lookup.

Set has the same interface as Collection, so there isn’t any extra functionality like
there is in the two different types of List. Instead, the Set is exactly a Collection—
it just has different behavior. (This is the ideal use of inheritance and polymorphism:
to express different behavior.) A Set determines membership based on the "value"
of an object, a more complex topic covered in the Appendix: Collection Topics.
This uses a HashSet with Integer objects:
 */

public class SetOfInteger {
    public static void main(String[] args) {
        Random rand = new Random(47);
        Set<Integer> intSet = new HashSet<>();

        for (int i = 0; i < 10000; i++) {
            intSet.add(rand.nextInt(30));
        }

        System.out.println(intSet);
    }

    /*
    Ten thousand random numbers from 0 up to 29 are added to the Set, so you can
    imagine that each value has many duplications. And yet you see that only one
    instance of each appears in the result.

    The HashSet in earlier versions of Java produced output no discernible order. A
    HashSet uses hashing for speed—hashing is covered in the Appendix: Collection
    Topics. The order maintained by a HashSet is different from a TreeSet or a Linked-
    HashSet because each implementation has a different way of storing elements.

    TreeSet keeps elements sorted into a red-black tree data structure, whereas HashSet
    uses the hashing function. LinkedHashSet also uses hashing for lookup speed, but
    appears to maintain elements in insertion order using a linked list. Apparently, the
    hashing algorithm was changed and now Integers end up in sorted order. However,
    you should not depend on this behavior:
     */
}
