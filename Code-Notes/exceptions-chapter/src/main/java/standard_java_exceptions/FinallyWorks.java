package standard_java_exceptions;

class ThreeException extends Exception {}

public class FinallyWorks {
    static int count = 0;

    public static void main(String[] args) {
        while (true) {
            try {
                // Post-increment is zero first time:
                if (count++ == 0) {
                    throw new ThreeException();
                }
                System.out.println("No exception");
            } catch (ThreeException e) {
                System.out.println("ThreeException");
            } finally { // Activities that happen every time
                System.out.println("In finally clause");
                if (count == 2) break;
            }
        }
    }
}

/*
There’s often a piece of code you must execute whether or not an exception is
thrown within a try block. This usually pertains to an operation other than memory
recovery (that’s handled by the garbage collector). To achieve this effect, you use
a finally clause at the end of all the exception handlers. The full picture of
exception-handling is thus:
 */
