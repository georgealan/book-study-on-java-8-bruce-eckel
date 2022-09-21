package try_with_resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MessyExceptions {
    public static void main(String[] args) {
        InputStream in = null;
        try {
            in = new FileInputStream(
                    new File("src/main/java/try_with_resources/MessyExceptions.java"));
            int contents = in.read();
            // Process contents
        } catch (IOException e) {
            // Handle errors
            System.out.println(e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                    System.out.println("file has been closed");
                } catch (IOException e) {
                    // Handle the close() error
                }
            }
        }
    }
}

/*
When the finally clause has its own try block, it feels like things have become overcomplicated.
Fortunately Java 7 introduced the try-with-resources syntax, which cleans up the above code remarkably well,
see in the file TryWithResources.java
 */
