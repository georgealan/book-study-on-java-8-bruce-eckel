package intermediate_operations.removing_elements;

import java.util.stream.*;
import static java.util.stream.LongStream.*;

public class Prime {
    public static boolean isPrime(long n) {
        return rangeClosed(2, (long)Math.sqrt(n))
                .noneMatch(i -> n % i == 0);
    }
    public LongStream numbers() {
        return iterate(2, i -> i + 1)
                .filter(Prime::isPrime);
    }

    public static void main(String[] args) {
        new Prime().numbers()
                .limit(10)
                .forEach(n -> System.out.format("%d ", n));
        System.out.println();

        new Prime().numbers()
                .skip(90)
                .limit(10)
                .forEach(n -> System.out.format("%d ", n));
    }
}

/*
rangeClosed() includes the top boundary value. The noneMatch() operation
returns true if no modulus produces zero, and false if any equal zero.
noneMatch() quits after the first failure rather than trying them all.
 */
