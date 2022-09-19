package catching_any_exception;

class OneException extends Exception {
    OneException(String s) { super(s); }
}

class TwoException extends Exception {
    TwoException(String s) { super(s); }
}

public class RethrowNew {
    public static void f() throws OneException {
        System.out.println("Originating the exception in f()");
        throw new OneException("Throw from f()");
    }

    public static void main(String[] args) {
        try {
            try {
                f();
            } catch (OneException e) {
                System.out.println("Caught in inner try, e.printStackTrace()");
                e.printStackTrace(System.out);
                throw new TwoException("From inner try");
            }
        } catch (TwoException e) {
            System.out.println("Caught in outer try, e.printStackTrace()");
            e.printStackTrace(System.out);
        }
    }
    /*
    The final exception knows only it came from the inner try block and not from f().
    Don’t worry about cleaning up the previous exception, or any exceptions. They’re all
    heap-based objects created with new, so the garbage collector automatically cleans them all up.
     */
}

/*
It’s also possible to rethrow a different exception from the one you caught. If you do this, you get a similar
effect as when you use fillInStackTrace() the information about the  original site of the exception is lost,
and what you’re left with is the information pertaining to the new throw:
 */
