package java_assertion_syntax;

/*
There’s one other way you can control assertions: programmatically, by hooking
into the ClassLoader object. There are several methods in ClassLoader that allow
the dynamic enabling and disabling of assertions, including setDefaultAssertion-
Status(), which sets the assertion status for all the classes loaded afterward. So you
might think you can silently turn on assertions like this:
 */
public class LoaderAssertions {
    public static void main(String[] args) {
        ClassLoader.getSystemClassLoader().setDefaultAssertionStatus(true);
        new Loaded().go();
    }
}

class Loaded {
    public void go() {
        assert false: "Loaded go()";
    }
}

/*
This eliminates the need for the -ea flag on the command line when running the
program. It may be just as straightforward to enable assertions using the -ea flag.
When delivering a standalone product, you probably have to set up an execution
script enabling the user to start the program anyway, to configure other startup
parameters.
 */
