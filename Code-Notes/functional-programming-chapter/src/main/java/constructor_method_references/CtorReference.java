package constructor_method_references;

/*
You can also capture a reference for a constructor, and later call that constructor via the reference.
 */

class Dog {
    String name;
    int age = -1; // For "unknown"

    Dog() { name = "stray"; }
    Dog(String nm) { name = nm; }
    Dog(String nm, int yrs) { name = nm; age = yrs; }
}

interface MakeNoArgs {
    Dog make();
}

interface Make1Arg {
    Dog make(String nm);
}

interface Make2Args {
    Dog make(String nm, int age);
}

public class CtorReference {
    public static void main(String[] args) {
        MakeNoArgs mna = Dog::new;   // [1]
        Make1Arg m1a = Dog::new;     // [2]
        Make2Args m2a = Dog::new;    // [3]

        Dog dn = mna.make();
        Dog d1 = m1a.make("Snoop");
        Dog d2 = m2a.make("Scooby", 4);
    }

/*
Dog has three constructors, and the make() methods inside the functional interfaces
reflect the constructor argument lists (the make() methods can have different
names).

Notice how we use Dog::new for each of [1], [2], and [3]. There’s only one name for
all three constructors: ::new. But the constructor reference is assigned to a different
interface in each case, and the compiler can detect from that which constructor
reference to use.

The compiler can see that calling your functional method (make(), in this example)
means to call the constructor.
 */
}
