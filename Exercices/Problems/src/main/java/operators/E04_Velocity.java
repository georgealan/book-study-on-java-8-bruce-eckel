package operators;

import java.util.Scanner;

public class E04_Velocity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write the distance");
        float distance = scanner.nextFloat();
        System.out.println("Write the time");
        float time = scanner.nextFloat();

        float result = getVelocity(distance, time);
        System.out.println("Velocity = " + result);
    }

    static float getVelocity(float distance, float time) {
        float result = distance / time;
        return result;
    }
}

/*
TODO
 ****************** Exercise 4 *****************
 * Write a program that calculates velocity
 * using a constant distance and a constant time.
 ***********************************************
 */
