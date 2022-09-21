package try_with_resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

// Java 7 introduced the try-with-resources syntax.
public class TryWithResources {
    public static void main(String[] args) {
        try (
            InputStream in = new FileInputStream(
                    new File("src/main/java/try_with_resources/TryWithResources.java"))
        ) {
            int contents = in.read();
            // Process contents
        } catch (IOException e) {
            // Handle errors
        }
    }
}

/*
Before Java 7, a try was always followed by a {, but now it can be followed
by a parenthesized definition—here our creation of the FileInputStream object.
The part within parentheses is called the resource specification header. Now in is
available throughout the rest of the try block. More importantly, no matter how
you exit the try block (normally or via exception), the equivalent of the previous
finally clause is executed, but without writing that messy and tricky code. This is
an important improvement.
 */
