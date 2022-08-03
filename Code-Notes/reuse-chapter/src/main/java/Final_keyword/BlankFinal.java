package Final_keyword;

class Poppet {
    private int i;
    Poppet(int ii) { i = ii; }
}

/**
 * You're forced to perform assignments to finals either with an expression at the point of definition
 * of the field or in every constructor. This guarantees that the final field is always initialized before use.
 */
public class BlankFinal {
    private final int i = 0; // Initialized final
    private final int j; // Blank final
    private final Poppet p; // Blank final reference

    // Blank finals MUST be initialized in constructor:
    public BlankFinal() {
        j = 1; // Initialize blank final
        p = new Poppet(j); // Init blank final reference
    }

    public BlankFinal(int x) {
        j = 1; // Initialize blank final
        p = new Poppet(x); // Init blank final reference
    }

    public static void main(String[] args) {
        new BlankFinal();
        new BlankFinal(47);
    }
}
