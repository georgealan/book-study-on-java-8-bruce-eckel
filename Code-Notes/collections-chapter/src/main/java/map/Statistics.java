package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Statistics {
    public static void main(String[] args) {
        Random rand  = new Random(47);
        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < 10000; i++) {
            // Produce a number between 0 and 20:
            int r = rand.nextInt(20);
            Integer freq = m.get(r);            // [1]
            m.put(r, freq == null ? 1 : freq + 1);
        }
        System.out.println(m);
    }

    /*
    [1] Autoboxing converts the randomly generated int into an Integer reference
    that can be used with the HashMap (you can’t use primitives with
    collections). get() returns null if the key is not already in the collection
    (which means this is the first time the number was found). Otherwise, get()
    produces the associated Integer value for the key, which is incremented (again,
    autoboxing simplifies the expression but there are actually conversions to and
    from Integer taking place).
     */
}
