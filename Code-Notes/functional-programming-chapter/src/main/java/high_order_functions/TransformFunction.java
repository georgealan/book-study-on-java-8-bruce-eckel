package high_order_functions;

import java.util.function.Function;

class I {
    @Override public String toString() { return "I"; }
}

class O {
    @Override public String toString() { return "O"; }
}

/*
Things get particularly interesting when you produce a new function based on the consumed function:
 */
public class TransformFunction {
    static Function<I, O> transform(Function<I, O> in) {
        return in.andThen(o -> {
            System.out.println(o);
            return o;
        });
    }

    public static void main(String[] args) {
        Function<I, O> f2 = transform(i -> {
            System.out.println(i);
            return new O();
        });
        O o = f2.apply(new I());
    }

    /*
    here, transform() produces a function with the same signature as the one passed
    in, but you can produce any kind you’d like.

    This uses a default method in the Function interface called andThen() which is
    specifically designed for manipulating functions. As the name implies, andThen() is
    invoked after the in function is called (there’s also compose(), which applies the new
    function before the in function). To attach an andThen() function, we simply pass
    that function as an argument. What comes out of transform() is a new function,
    which combines the action of in with that of the andThen() argument.
     */
}
