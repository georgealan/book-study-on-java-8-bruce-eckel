package Final_keyword;

/**
 * The fields of a class final can be final or not, as you choose. The same rules apply to final for fields
 * regardless of whether the class is defined as final. However, because it prevents inheritance. all methods ia a
 * final class are implicitly final because there's no way to override them.
 * You can include the final specifier to a method in a final class, but is doesn't add any meaning.
 */

class SmallBrain {}

final class Dinosaur {
    int i = 7;
    int j = 1;
    SmallBrain x = new SmallBrain();
    void f() {}
}

//- class Further extends Dinosaur {}
// error: Cannot extend final class 'Dinosaur'

public class FinalClasses {
    public static void main(String[] args) {
        Dinosaur n = new Dinosaur();
        n.f();
        n.i = 40;
        n.j++;
    }
}

