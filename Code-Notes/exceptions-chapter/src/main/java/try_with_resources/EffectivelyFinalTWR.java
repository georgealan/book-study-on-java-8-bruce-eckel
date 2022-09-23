package try_with_resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class EffectivelyFinalTWR {
    static void old() {
        try (
            InputStream r1 = new FileInputStream(
                    new File("src/main/java/try_with_resources/TryWithResources.java"));
            InputStream r2 = new FileInputStream(
                    new File("src/main/java/try_with_resources/EffectivelyFinalTWR.java"));
        ) {
            r1.read();
            r2.read();
        } catch (IOException e) {
            // Handle exceptions
        }
    }

    static void newJdk9() throws IOException {
        final InputStream r1 = new FileInputStream(
                new File("src/main/java/try_with_resources/TryWithResources.java"));
        // Effectivelly final:
        InputStream r2 = new FileInputStream(
                new File("src/main/java/try_with_resources/EffectivelyFinalTWR.java"));

        try (r2; r2) {
            r1.read();
            r2.read();
        }
        // r1 and r2 are still in scope. Accessing either one throws an exception:
        r1.read();
        r2.read();
    }

    public static void main(String[] args) {
        old();
        try {
            newJdk9();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

/*
jdk9() passes exceptions out by specifying throws IOException. This is because
the definitions of r1 and r2 are no longer inside a try, as they are in old(). The
inability to catch exceptions is one reason this new feature seems questionable.

It’s also possible to reference variables after they have been released by the try-withresources,
as you can see at the end of jdk9(). The compiler allows this, but you get
an exception when you access r1 or r2 outside the try block.

It is not clear that the benefit of this new feature is worth the cost of moving this
check from compile-time to runtime, and also losing the catch clause. It might be a
good idea to avoid this feature altogether.
 */
