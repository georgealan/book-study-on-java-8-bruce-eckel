package functional_interfaces;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

@FunctionalInterface
interface Functional {
    String goodbye(String arg);
}
/*
The @FunctionalInterface annotation is optional; Java treats both Functional and FunctionalNoAnn as functional
interfaces in main(). The value of @FunctionalInterface is seen in the definition of NotFunctional:
More than one method in your interface produces a compile-time error message.
 */

interface FunctionalNoAnn {
    String goodBye(String arg);
}

/*
@FunctionalInterface
interface NotFunctional {
String goodbye(String arg);
String hello(String arg);
}
Produces error message:
NotFunctional is not a functional interface
multiple non-overriding abstract methods
found in interface NotFunctional
*/

public class FunctionalAnnotation {
    public String goodbye(String arg) {
        return "Goodbye, " + arg;
    }

    public static void main(String[] args) {
        FunctionalAnnotation fa = new FunctionalAnnotation();
        Functional f = fa::goodbye;
        FunctionalNoAnn fna = fa::goodbye;
        IntConsumer df = new IntConsumer() {
            @Override
            public void accept(int value) {

            }
        };
        //Functional fac = fa; // Incompatible
        Functional fl = arg -> "Goodbye, " + arg;
        FunctionalNoAnn fnal = arg -> "Goodbye, " + arg;
    }
}
