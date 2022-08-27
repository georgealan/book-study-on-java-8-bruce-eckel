package set;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UniqueWords {
    public static void main(String[] args) throws Exception {
        String path1 = "src/main/resources/Text.txt";
        String path2 = "src/main/java/set/SetOperation.java";
        List<String> lines = Files.readAllLines(Paths.get(path2));

        Set<String> words = new TreeSet<>();

        for (String line : lines) {
            for (String word: line.split("\\W+")) {
                if (word.trim().length() > 0) {
                    words.add(word);
                }
            }
        }
        System.out.println(words);

        /*
        We step through each line in the file and break it into words using String.split(),
        using the regular expression \\W+, which means it splits on one or more (that’s
        the +) non-word letters (regular expressions are introduced in the Strings chapter).
        Each resulting word is added to the words Set. It is a TreeSet so the result is
        sorted. Here, the sorting is done lexicographically so the uppercase and lowercase
        letters are in separate groups.
         */
    }
}
