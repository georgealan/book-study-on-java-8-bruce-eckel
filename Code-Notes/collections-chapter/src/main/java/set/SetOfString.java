package set;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class SetOfString {
    public static void main(String[] args) {
        Set<String> colors = new HashSet<>();

        for (int i = 0; i < 100; i++) {
            colors.add("Yellow");
            colors.add("Blue");
            colors.add("Red");
            colors.add("Red");
            colors.add("Orange");
            colors.add("Yellow");
            colors.add("Blue");
            colors.add("Purple");
        }
        System.out.println("HashSet don't sort the results in order");
        System.out.println(colors);

        /*
        String objects don’t seem to produce an order. To sort the results, one approach is
        to use a TreeSet instead of a HashSet:
         */

        Set<String> colors2 = new TreeSet<>();

        for (int i = 0; i < 100; i++) {
            colors2.add("Yellow");
            colors2.add("Blue");
            colors2.add("Red");
            colors2.add("Red");
            colors2.add("Orange");
            colors2.add("Yellow");
            colors2.add("Blue");
            colors2.add("Purple");
        }
        System.out.println("TreeSet sort the results in order");
        System.out.println(colors2);
    }
}
