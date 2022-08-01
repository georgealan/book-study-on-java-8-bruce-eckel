package Initialize_references;

/**
 * Constructor calls during inheritance
 *
 * Here the construction happens in the base outward, so the base class is initialized before the derived class
 * constructors can access it.
 * Even if you don't create a constructor for Cartoon, the compiler will syntetize a zero-argument constructor
 * for you that calls the base class constructor. Try removing the Cartoon constructor to see this.
 */

class Art { // Her ewill be the first class be initialized, before Drawing above.
    Art() {
        System.out.println("Art constructor");
    }
}

class Drawing extends Art { // The second class be initialized.
    Drawing() {
        System.out.println("Drawing constructor");
    }
}

public class Cartoon extends Drawing {
    public Cartoon() {
        System.out.println("Cartoon constructor");
    }

    public static void main(String[] args) {
        Cartoon x = new Cartoon();
    }
}
