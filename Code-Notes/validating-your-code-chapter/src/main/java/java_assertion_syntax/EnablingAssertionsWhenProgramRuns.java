package java_assertion_syntax;

/*
to decide to require assertions enabled when the program runs.
You can accomplish this with the following static clause, placed
in the main class of your system:
 */
public class EnablingAssertionsWhenProgramRuns {
    static {
        boolean assertionsEnabled = false;
        // Note intentonal side effect of assignment
        assert assertionsEnabled = true;
        if (!assertionsEnabled) {
            throw new RuntimeException("Assertions disabled");
        }
    }

    public static void main(String[] args) {

    }
}

/*
If assertions are enabled, then the assert statement executes and assertionsEnabled
becomes true. The assertion never fails because the return value of the
assignment is the assigned value. If assertions are not enabled, the assert statement
doesn’t execute and assertionsEnabled remains false, resulting in the exception.
 */
