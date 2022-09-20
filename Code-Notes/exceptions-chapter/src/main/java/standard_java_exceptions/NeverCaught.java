package standard_java_exceptions;

public class NeverCaught {
    static void f() {
        throw new RuntimeException("from f()");
    }
    static void g() {
        f();
    }

    public static void main(String[] args) {
        g();
    }
}

/*
If a RuntimeException gets all the way out to main() without being caught, printStackTrace() is called for that
exception as the program exits. You can see that a RuntimeException (or anything inherited from it) is a special
case because the compiler doesn’t require an exception specification for these types. The output is reported
to System.err.

Keep in mind that only exceptions of type RuntimeException (and subclasses) can be ignored in your coding because
the compiler carefully enforces the handling of all checked exceptions.
You cannot classify Java exception handling as a single-purpose tool. Yes, it is designed to handle those pesky
runtime errors that occur from forces outside your code’s control, but it’s also essential for certain types of
programming bugs that the compiler cannot detect.
 */
