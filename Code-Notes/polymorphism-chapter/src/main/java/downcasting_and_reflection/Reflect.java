package downcasting_and_reflection;

/**
 *
 */

class Useful {
    public void f() {}
    public void g() {}
}

class MoreUseful extends Useful {
    @Override
    public void f() {}

    @Override
    public void g() {}

    public void u() {}
    public void v() {}
    public void w() {}
}

public class Reflect {
    public static void main(String[] args) {
        Useful[] x = {
            new Useful(),
            new MoreUseful()
        };

        x[0].f();
        x[1].g();

        // Compile time: method not found in Useful:
        //- x[1].u();

        /*
        To access the extended interface of a MoreUseful object, you can try downcasting.
        If it’s the correct type, it is successful. Otherwise, you’ll get a ClassCastException.
        You don’t write any special code for this exception because it indicates a programmer
        error that could happen anywhere in a program.
         */
        ((MoreUseful)x[1]).u(); // Downcast / Reflect
        ((MoreUseful)x[0]).u(); // Exception thrown
    }
}
