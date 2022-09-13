package operators;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class YearOfBirthWithDate {
    static LocalDate currentDate;
    static int control = 0;
    static int yearOfBirth;

    public static void main(String[] args) {
        int actualYear = currentDate.getYear();
        Scanner scanner = new Scanner(System.in);

        while (control == 0) {
            System.out.println("Write you year of birth, please in this format 1999: ");
            yearOfBirth = scanner.nextInt();

            if (yearOfBirth > 999) {
                control = 1;
            } else
                System.out.println("You write wrong year numbers format, please try again.");
        }

        int age = calculateHowOldAreYou(actualYear, yearOfBirth);
        System.out.println("Your age are: " + age + " years old");
    }

    static int calculateHowOldAreYou(int actualYear, int yearOfBirth) {
        return actualYear - yearOfBirth;
    }
}
