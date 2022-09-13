package random_number_streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomWords implements Supplier<String> {
    List<String> words = new ArrayList<>();
    Random rand = new Random(47);

    RandomWords(String fname) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(fname));
        // Skip the first line:
        for (String line : lines.subList(1, lines.size())) {
           for (String word : line.split("[ .?,]+")) {
               words.add(word.toLowerCase());
           }
        }
    }

    @Override
    public String get() {
        return words.get(rand.nextInt(words.size()));
    }

    /*
    In toString() and main() you see the collect() operation, which combines all
    the stream elements according to its argument. When you use Collectors.joining(),
    you get a String result, with each element separated by the argument to joining().
     */
    @Override
    public String toString() {
        return words.stream()
                .collect(Collectors.joining(" "));
    }

    /*
    Here below you see a preview of Stream.generate(), which takes any Supplier<T>
    and produces a stream of T objects.
     */
    public static void main(String[] args) throws Exception {
        System.out.println(
                Stream.generate(new RandomWords("src/main/resources/Cheese.dat"))
                        .limit(10)
                        .collect(Collectors.joining(" ")));
    }
}
