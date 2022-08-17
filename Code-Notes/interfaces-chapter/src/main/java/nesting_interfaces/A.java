package nesting_interfaces;

/*
    Interfaces can be nested within classes and within other interfaces.
    This reveals several interesting features:
 */

class A {
    interface B {
        void f();
    }

    public class BImp implements B {
        @Override
        public void f() {}
    }

    public class BImp2 implements B {
        @Override
        public void f() {}
    }

    public interface C {
        void f();
    }

    class CImp implements C {
        @Override
        public void f() {}
    }

    private class CImp2 implements C {
        @Override
        public void f() {}
    }

    private interface D {
        void f();
    }

    private class DImp implements D {
        @Override
        public void f() {}
    }

    private class DImp2 implements D {
        @Override
        public void f() {}
    }

    /*
        The method getD() produces a further quandary concerning the private interface:
        It’s a public method that returns a reference to a private interface. What can you
        do with the return value of this method? main() shows several attempts to use the
        return value, all of which fail. The return value must be handed to an object that has
        permission to use it—here, another A, via the receiveD() method.
     */
    public D getD() { return new DImp2(); }
    private D dRef;
    public void receiveD(D d) {
        dRef = d;
        dRef.f();
    }
}
