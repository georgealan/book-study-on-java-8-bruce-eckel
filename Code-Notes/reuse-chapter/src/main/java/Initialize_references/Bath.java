package Initialize_references;

/**
 * Constructor initialization with composition
 *
 * There are four ways to initialize references, because when compiler create a references to an Object doesn't create
 * a default object for every reference, but every object reference are initialized to null.
 *
 */

class Soap {
    private String s;
    Soap() {
        System.out.println("Soap()");
        s = "Constructed";
    }

    @Override
    public String toString() {
        return s;
    }
}

public class Bath {
    private String s1 = "Happy", s2 = "Happy", s3, s4;
    private Soap castile;
    private int i;
    private float toy;

    public Bath() {
        System.out.println("Inside Bath()");
        s3 = "Joy";
        toy = 3.14f;
        castile = new Soap();
    }

    { i = 47; } // Instance initialization

    @Override
    public String toString() {
        if (s4 == null) { // Delayed initialization:
            s4 = "Joy";
        }
        return
            "s1 = " + s1 + "\n" +
            "s2 = " + s2 + "\n" +
            "s3 = " + s3 + "\n" +
            "s4 = " + s4 + "\n" +
            "toy = " + toy + "\n" +
            "castile = " + castile;
    }

    public static void main(String[] args) {
        Bath b = new Bath();
        System.out.println(b);
    }
}
