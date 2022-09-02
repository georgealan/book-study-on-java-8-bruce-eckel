package lambda_expressions;

interface Description {
    String brief();
}

interface Body {
    String detailed(String head);
}

interface Multi {
    String twoArg(String head, Double d);
}

public class LambdaExpressions {
    static Body bod = h -> h + " No Parens!";          // [1]

    static Body bod2 = (h) -> h + " More details";    // [2]

    static Description desc = () -> "Short info";     // [3]

    static Multi mult = (h, n) -> h + n;              // [4]

    static Description moreLines = () -> {            // [5]
        System.out.println("moreLines()");
        return "from moreLines()";
    };

    public static void main(String[] args) {
        System.out.println(bod.detailed("Oh!"));
        System.out.println(bod2.detailed("Hi!"));
        System.out.println(desc.brief());
        System.out.println(mult.twoArg("Pi!", 3.14159));
        System.out.println(moreLines.brief());
    }

/*
We start with three interfaces, each with a single method (you’ll understand the significance of this shortly).
However, each method has a different number of arguments, in order to demonstrate lambda expression syntax.
The basic syntax of any lambda expression is:

1. The arguments.
2. Followed by the ->, which you might choose to read as produces.
3. Everything after the -> is the method body.

• [1] With a single argument, you can just say it without parentheses. This, however, is a special case.

• [2] The normal case is to use parentheses around the arguments. For consistency, you can also use parentheses
around a single argument, although this is not commonly done.

• [3] With no arguments, you must use parentheses to indicate an empty argument list.

• [4] For more than one argument, place them in a parenthesized argument list. So far, all the lambda expression
method bodies have been a single line. The result of that expression automatically becomes the return value of
the lambda expression, and it’s illegal to use the return keyword here. This is another way that lambda expressions
abbreviate the syntax for describing functionality.

• [5] If you do need multiple lines in your lambda expression, you must put those lines inside curly braces.
In this situation, you revert to using return to produce a value from the lambda expression.

Lambda expressions typically produce more readable code than anonymous inner classes.
 */
}
