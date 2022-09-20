package standard_java_exceptions;

class A {
    String s;
    A(String s) {
        this.s = s;
    }
}
class B {
    A a;
    B(A a) {
        this.a = a;
    }
}
class C {
    B b;
    C(B b) {
        this.b = b;
    }
}

public class BetterNullPointerReports {
    public static void main(String[] args) {
        C[] ca = {
                new C(new B(new A(null))),
                new C(new B(null)),
                new C(null)
        };

        for (C c : ca) {
            try {
                System.out.println(c.b.a.s);
            } catch (NullPointerException npe) {
                System.out.println(npe);
            }
        }
    }
}
