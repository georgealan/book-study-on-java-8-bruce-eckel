package function_composition;

import java.util.function.Function;

// This example uses both compose() and andThen() from Function:
public class FunctionComposition {
    static Function<String, String>
        f1 = s -> {
        System.out.println(s);
        return s.replace('A', '_');
        },
        f2 = s -> s.substring(3),
        f3 = s -> s.toLowerCase(),
        f4 = f1.compose(f2).andThen(f3);

    public static void main(String[] args) {
        System.out.println(f4.apply("GO AFTER ALL AMBULANCES"));
    }

    /*
    The important thing to see here is that we are creating a new function f4, which can
    then be called using apply() (almost) like any other function.
    By the time f1 gets the String, it’s already had the first three characters stripped
    off by f2. That’s because the call to compose(f2) means f2 gets called before f1.
     */
}
