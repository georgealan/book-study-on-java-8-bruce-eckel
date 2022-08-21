package closures_and_callbacks;

interface Incrementable {
    void increment();
}

// Very simple to just implement the interface:
class Callee1 implements Incrementable {
    private int i = 0;

    @Override
    public void increment() {
        i++;
        System.out.println(i);
    }
}

class MyIncrement {
    public void increment() {
        System.out.println("Other operation");
    }
    static void f(MyIncrement mi) { mi.increment(); }
}

// If your class must implement increment() in some other way, you must use an inner class:
class Callee2 extends MyIncrement {
    private int i = 0;

    /*
        When MyIncrement is inherited into Callee2, increment() can’t be overridden for use by Incrementable,
        so you’re forced to provide a separate implementation using an inner class. Also note that when you
        create an inner class, you do not add to or modify the interface of the outer class.
     */
    @Override
    public void increment() {
        super.increment();
        i++;
        System.out.println(i);
    }

    /*
        The inner class Closure implements Incrementable to provide a hook back into
        Callee2—but a safe hook. Whoever gets the Incrementable reference can only call
        increment() and has no other abilities (unlike a pointer, which would allow you to
        run wild).
     */
    private class Closure implements Incrementable {
        @Override
        public void increment() {
            // Specify outer-class method, otherwise you'll get an infinite recursion.
            Callee2.this.increment();
        }
    }

    /*
        Everything except getCallbackReference() in Callee2 is private. To allow any
        connection to the outside world, the interface Incrementable is essential. Here you
        see how interfaces allow for a complete separation of interface from implementation.
     */

    Incrementable getCallbackReference() {
        return new Closure();
    }
}

/*
    Caller takes an Incrementable reference in its constructor (although capturing
    the callback reference can happen at any time) and then, sometime later, uses the
    reference to call back into the Callee class.
 */
class Caller {
    private Incrementable callbackReference;

    Caller(Incrementable cbh) {
        callbackReference = cbh;
    }

    void go() { callbackReference.increment(); }
}

public class Callbacks {
    public static void main(String[] args) {
        Callee1 c1 = new Callee1();
        Callee2 c2 = new Callee2();
        MyIncrement.f(c2);
        Caller caller1 = new Caller(c1);
        Caller caller2 = new Caller(c2.getCallbackReference());

        caller1.go();
        caller1.go();
        caller2.go();
        caller2.go();
    }
}
