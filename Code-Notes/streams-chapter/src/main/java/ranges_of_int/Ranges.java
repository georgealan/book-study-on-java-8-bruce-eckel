package ranges_of_int;

import java.util.stream.IntStream;

public class Ranges {
    public static void main(String[] args) {
        // Traditional way
        int result = 0;
        for(int i = 10; i < 20; i++) {
            result += i;
        }
        System.out.println(result);

        // for-in streams
        result = 0;
        for (int i : IntStream.range(10, 20).toArray()) {
            result += i;
        }
        System.out.println(result);

        // Use Streams
        System.out.println(IntStream.range(10, 20).sum());
    }


}
