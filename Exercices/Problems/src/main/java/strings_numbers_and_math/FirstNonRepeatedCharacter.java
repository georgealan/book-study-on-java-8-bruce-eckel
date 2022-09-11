package strings_numbers_and_math;

import java.util.*;

/**
 * This is my first solution that I could think to solve this problem.
 */
public class FirstNonRepeatedCharacter {
    static String nonRepeatedCharacter;
    //static Collection<Character> nonRepeatedLetters = new LinkedHashSet<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Write you word here below please: ");
        String word = scanner.nextLine();

        nonRepeatedCharacter = fillCollectionAndReturnFirstRepeated(word);
        System.out.println(nonRepeatedCharacter);
    }

    static String fillCollectionAndReturnFirstRepeated(String s) {
        Collection<Character> filtredLetters = new ArrayList<>();
        Set<Character> repeatedLetters = new LinkedHashSet<>();
        char[] letters = s.toCharArray();
        char lt;

        for (int i = 0; i < letters.length; i++) {
            lt = letters[i];
            filtredLetters.add(lt);
            for (int j = i + 1; j < letters.length; j++) {
                if (lt == letters[j]) {
                    repeatedLetters.add(lt);
                }
            }
        }

        filtredLetters.removeAll(repeatedLetters);
        Object[] nonRepeatedLetters = filtredLetters.toArray();

        return "The first non-repeated character is: " + nonRepeatedLetters[0];
    }
}

/*
TODO
 Finding the first non-repeated character: Write a program that returns the
 first non-repeated character from a given string.
 */
