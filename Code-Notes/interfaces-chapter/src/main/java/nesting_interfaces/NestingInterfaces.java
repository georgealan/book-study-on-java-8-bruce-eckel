package nesting_interfaces;

/*
    NestingInterfaces shows the various ways that nested interfaces can be implemented.
    In particular, notice that when you implement an interface, you are not
    required to implement any interfaces nested within. Also, private interfaces cannot
    be implemented outside of their defining classes.
 */

public class NestingInterfaces {
    public class BImp implements A.B {
        @Override
        public void f() {}
    }

    class CImp implements A.C {
        @Override
        public void f() {}
    }

    // Cannot implement a private interface except within that interface's definition class:
//    class DImp implements A.D {
//        @Override
//        public void f() {}
//    }

    class EImp implements E {
        @Override
        public void g() {}
    }

    class EGImp implements E.G {
        @Override
        public void f() {}
    }

    class EImp2 implements E {
        @Override
        public void g() {}

        class EG implements E.G {
            @Override
            public void f() {}
        }
    }

    public static void main(String[] args) {
        A a = new A();

        // Can't access A.D
        //A.D ad = a.getD();

        // Doesn't return anything but A.D
        //A.DImp2 di2 = a.getD();

        // Cannot access a member of the interface
        //a.getD().f();

        // Only another A can do anything with getD():
        A a2 = new A();
        a2.receiveD(a.getD());
    }

}
