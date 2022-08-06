package default_methods;

/*
    Java 8 creates an additional use for the default keyword (formerly used only
    in switch statements and annotations). When used within an interface, default
    creates a method body that is substituted whenever the interface is implemented
    without defining that method.

    The compelling reason to add default methods is that they allow you to add
    methods to an existing interface without breaking all the code that already uses that
    interface. default methods are sometimes also called defender methods or virtual
    extension methods.

    In JDK 9, both default and static interface methods are allowed to be private.
 */

interface AnInterface {
    void firstMethod();
    void secondMethod();

    /*
        If we use the default keyword and provide a default definition for newMethod(),
        all existing uses of the interface can continue to work, untouched, while new code
        can call newMethod()
     */
    default void newMethod() {
        System.out.println("newMethod");
    }
}

public class AnImplementation implements AnInterface {
    @Override
    public void firstMethod() {
        System.out.println("firstMethod");
    }

    @Override
    public void secondMethod() {
        System.out.println("secondMethod");
    }

    /*
        The default keyword allows method implementations within interfaces—before
        Java 8 this was not permitted.
     */
    public static void main(String[] args) {
        AnInterface i = new AnImplementation();
        i.firstMethod();
        i.secondMethod();
        i.newMethod();
    }
}
