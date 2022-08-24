package printing_collections;

import java.util.*;

/*
Collections print themselves automatically

You must use Arrays.toString() to produce a printable representation of an
array, but the collections print nicely without any help. Here’s an example that also
introduces you to the basic Java collections:
 */

public class PrintingCollections {
    static Collection fill(Collection<String> collection){
        collection.add("rat");
        collection.add("cat");
        collection.add("dog");
        collection.add("dog");

        return collection;
    }

    static Map fill(Map<String, String> map) {
        map.put("rat", "Fuzzy");
        map.put("cat", "Rags");
        map.put("dog", "Bosco");
        map.put("dog", "Spot");

        return map;
    }

    public static void main(String[] args) {
        System.out.println(fill(new ArrayList<>()));
        System.out.println(fill(new LinkedList<>()));
        System.out.println(fill(new HashSet<>()));
        System.out.println(fill(new TreeSet<>()));
        System.out.println(fill(new LinkedHashSet<>()));
        System.out.println(fill(new HashMap<>()));
        System.out.println(fill(new TreeMap<>()));
        System.out.println(fill(new LinkedHashMap<>()));
    }

/*
This shows the two primary categories in the Java collection library. The distinction
is based on the number of items held in each "slot" in the collection. The Collection
category only holds one item in each slot. It includes List, which holds a group of
items in a specified sequence, Set, which only allows the addition of one identical
item, and Queue, which only inserts objects at one "end" of the collection and
removes objects from the other "end" (for the purposes of this example, this is just
another way of looking at a sequence and so is not shown). A Map holds two objects,
a key and an associated value, in each slot.

The default printing behavior, provided via each collection’s toString() method,
produces reasonably readable results. A Collection is printed surrounded by square
brackets, with each element separated by a comma. A Map is surrounded by curly
braces, with each key and value associated with an equal sign (keys on the left, values
on the right).
 */
}
