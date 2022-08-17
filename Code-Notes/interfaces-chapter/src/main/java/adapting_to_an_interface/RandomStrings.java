package adapting_to_an_interface;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

/*
    the constructor for the Scanner class (which you’ll learn more about in the Strings chapter) takes a Readable
    interface. You’ll find that Readable is not an argument for any other method in the Java standard library—it
    was created solely for Scanner, so Scanner doesn’t constrain its argument to a particular class. This
    way, Scanner can be made to work with more types. If you create a new class and you want it used with Scanner,
    you make it Readable, like this:
 */

public class RandomStrings implements Readable {
    private static Random rand = new Random(47);
    private static final char[] CAPITALS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final char[] LOWERS = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final char[] VOWELS = "aeiou".toCharArray();
    private int count;

    public RandomStrings(int count) {
        this.count = count;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (count-- == 0){
            return -1; // Indicates end of input
        }
        cb.append(CAPITALS[rand.nextInt(CAPITALS.length)]);

        for (int i = 0; i < 4; i++) {
            cb.append(VOWELS[rand.nextInt(VOWELS.length)]);
            cb.append(LOWERS[rand.nextInt(LOWERS.length)]);
        }

        cb.append(" ");
        return 10; // Number of characters appended.
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(new RandomStrings(10));

        while (s.hasNext()) {
            System.out.println(s.next());
        }
    }
}
