package operators;

import java.util.Date;
import java.util.Scanner;

public class YearOfBirthWithDate {
    static Date currentDate = new Date();
    static int control = 0;
    static int yearOfBirth;

    public static void main(String[] args) {
        String actualYear = currentDate.toString().substring(24);
        Scanner scanner = new Scanner(System.in);

        while (control == 0) {
            System.out.println("Write you year of birth, please in this format 1999: ");
            yearOfBirth = scanner.nextInt();

            if (yearOfBirth > 999) {
                control = 1;
            } else
                System.out.println("You write wrong year numbers format, please try again.");
        }

        calculateHowOldAreYou(Integer.parseInt(actualYear), yearOfBirth);
    }

    static void calculateHowOldAreYou(int actualYear, int yearOfBirth) {
        int age = actualYear - yearOfBirth;
        System.out.println("Your age are: " + age + " years old");
    }
}
