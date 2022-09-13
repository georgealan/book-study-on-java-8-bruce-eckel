package intermediate_operations;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/*
Let’s take one more look at the task of breaking a file into a stream of words. Our last
encounter was FileToWordsRegexp.java, which had the problem that it required
us to read the whole file into a List of lines—thus requiring storage for that List.
What we really want is to create a stream of words without requiring intermediate
storage. Once again, this is exactly the problem solved by flatMap():
 */
public class FileToWords {
    public static Stream<String> stream(String filePath) throws Exception {
        return Files.lines(Paths.get(filePath))
                .skip(1) // First comment line
                .flatMap(line -> Pattern.compile("\\W+").splitAsStream(line));
                //.flatMap(line -> Arrays.stream(line.split("\\W+"))) // Alternative for Pattern.compile
    }
}

/*
stream() is now a static method because it can accomplish the whole stream-creation process by itself.
Note the use of \\W+ as the regular-expression pattern. The \\W means a "non-word
character," and the + means "one or more." Lowercase \\w refers to a "word character."
The problem we had before was that Pattern.compile().splitAsStream() produces a stream result, which means
invoking map() on the incoming stream of lines produces a stream of streams of words, when what we
want is simply a stream of words. Fortunately, flatMap() flattens a stream of streams of elements into
a simple stream of elements. Alternatively, we could have used String.split(), which produces an array,
which can be converted using Arrays.stream(): .flatMap(line -> Arrays.stream(line.split("\\W+")))
 */
