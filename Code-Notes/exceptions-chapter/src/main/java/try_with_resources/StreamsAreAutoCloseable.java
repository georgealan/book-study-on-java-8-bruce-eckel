package try_with_resources;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamsAreAutoCloseable {
    public static void main(String[] args) throws IOException {
        try (
                Stream<String> in = Files.lines(
                        Paths.get("src/main/java/try_with_resources/StreamsAreAutoCloseable.java"));
                PrintWriter outFile = new PrintWriter("src/main/resources/Results.txt"); // [1]
                ) {
            in.skip(4)
                    .limit(3)
                    .map(String::toLowerCase)
                    .forEachOrdered(outFile::println);
        } // [2]
    }
}

/*
How does it work? The objects created in the try-with-resources definition clause
(within the parentheses) must implement the interface java.lang.AutoCloseable,
which contains a single method, close(). When AutoCloseable was introduced
in Java 7, many interfaces and classes were modified to implement it. Check the
AutoCloseable Javadocs to see a list, which includes Stream objects:

• [1] You can see another feature here: the resource specification header can
contain multiple definitions, separated by semicolons (the final semicolon is
accepted but optional). Each object defined in the header will have its close()
called at the end of the try block.

• [2] The try block for try-with-resources can stand alone, without a catch or finally.
Here, the IOException is passed out through main() so it doesn’t have to be caught at the end of the try.

The Java 5 Closeable interface was modified to inherit from AutoCloseable,
so anything that historically supports Closeable is also supported by try-with-resources.
 */
