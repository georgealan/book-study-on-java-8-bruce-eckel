package regular_expressions;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileToWordsRegexp {
    private String all;
    public FileToWordsRegexp(String filePath) throws Exception {
       all = Files.lines(Paths.get(filePath))
               .skip(1)
               .collect(Collectors.joining(" "));
    }

    public Stream<String> stream() {
        return Pattern.compile("[ .,?]+").splitAsStream(all);
    }

    public static void main(String[] args) throws Exception {
        FileToWordsRegexp fw = new FileToWordsRegexp("src/main/resources/Cheese.dat");
        fw.stream()
                .limit(7)
                .map(w -> w + " ")
                .forEach(System.out::print);

        fw.stream()
                .skip(7)
                .limit(2)
                .map(w -> w + " ")
                .forEach(System.out::print);
    }
}

/*
The constructor reads all the lines in the file (again, skipping the first comment line)
and turns them into a single String). Now, when you call stream(), you get a
stream as before, but this time you can come back and call stream() multiple times,
creating a new stream from the stored String each time. The limit here is that the
whole file must be stored in memory; most of the time that probably won’t be an
issue, but it loses important benefits of streams:

1. They "don’t require storage." Of course, they actually require some internal
storage, but it’s only a fraction of the sequence, and nothing like what it takes
to hold the entire sequence.

2. They are lazily evaluated.
Fortunately, we’ll see how to solve this problem a bit later.
 */
