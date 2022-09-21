package try_with_resources;

class Reporter implements AutoCloseable {
    String name = getClass().getSimpleName();
    Reporter() {
        System.out.println("Creating " + name);
    }
    @Override public void close() {
        System.out.println("Closing " + name);
    }
}

class First extends Reporter {}
class Second extends Reporter {}

public class AutoCloseableDetails {
    public static void main(String[] args) {
        try (
            First f = new First();
            Second s = new Second();
        ) {

        }
    }
}

/*
Exiting the try block calls close() for both objects and it closes them in reverse
order of creation. The order is important because in this configuration the Second
object might depend on the First object, so if First is already closed by the time
Second closes, Second’s close() might try to access some feature of First which
is no longer available.
 */
