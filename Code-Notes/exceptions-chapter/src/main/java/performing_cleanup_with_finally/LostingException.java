package performing_cleanup_with_finally;

class VeryImportantException extends Exception {
    @Override public String toString() {
        return "A very important exception";
    }
}

class HoHumException extends Exception {
    @Override public String toString() {
        return "A trivial exception";
    }
}

public class LostingException {
    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }
    void dispose() throws HoHumException {
        throw new HoHumException();
    }

    public static void main(String[] args) {
        try {
            LostingException le = new LostingException();
            try {
                le.f();
            } finally {
                le.dispose();
            }
        } catch (VeryImportantException | HoHumException e) {
            System.out.println(e);
        }
    }
}

/*
The output shows no evidence of the VeryImportantException, which is replaced by the HoHumException in the finally
clause. This is a rather serious pitfall because it means an exception can be completely lost, and in a far more
subtle and difficult to detect fashion than the preceding example. In contrast, C++ treats the situation where
a second exception is thrown before the first one is handled as a dire programming error. Perhaps a future version
of Java will repair this problem (on the other hand, you typically wrap any method that throws an exception,
such as dispose() in the example above, inside a try-catch clause).
 */
