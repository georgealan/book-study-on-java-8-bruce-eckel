package Strings_Numbers_and_Math;

import java.util.*;

public class CountingDuplicateCharacters {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, write any word or phrase here: ");
        String phrase = scanner.nextLine();

        countDuplicateCharacters(phrase);
    }

    static void countDuplicateCharacters(String s) {
        String wordOrPhrase = verifyIfIsWordOrPhrase(s);
        int numberOfDuplicate = 0;
        Collection<Character> duplicateCharecteres = new HashSet<>();
        Map<Character, Integer> wordsSplit = new HashMap<>();
        fillAndSplitSentence(wordsSplit, s);

        for (Integer v : wordsSplit.values()) {
            if (v > 1) {
                numberOfDuplicate++;
            }
        }

        /* TODO Find a way to iterate a Map and catch the characters that have a value > 1
            and put these in a new collection, only for display in text below.
         */

        System.out.println("This " + wordOrPhrase + " Here: \"" + s + "\", contain " + numberOfDuplicate +
                " characteres duplicated. And the duplicates are these: " + duplicateCharecteres + wordsSplit);
    }

    static String verifyIfIsWordOrPhrase(String s) {
        enum TypeString { WORD("word"), PHRASE("phrase");
            private String sentence;
            TypeString(String t) { sentence = t; }
            String getSentence() { return sentence; }
        }

        return (s.contains(" ")) ? TypeString.PHRASE.getSentence() : TypeString.WORD.getSentence();
    }

    static Map fillAndSplitSentence(Map<Character, Integer> map, String s) {
        for (char ch : s.toCharArray()) {
            map.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }
        return map;
    }

}

/*
TODO
 1. Counting duplicate characters: Write a program that counts duplicate characters from a given string.
 */
