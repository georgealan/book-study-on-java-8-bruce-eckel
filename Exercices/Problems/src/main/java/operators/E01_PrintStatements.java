package operators;

import java.util.Scanner;

public class E01_PrintStatements {
    static int actualYear = 2022;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert the year that you birth: ");
        int yearOfBirth = scanner.nextInt();

        calculateHowOldAreYou(yearOfBirth);
    }

    static void calculateHowOldAreYou(int yearOfBirth) {
        int age = actualYear - yearOfBirth;
        System.out.print("You age is: " + age);
    }
}


/*
TODO
 ****************** Exercise 1 *****************
 * Write a program that uses the "short" and
 * normal form of print statement.
 ***********************************************
 */
