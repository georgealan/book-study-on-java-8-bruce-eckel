package try_with_resources;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class InputFile2 {
    private String fname;
    public InputFile2(String fname) {
        this.fname = fname;
    }

    public Stream<String> getLines() throws IOException {
        return Files.lines(Paths.get(fname));
    }

    public static void main(String[] args) throws IOException {
        new InputFile2("src/main/java/try_with_resources/InputFile2.java").getLines()
                .skip(15)
                .limit(1)
                .forEach(System.out::println);
    }
}

/*
Now getLines() is solely responsible for opening the file and creating the Stream.
You can’t always sidestep the problem this easily. Sometimes there are objects that:

1. Need cleanup.
2. Need cleanup at a particular moment, when you go out of a scope (by normal means or via an exception).
 */
