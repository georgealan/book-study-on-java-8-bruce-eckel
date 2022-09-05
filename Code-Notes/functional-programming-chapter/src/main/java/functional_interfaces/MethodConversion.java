package functional_interfaces;

import java.util.function.BiConsumer;

class In1 {}
class In2 {}

public class MethodConversion {
    static void accept(In1 i1, In2 i2) {
        System.out.println("accept()");
    }
    static void someOtherName(In1 i1, In2 i2) {
        System.out.println("someOtherName()");
    }

    public static void main(String[] args) {
        BiConsumer<In1, In2> bic;

        bic = MethodConversion::accept;
        bic.accept(new In1(), new In2());

        /*
        Look up the documentation for BiConsumer. You’ll see its functional method is
        accept(). Indeed, if we name our method accept(), it works as a method reference.
        But we can give it a completely different name like someOtherName() and it works
        as well, as long as the argument types and return type are the same as BiConsumer’s
        accept().
         */
        bic = MethodConversion::someOtherName;

        // bic.someOtherName(new In1(), new In2()); // Nope

        bic.accept(new In1(), new In2());
    }

    /*
    when working with functional interfaces, the name doesn’t matter—only the
    argument types and return type. Java performs a mapping of your name onto the
    functional method of the interface. To invoke your method, you call the functional
    method name (accept(), in this case), not your method name.
     */
}
