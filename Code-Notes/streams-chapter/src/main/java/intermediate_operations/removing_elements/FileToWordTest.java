package intermediate_operations.removing_elements;

import intermediate_operations.FileToWords;

/*
Because we have a true stream (rather than a stream based on a stored collection as
in FileToWordsRegexp.java), every time we want a new stream we must create it
from scratch, because it can’t be reused:
 */
public class FileToWordTest {
    public static void main(String[] args) throws Exception {
        FileToWords.stream("src/main/resources/Cheese.dat")
                .limit(7)
                .forEach(s -> System.out.format("%s ", s));
        System.out.println();

        FileToWords.stream("src/main/resources/Cheese.dat")
                .skip(7)
                .limit(2)
                .forEach(s -> System.out.format("%s ", s));
    }
}
