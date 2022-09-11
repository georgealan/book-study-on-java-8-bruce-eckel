package operators;

import java.util.Random;

public class E07_CoinFlipping {
    public static void main(String[] args) {
        Random rand = new Random();
        String flipping = flippingCoin(rand);
        System.out.println(flipping);
    }

    static String flippingCoin(Random random) {
        return random.nextBoolean() ? "Head" : "Crown";
    }
}

/*
TODO
 ****************** Exercise 7 *****************
 * Write a program that simulates coin-flipping.
 ***********************************************
 */


