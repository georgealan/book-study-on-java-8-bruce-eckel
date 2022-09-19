package catching_any_exception;

class Ebase1 extends Exception {}
class Except1 extends Ebase1 {}
class Ebase2 extends Exception {}
class Except2 extends Ebase2 {}
class Ebase3 extends Exception {}
class Except3 extends Ebase3 {}
class Ebase4 extends Exception {}
class Except4 extends Ebase4 {}

/*
If there are a set of exceptions you want to handle the same way, and they have a
common base type, you just catch that. But if those exceptions don’t have a base type
in common:
 */
public class MultiCatch {
    // With Java 7 multi-catch handlers, you can "OR" together different types of exceptions in a single catch:
    void x() throws Except1, Except2, Except3, Except4 {}
    void y() throws Except1, Except2, Except3, Except4 {}
    void process() {}

    void f() {
        try {
            x();
        } catch (Except1 | Except2 | Except3 | Except4 e) {
            process();
        }
    }

    // Or in other combinations:

    void g() {
        try {
            y();
        } catch (Except1 | Except2 e) {
            process();
        } catch (Except3 | Except4 e) {
            process();
        }
    }
}
