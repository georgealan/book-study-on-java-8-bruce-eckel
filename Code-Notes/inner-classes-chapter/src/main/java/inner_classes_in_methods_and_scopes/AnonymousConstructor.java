package inner_classes_in_methods_and_scopes;

abstract class Base {
    Base(int i) {
        System.out.println("Base constructor, i = " + i);
    }
    public abstract void f();
}

public class AnonymousConstructor {
    /*
    Here, the variable i did not have to be final. While i is passed to the base
    constructor of the anonymous class, it is never directly used inside the anonymous
    class.
     */
    public static Base getBase(int i) {

        return new Base(i) {

            {
                System.out.println("Inside instance initializer");
            }

            @Override
            public void f() {
                System.out.println("In anonymous f()");
            }
        };
    }

    public static void main(String[] args) {
        Base base = getBase(47);
        base.f();
    }
}




