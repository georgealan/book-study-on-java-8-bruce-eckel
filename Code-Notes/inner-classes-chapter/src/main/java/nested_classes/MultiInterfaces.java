package nested_classes;

/*
    consider a situation where you have two interfaces that must somehow be implemented  within a class.
    Because of the flexibility of interfaces, you have two choices: a single class or an inner class.

    Two ways a class can implement multiple interfaces
 */

interface A {}
interface B {}

class X implements A, B {}

class Y implements A {
    B makeB() {
        // Anonymous inner class:
        return new B() {};
    }
}

public class MultiInterfaces {
    static void takesA(A a) {}
    static void takesB(B b) {}

    public static void main(String[] args) {
        X x = new X();
        Y y = new Y();

        takesA(x);
        takesA(y);
        takesB(x);
        takesB(y.makeB());
    }

    /*
    This assumes the structure of your code makes logical sense either way. You’ll
    ordinarily have some kind of guidance from the nature of the problem about whether
    to use a single class or an inner class. But without any other constraints, the
    approach in the preceding example doesn’t really make much difference from an
    implementation standpoint. Both of them work.
     */
}
