package stream_creation;

import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

/*
Explicitly writing the mechanics of iteration as in ImperativeRandoms.java is
called external iteration. In Randoms, you don’t see any of these mechanisms and so
it is called internal iteration, a core characteristic of streams programming.
Internal iteration produces more readable code, but it also makes it easier to use multiple
processors: By loosening control of how iteration happens, you can hand that
control over to a parallelizing mechanism.
 */
public class Randoms {
    public static void main(String[] args) {
        // Declarative Programming Style
        System.out.println("Declarative Programming Style:");
        new Random(47)
                .ints(5, 20)
                .distinct()
                .limit(7)
                .sorted()
                .forEach(System.out::println);

        // Imperative Programming Form
        Random rand = new Random(45);
        SortedSet<Integer> rints = new TreeSet<>();

        while (rints.size() < 7) {
            int r = rand.nextInt(20);
            if (r < 5) continue;
            rints.add(r);
        }
        System.out.println("Imperative Programming Form:");
        System.out.println(rints);
    }
}
