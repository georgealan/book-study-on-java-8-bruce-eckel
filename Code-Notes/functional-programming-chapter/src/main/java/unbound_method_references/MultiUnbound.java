package unbound_method_references;

/*
If your method has more arguments, just follow the pattern of the first argument taking this:
 */

class This {
    void two(int i, double d) {}
    void three(int i, double d, String s) {}
    void four(int i, double d, String s, char c) {}
}

interface TwoArgs {
    void call2(This athis, int i, double d);
}

interface ThreeArgs {
    void call3(This athis, int i, double d, String s);
}

interface FourArgs {
    void call4(This athis, int i, double d, String s, char c);
}

public class MultiUnbound {
    public static void main(String[] args) {

        TwoArgs twoArgs = This::two;
        ThreeArgs threeArgs = This::three;
        FourArgs fourArgs = This::four;

        This athis = new This();

        twoArgs.call2(athis, 11, 3.14);
        threeArgs.call3(athis, 11, 3.14, "Three");
        fourArgs.call4(athis, 11, 3.14, "Four", 'Z');
    }

    /*
    To make a point, I named the class This and the first arguments for the functional
    methods athis, but you should choose other names to prevent confusion in production
    code.
     */
}
