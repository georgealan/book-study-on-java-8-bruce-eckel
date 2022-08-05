package inheritance_and_cleanup;

/**
 * Cleanup and inheritance
 *
 * When using composition and inheritance to create a new class, most of the time you
 * won’t worry about cleanup. Subobjects can usually be left to the garbage collector.
 * If you do have cleanup issues, you must be diligent and create a dispose() method
 * (the name I have chosen to use here; you might come up with something better) for
 * your new class. And with inheritance, you must override dispose() in the derived
 * class for any special cleanup that must happen as part of garbage collection. When
 * you override dispose() in an inherited class, it’s important to remember to call the
 * base-class version of dispose() because otherwise the base-class cleanup will not
 * happen.
 */

class Characteristic {
    private String s;

    Characteristic(String s) {
        this.s = s;
        System.out.println("Creating Characteristic " + s);
    }

    protected void dispose() {
        System.out.println("disposing Characteristic " + s);
    }
}

class Description {
    private String s;

    Description(String s) {
        this.s = s;
        System.out.println("Creating Description " + s);
    }

    protected void dispose() {
        System.out.println("disposing Description " + s);
    }
}

class LivingCreature {
    private Characteristic p = new Characteristic("is alive");
    private Description t = new Description("Basic living creature");

    LivingCreature() {
        System.out.println("LivingCreature()");
    }

    protected void dispose() {
        System.out.println("LivingCreature dispose");
        t.dispose();
        p.dispose();
    }
}

class Animal extends LivingCreature {
    private Characteristic p = new Characteristic("Has heart");
    private Description t = new Description("Animal not Vegetable");

    Animal() {
        System.out.println("Animal()");
    }

    @Override protected void dispose() {
        System.out.println("Animal dispose");
        t.dispose();
        p.dispose();
        super.dispose();
    }
}

class Amphibian extends Animal {
    private Characteristic p = new Characteristic("can live in water");
    private Description t = new Description("Both water and land");

    Amphibian() {
        System.out.println("Amphibian()");
    }

    @Override protected void dispose() {
        System.out.println("Animal dispose");
        t.dispose();
        p.dispose();
        super.dispose();
    }
}

public class Frog extends Amphibian{
    private Characteristic p = new Characteristic("Croacks");
    private Description t = new Description("Eat bugs");

    public Frog() {
        System.out.println("Frog()");
    }

    @Override protected void dispose() {
        System.out.println("Frog dispose");
        t.dispose();
        p.dispose();
        super.dispose();
    }

    public static void main(String[] args) {
        Frog frog = new Frog();
        System.out.println("Bye!");
        frog.dispose();
    }
}
