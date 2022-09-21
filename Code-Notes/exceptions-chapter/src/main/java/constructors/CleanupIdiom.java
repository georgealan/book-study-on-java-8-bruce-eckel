package constructors;

/* Disposable objects must be followed by a try-finally
The basic rule is: Right after you create an object that requires cleanup, begin a try-finally:
 */
class NeedsCleanup { // Construction can't fail
    private static long counter = 1;
    private final long id = counter++;
    public void dispose() {
        System.out.println("NeedsCleanup " + id + " disposed");
    }
}

class ConstructionException extends Exception {}
class NeedsCleanup2 extends NeedsCleanup {
    // Construction can fail
    NeedsCleanup2() throws ConstructionException {}
}

public class CleanupIdiom {
    public static void main(String[] args) {
        // [1]
        NeedsCleanup nc1 = new NeedsCleanup();
        try {
            // ...
        } finally {
            nc1.dispose();
        }

        // [2]
        // If construction cannot fail, you can group objects.
        NeedsCleanup nc2 = new NeedsCleanup();
        NeedsCleanup nc3 = new NeedsCleanup();
        try {
            // ...
        } finally {
            nc3.dispose(); // Reverse order of construction
            nc2.dispose();
        }

        // [3]
        // If construction can fal you must guard each one
        try {
            NeedsCleanup2 nc4 = new NeedsCleanup2();
            try {
                NeedsCleanup2 nc5 = new NeedsCleanup2();
                try {
                    // ...
                } finally {
                    nc5.dispose();
                }
            } catch (ConstructionException e ) {
                System.out.println(e);
            } finally {
                nc4.dispose();
            }
        } catch (ConstructionException e) {
            System.out.println(e);
        }
    }
}

/*
• [1] This is fairly straightforward: You follow a disposable object with a try-finally.
If the object construction cannot fail, no catch is necessary.

• [2] Here you see objects with constructors that cannot fail grouped together for
both construction and cleanup.

• [3] This shows how to deal with objects whose constructors can fail and which
need cleanup. To properly handle this situation, things get messy, because you
must surround each construction with its own try-catch, and each object
construction must be followed by a try-finally to guarantee cleanup.
 */
