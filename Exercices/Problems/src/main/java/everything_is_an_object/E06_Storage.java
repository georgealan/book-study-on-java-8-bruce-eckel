package everything_is_an_object;

import java.util.Scanner;

public class E06_Storage {

    String phrase;

    String getPhrase() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write you phrase here below, please: ");
        String text = scanner.nextLine();

        return phrase = text;
    }

    int storage(String s) {
        s = phrase;
        return s.length();
    }

    void printStorage() {
        System.out.println(storage(phrase));
    }

    public static void main(String[] args) {
        E06_Storage s = new E06_Storage();
        s.getPhrase();
        s.storage(s.phrase);
        s.printStorage();
    }
}

/*
TODO
 ****************** Exercise 6 ******************
 * Write a program that includes and calls the
 * storage() method defined as a code fragment in
 * this chapter.
 ************************************************
 */
