package performing_cleanup_with_finally;

// An even simpler way to lose an exception is just to return from inside a finally clause:
public class ExceptionSilencer {
    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        } finally {
            // Using return inside the finally block will silence any throw exception.
            return;
        }
    }
}
// This program don't produce any output, even though an exception is thrown.
