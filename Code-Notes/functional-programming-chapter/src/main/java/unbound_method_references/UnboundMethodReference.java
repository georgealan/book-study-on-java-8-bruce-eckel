package unbound_method_references;

/*
An unbound method reference refers to an ordinary (non-static) method, without an
associated object. To apply an unbound reference, you must supply the object:
 */

class X {
    String f() { return "X::f()"; }
}

interface MakeString {
    String make();
}

interface TransformX {
    String transform(X x);
}

public class UnboundMethodReference {
    public static void main(String[] args) {
        // MakeString ms = X::f;                 // [1]
        TransformX sp = X::f;
        X x = new X();

        System.out.println(sp.transform(x));     // [2]
        System.out.println(x.f()); // Same effect
    }

/*
So far, we’ve seen references to methods that have the same signature as their
associated interface. At [1], we try to do the same thing for f() in X, attempting to
assign to a MakeString. This produces an error from the compiler about an invalid
method reference, even though make() has the same signature as f(). The problem
is that there’s actually another (hidden) argument involved: our old friend this. You
can’t call f() without an X object to call it upon. Thus, X::f represents an unbound
method reference, because it hasn’t been bound to an object.

To solve the problem we need an X object, so our interface actually needs an extra
argument, as you see in TransformX. If you assign X::f to a TransformX, Java is
happy. We must now make a second mental adjustment—with an unbound reference,
the signature of the functional method (the single method in the interface) no longer
quite matches the signature of the method reference. There’s a good reason, which
is that you need an object to call the method on.

The result at [2] is a bit of a brain-teaser. I take the unbound reference and call
transform() on it, passing it an X, and somehow that results in the call to x.f().
Java knows it must take the first argument, which is effectively this, and call the
method on it.
 */
}
