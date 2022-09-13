package streams_builders;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/*
In the Builder design pattern, you create a builder object, give it multiple pieces of
construction information, and finally perform the build act. The Stream library
provides such a Builder. Here, we revisit the process of reading a file and turning
it into a stream of words:
 */
public class FileToWordsBuilder {
    Stream.Builder<String> builder = Stream.builder();

    public FileToWordsBuilder(String filePath) throws Exception {
        Files.lines(Paths.get(filePath))
                .skip(1) // Skip the comment line at the beginning
                .forEach(line -> {
                    for (String word : line.split("[ .?,]+")) {
                        builder.add(word);
                    }
                });
    }

    Stream<String> stream() {
        return builder.build();
    }

    public static void main(String[] args) throws Exception {
        new FileToWordsBuilder("src/main/resources/Cheese.dat").stream()
                .limit(9)
                .map(word -> word + " ")
                .forEach(System.out::print);
    }
}

/*
Notice that the constructor adds all the words from the file (except the first line,
which is the comment containing the file path information), but it doesn’t call
build(). This means, as long as you don’t call stream(), you can continue to add
words to the builder object. In a more complete version of this class, you might add
a flag to see whether build() has been called, and a method to add further words
if possible. Trying to add to a Stream.Builder after calling build() produces an
exception.
 */
