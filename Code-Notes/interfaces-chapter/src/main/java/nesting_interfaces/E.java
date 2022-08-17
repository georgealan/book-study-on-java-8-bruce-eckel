package nesting_interfaces;

/*
    Interface E shows that interfaces can be nested within each other. However, the
    rules about interfaces—in particular, that all interface elements must be public—are
    strictly enforced here, so an interface nested within another interface is automatically
    public and cannot be made private.
 */

interface E {
    interface G {
        void f();
    }

    public interface H {
        void f();
    }

    void g();

    // Cannot be private within an interface
    // private interface I {}
}
