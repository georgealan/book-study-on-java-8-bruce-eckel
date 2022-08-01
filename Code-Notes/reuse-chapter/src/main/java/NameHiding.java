/**
 * Overloading a base-class method name in a derived class does not hide the base-class versions.
 *
 * If a Java base-class has a method name that's overloaded several times, redefining that method name in the
 * derived class will not hide any of the base-class versions. Overloading works regardless of whether the
 * method was defined at this level or in a base class.
 */

class Homer {
    char doh(char c) {
        System.out.println("doh(char)");
        return 'd';
    }

    float doh(float f) {
        System.out.println("doh(float)");
        return 1.0f;
    }
}

class Milhouse {}

class Bart extends Homer {
    void doh(Milhouse m) {
        System.out.println("doh(Milhouse)");
    }
}

public class NameHiding {
    public static void main(String[] args) {
        Bart b = new Bart();
        b.doh(1);
        b.doh('x');
        b.doh(1.0f);
        b.doh(new Milhouse());
    }
}
