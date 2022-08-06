package polymorphic_methods_inside_constructors;

/**
 * If you call a dynamically bound method inside a constructor, the overridden
 * definition for that method is also used. However, the effect of this call can be
 * rather unexpected because the overridden method is called before the object is fully
 * constructed. This can conceal some difficult-to-find bugs.
 *
 * Conceptually, the constructor’s job is to bring the object into existence (hardly an
 * ordinary feat). Inside any constructor, the entire object might be only partially
 * formed—you can only know that the base-class objects are initialized. If the constructor
 * is only one step in building an object of a class that’s been derived from that
 * constructor’s class, the derived parts have not yet been initialized at the time the
 * current constructor is called. A dynamically bound method call, however, reaches
 * “outward” into the inheritance hierarchy. It calls a method in a derived class. If you
 * do this inside a constructor, you can call a method that might manipulate members
 * that haven’t been initialized yet—a sure recipe for disaster.
 */

class Glyph {

    /**
     * Glyph.draw() is designed for overriding, which happens in RoundGlyph. But the Glyph constructor calls this method,
     * and the call ends up in RoundGlyph.draw(), which would seem to be the intent. The output shows that when Glyph’s
     * constructor calls draw(), the value of radius isn’t even the default initial value 1. It’s 0.
     * This would probably result in either a dot or nothing at all drawn on the screen, and you’d
     * be left staring, trying to figure out why the program won’t work.
     *
     * The order of initialization described in the earlier section isn’t quite complete, and
     * that’s the key to solving the mystery. The actual process of initialization is:
     *
     *      1. The storage allocated for the object is initialized to binary zero before anything else happens.
     *      2. The base-class constructors are called as described previously. Now the overridden draw() method is called
     *         (yes, before the RoundGlyph constructor is called), which discovers a radius value of zero, due to Step 1.
     *      3. Member initializers are called in the order of declaration.
     *      4. The body of the derived-class constructor is called.
     */

    void draw() {
        System.out.println("Glyph.draw()");
    }

    /**
     * As a result, a good guideline for constructors is “Do as little as possible to set
     * the object into a good state, and if you can possibly avoid it, don’t call any other
     * methods in this class.” The only safe methods to call inside a constructor are those
     * that are final in the base class. (This also applies to private methods, which are
     * automatically final.) These cannot be overridden and thus cannot produce this kind
     * of surprise. You might not always follow this guideline, but it’s something to strive
     * towards.
     */
    Glyph() {
        System.out.println("Glyph() before draw()");
        draw();
        System.out.println("Glyph() after draw()");
    }
}

class RoundGlyph extends Glyph {
    private int radius = 1;

    RoundGlyph(int r) {
        radius = r;
        System.out.println("RoundGlyph.RoundGlyph(), radius = " + radius);
    }

    @Override
    void draw() {
        System.out.println("RoundGlyph.draw(), radius = " + radius);
    }
}

public class PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}
