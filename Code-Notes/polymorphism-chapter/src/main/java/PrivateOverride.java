/**
 * You might reasonably expect the output to be “public f()”, but a private method
 * is automatically final, and is also hidden from the derived class. So Derived’s f()
 * here is a brand new method; it’s not even overloaded because the base-class version
 * of f() isn’t visible in Derived.
 *
 * The result of this is that only non-private methods can be overridden, but watch
 * out for the appearance of overriding private methods, which generates no compiler
 * warnings, but doesn’t do what you might expect. To be clear, use a different name
 * from a private base-class method in your derived class.
 */
public class PrivateOverride {

//    public void f() {
//        System.out.println("private f()");
//    }

    private void f() {
        System.out.println("private f()");
    }

    public static void main(String[] args) {
        PrivateOverride po = new Derived();
        po.f();
    }
}

class Derived extends PrivateOverride {

    // This public method above will be called if uncomment the method f() public in PrivateOverride class above
    public void f() {
        System.out.println("public f()");
    }
}
