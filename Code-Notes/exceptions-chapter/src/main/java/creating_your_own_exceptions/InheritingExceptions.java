package creating_your_own_exceptions;

class SimpleException extends Exception {}

public class InheritingExceptions {
    public void f() throws SimpleException {
        System.out.println("Throw SimpleException from f()");
        throw new SimpleException();
    }

    public static void main(String[] args) {
        InheritingExceptions sed = new InheritingExceptions();

        try {
            sed.f();
        } catch (SimpleException e) {
            System.out.println("Caught it!");
        }
    }
}

/*
Here, the result is displayed on the console. You can also send error output to the
standard error stream by writing to System.err. This is usually a better place to
send error information than System.out, which can be redirected. If you send output
to System.err, it is not redirected along with System.out so the user is more likely
to notice it.
 */
