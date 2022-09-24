package java_assertion_syntax;

/*
If you run the program normally, without any special assertion flags, nothing
happens. You must explicitly enable assertions when you run the program. The
easiest way to do this is with the -ea flag, which can also be spelled out: -
enableassertions. This runs the program and executes any assertion statements.
 */
public class Assert1 {
    public static void main(String[] args) {
        assert false;
    }
}
