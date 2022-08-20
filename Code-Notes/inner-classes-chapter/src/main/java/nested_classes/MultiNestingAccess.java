package nested_classes;

// Nested classes can access all members of all levels of the classes they are nested within.

/*
It doesn’t matter how deeply an inner class is nested—it can transparently access all
members of all classes it is nested within, as seen here:
 */

class MNA {
    private void f() {}
    class A {
        private void g() {}
        public class B {
            void h() {
                g();
                f();
            }
        }
    }
}

public class MultiNestingAccess {
    public static void main(String[] args) {
        MNA mna = new MNA();
        MNA.A mnaa = mna.new A();
        MNA.A.B mnaab = mnaa.new B();
        mnaab.h();
    }
}
