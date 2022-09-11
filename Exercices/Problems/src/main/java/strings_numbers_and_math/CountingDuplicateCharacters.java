package strings_numbers_and_math;

import java.util.*;
import java.util.stream.Collectors;

public class CountingDuplicateCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, write any word or phrase here: ");
        String phrase = scanner.nextLine();

        String result = countDuplicateCharacters(phrase);
        System.out.println(result);
    }

    public static String countDuplicateCharacters(String s) {
        String wordOrPhrase = getIfIsWordOrPhrase(s);
        int numberOfDuplicate = 0;
        Map<String, Long> wordsSplit = fillAndSplitSentence(s.toUpperCase());
        String duplicatedCharecteres = getDuplicateCharacters(wordsSplit);

        numberOfDuplicate = getNumberOfDuplicate(numberOfDuplicate, wordsSplit, wordOrPhrase);

        String result = "This " + wordOrPhrase + " Here: \"" + s + "\", contain " + numberOfDuplicate +
                " characteres duplicated. And the duplicates are these: " + duplicatedCharecteres;

        return result;
    }

    static String getDuplicateCharacters(Map<String, Long> map) {
        Collection<String> t = new HashSet<>();

        for (String k : map.keySet()) {
            if (map.get(k) > 1 && !k.equals(" ")) {
                t.add(k);
            }
        }

        return t.toString();
    }

    static int getNumberOfDuplicate(int numberOfDuplicate, Map<String, Long> wordsSplit, String wordOrPhrase) {
        for (Long v : wordsSplit.values()) {
            if (v > 1) {
                numberOfDuplicate++;
            }
        }
        return wordOrPhrase.equals("phrase") ? --numberOfDuplicate : numberOfDuplicate;
    }

    static String getIfIsWordOrPhrase(String s) {
        enum TypeString { WORD("word"), PHRASE("phrase");
            private String sentence;
            TypeString(String t) { sentence = t; }
            String getSentence() { return sentence; }
        }

        return (s.contains(" ")) ? TypeString.PHRASE.getSentence() : TypeString.WORD.getSentence();

        /*
        TODO - Find a way to adjust this method for verify if an space is followed by a letter aside, because if don't,
         if are only a word with an empty space in the end, without other letters followed, this are a word not a phrase
         My first thought are to use regex, but I'll think more about later.
         */
    }

    static Map<String, Long> fillAndSplitSentence(String s) {
        Map<String, Long> result = s.codePoints()
                .mapToObj(c -> String.valueOf(Character.toChars(c)))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        return result;
    }

}

/*
TODO
 1. Counting duplicate characters: Write a program that counts duplicate characters from a given string.
 */
