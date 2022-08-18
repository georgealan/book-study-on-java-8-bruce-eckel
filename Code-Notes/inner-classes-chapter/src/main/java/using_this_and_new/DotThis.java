package using_this_and_new;

/*
Accessing the outer-class object

To produce the reference to the outer-class object, you name the outer class followed
by a dot and this. The resulting reference is automatically the correct type, known
and checked at compile time, so there is no runtime overhead.


 */

public class DotThis {
    void f() { System.out.println("DotThis.f()"); }

    public class Inner {
        public DotThis outer() {
            return DotThis.this; // A plain "this" would be Inner's "this"
        }
    }

    // Method that create a instance of Inner class.
    public Inner inner() { return new Inner(); }

    public static void main(String[] args) {
        DotThis dt = new DotThis();
        DotThis.Inner dti = dt.inner();
        dti.outer().f();
    }
}
