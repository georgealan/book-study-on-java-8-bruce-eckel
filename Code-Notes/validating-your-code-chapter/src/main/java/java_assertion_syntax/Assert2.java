package java_assertion_syntax;

public class Assert2 {
    public static void main(String[] args) {
        assert false:
               "Here's a message saying what's happened";
    }
}

/*
if you use the information-expression, you’ll produce a helpful message as part of the
exception stack trace. The most useful information-expression is typically a String
of text directed at the programmer.

The information-expression can produce any kind of object, so you typically construct
a more complex String containing the value(s) of objects that were involved
with the failed assertion.
 */