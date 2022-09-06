package stream_creation;

import java.util.*;

// Every Collection can produce a stream using the stream() method
public class CollectionToStream {
    public static void main(String[] args) {
        List<Bubble> bubbles = Arrays.asList(new Bubble(1), new Bubble(2), new Bubble(3));

        /*
        After creating a List<Bubble>, we simply ask it for a stream(), the common
        method for all collections. The intermediate map() operation takes each element in
        a stream and applies an operation to create a new element, which it then passes on
        down the stream. The normal map() takes objects and produces objects, but there are
        special versions when the output stream holds a numeric type. Here, mapToInt()
        converts from an object stream to an IntStream containing Integers. There are
        similarly-named operations for Float and Double.
         */
        System.out.println(
                bubbles.stream()
                        .mapToInt(b -> b.i)
                        .sum()
        );

        /*
        To define w we take a String and apply the split() function, which splits the
        String according to its argument. You’ll see later that this argument can be quite
        sophisticated, but here we are just telling it to split at spaces.
         */
        Set<String> w = new HashSet<>(Arrays.asList("It's a wonderful day for pie!".split(" ")));

        w.stream().map(x -> x + " ").forEach(System.out::print);

        System.out.println();

        Map<String, Double> m = new HashMap<>();

        m.put("pi", 3.14159);
        m.put("e", 2.718);
        m.put("phi", 1.618);

        /*
        To produce a stream from a Map collection, we first call entrySet() to produce a
        stream of objects that each contains both a key and its associated value, then pull
        that apart using getKey() and getValue().
         */
        m.entrySet().stream()
                .map(e -> e.getKey() + ": " + e.getValue())
                .forEach(System.out::println);
    }
}
