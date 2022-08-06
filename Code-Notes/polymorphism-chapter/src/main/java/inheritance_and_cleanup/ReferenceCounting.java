package inheritance_and_cleanup;

class Shared {
    private int refCount = 0;
    private static long counter = 0; // The type of counter is long rather than int, to prevent overflow this is just good practice.
    private final long id = counter++;

    Shared() {
        System.out.println("Creating " + this);
    }

    public void addRef() {
        refCount++;
    }

    protected void dispose() {
        if (--refCount == 0) {
            System.out.println("Disposing " + this);
        }
    }

    @Override public String toString() {
        return "Shared " + id;
    }
}

class Composing {
    private Shared shared;
    private static long counter = 0;
    private final long id = counter++;

    /**
     * When you attach a shared object to your class, you must remember to call addRef(),
     * but the dispose() method will keep track of the reference count and decide when
     * to actually perform the cleanup. This technique requires extra diligence to use, but
     * if you are sharing objects that require cleanup you don’t have much choice.
     */
    Composing(Shared shared) {
        System.out.println("Creating " + this);
        this.shared = shared;
        this.shared.addRef();
    }

    protected void dispose() {
        System.out.println("Disposing " + this);
        shared.dispose();
    }

    @Override public String toString() {
        return "Composing " + id;
    }
}

public class ReferenceCounting {
    public static void main(String[] args) {
        Shared shared = new Shared();
        Composing[] composings = {
            new Composing(shared),
            new Composing(shared),
            new Composing(shared),
            new Composing(shared),
            new Composing(shared),
        };

        for (Composing c : composings) {
            c.dispose();
        }
    }
}
