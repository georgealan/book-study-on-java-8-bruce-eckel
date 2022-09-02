package recursion;

interface IntCall {
    int call(int arg);
}

public class RecursiveFactorial {
    static IntCall fact;
    /*
    you cannot initialize fact at the point of definition like this:
    static IntCall fact = n -> n == 0 ? 1 : n * fact.call(n - 1);
     */

    public static void main(String[] args) {
        fact = n -> n == 0 ? 1 : n * fact.call(n - 1);
        for (int i = 0; i <= 10; i++) {
            System.out.println(fact.call(i));
        }
    }

    /*
    Recursion means that a function calls itself. It’s possible to write recursive lambda
    expressions in Java, with a caveat: The lambda must be assigned to either a static
    variable or an instance variable, otherwise you’ll get a compile-time error.
     */
}
