package try_with_resources;

class CloseException extends Exception {}

class Reporter2 implements AutoCloseable {
    String name = getClass().getSimpleName();
    Reporter2() {
        System.out.println("Creating " + name);
    }
    @Override public void close() throws CloseException {
        System.out.println("Closing " + name);
    }
}

class Closer extends Reporter2 {
    @Override public void close() throws CloseException {
        super.close();
        throw new CloseException();
    }
}

public class CloseExceptions {
    public static void main(String[] args) {
        try (
            First f = new First();
            Closer c = new Closer();
            Second s = new Second()
        ) {
            System.out.println("In body");
        } catch (CloseException e) {
            System.out.println("Caught: " + e);
        }
    }
}

/*
Technically we’re not forced to provide a catch clause here; you can instead report
that main() throws CloseException. But the catch clause is the typical place to
put the error-handling code.

Notice that, because all three objects were created, they are all closed—in reverse
order—even though Closer.close() throws an exception. When you think about
it, this is what you want to happen, but if you must code all that logic yourself, you
might miss something and get it wrong. Imagine all the code that’s out there where
the programmers didn’t think through all the implications of cleanup, and did it
wrong. For that reason you should always use try-with-resources whenever you can.
It helps a lot that the feature also makes the resulting code much cleaner and easier
to understand.
 */
