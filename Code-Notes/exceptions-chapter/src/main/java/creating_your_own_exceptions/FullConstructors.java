package creating_your_own_exceptions;

class MyException extends Exception {
    MyException() {}
    MyException(String msg) { super(msg); }
}

public class FullConstructors {
    public static void f() throws MyException {
        System.out.println("Throwing MyException from f()");
        throw new MyException();
    }

    public static void g() throws MyException {
        System.out.println("Throwing MyException from g()");
        throw new MyException("Originated in g()");
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }

        try {
            g();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }
    }
}

/*
The added code is small: two constructors that define the way you create MyException.
In the second constructor, the base-class constructor with a String argument
is explicitly invoked using the super keyword.

In the handlers, one of the Throwable (from which Exception is inherited) methods
is called: printStackTrace(). As shown in the output, this produces information
about the sequence of method calls to get to the point where the exception happened.
Here, the information is sent to System.out, and automatically captured and
displayed in the output. However, if you call the default version:

e.printStackTrace();

the information goes to the standard error stream.
 */
