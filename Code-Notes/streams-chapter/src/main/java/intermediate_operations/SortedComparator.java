package intermediate_operations;

import java.util.Comparator;

public class SortedComparator {
    public static void main(String[] args) throws Exception {
        FileToWords.stream("src/main/resources/Cheese.dat")
                .skip(10)
                .limit(10)
                .sorted(Comparator.reverseOrder())
                .map(w -> w + " ")
                .forEach(System.out::print);
    }
}
