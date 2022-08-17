package private_methods_in_interfaces;

/*
With the introduction of default and static methods in interfaces, it became possible to write method code in an
interface that you might not want to be public. In Old, fd() and fs() are default and static methods, respectively.
These methods are only called by f() and g(), so we’d like them to be private:
 */

interface Old {
    default void fd() {
        System.out.println("Old::fd()");
    }

    static void fs() {
        System.out.println("Old::fs()");
    }

    default void f() {
        fd();
    }

    static void g() {
        fs();
    }
}

class ImplOld implements Old {}

/*
JDK9 turns fd() and fs() into private methods using the feature finalized in JDK
9. Note that fd() no longer needs the default keyword, as making it private automatically makes it default.
 */
interface JDK9 {
    private void fd() { // Automatically default
        System.out.println("JDK9::fd()");
    }

    private static void fs() {
        System.out.println("JDK9::fs()");
    }

    default void f() {
        fd();
    }

    static void g() {
        fs();
    }
}

class ImplJDK9 implements JDK9 {}

public class PrivateInterfaceMethods {
    public static void main(String[] args) {
        new ImplOld().f();
        Old.g();

        new ImplJDK9().f();
        JDK9.g();
    }

}
