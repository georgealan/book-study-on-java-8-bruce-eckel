package high_order_functions;

import java.util.function.Function;

/*
A higher-order function is simply a function that consumes or produces functions.
 */
interface FuncSS extends Function<String, String> {} // [1]
interface FuncSI extends Function<String, Integer> {}
interface FuncSAC extends Function<String, Character> {}

public class ProduceFunction {
    static FuncSS produce() {
        return s -> s.toLowerCase();                 // [2]
    }
    static FuncSS produce2() {
        return String::toUpperCase;                  // [3]
    }
    static FuncSI produce3() {
        return String::length;
    }
    static FuncSAC produce4() {
        return s -> s.charAt(0);
    }

    public static void main(String[] args) {
        FuncSS f = produce();
        System.out.println(f.apply("GEORGE"));

        f = produce2();
        System.out.println(f.apply("the rabbit is fast!"));

        FuncSI g = produce3();
        System.out.println(g.apply("this phrase contain words pal!"));

        FuncSAC h = produce4();
        System.out.println(h.apply("Another word for my buddy"));
    }

    /*
    Here, produce() is the higher-order function.
    • [1] Using inheritance, you can easily create an alias for a specialized interface.
    • [2] With lambda expressions, it becomes almost effortless to create and return a function from within a method.
    • [3] Using method reference.

     */
}
