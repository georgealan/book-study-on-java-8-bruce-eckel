package performing_cleanup_with_finally;

class FourException extends Exception {}

/*
Even in cases when the exception is not caught in the current set of catch clauses,
finally is executed before the exception-handling mechanism continues its search
for a handler at the next higher level:
 */
public class AlwaysFinally {
    public static void main(String[] args) {
        System.out.println("Entering first try block");
        try {
            System.out.println("Entering second try block");
            try {
                throw new FourException();
            } finally {
                System.out.println("finally in 2nd try block");
            }
        } catch (FourException e) {
            System.out.println("Caught FourException in 1st try block");
        } finally {
            System.out.println("finally in 1st try block");
        }
    }
}

/*
The finally statement is also executed when break and continue statements
are involved. Together with the labeled break and labeled continue, finally
eliminates the need for a goto statement in Java.
 */
