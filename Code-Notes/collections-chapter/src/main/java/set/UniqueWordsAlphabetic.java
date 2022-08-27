package set;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*
If you’d like to sort it alphabetically, you can pass
the String.CASE_INSENSITIVE_ORDER Comparator (a comparator is an object that
establishes order) to the TreeSet constructor:
 */

public class UniqueWordsAlphabetic {
    public static void main(String[] args) throws Exception {
        String path1 = "src/main/resources/Text.txt";
        String path2 = "src/main/java/set/SetOperation.java";
        List<String> lines = Files.readAllLines(Paths.get(path2));

        Set<String> words = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        for (String line : lines) {
            for (String word : line.split("\\W+")) {
                if (word.trim().length() > 0) {
                    words.add(word);
                }
            }
        }
        System.out.println(words);
    }
}
