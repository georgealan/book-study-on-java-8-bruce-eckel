package Static_Data_Initialization;

/**
 * The order of initialization is statics first, if they haven’t already been initialized by
 * a previous object creation, then the non-static objects. And static is executed only once.
 * the first time you make an object of that class or the first time you access a static member
 * of that class (even if you never make an object of that class).
 */

class Bowl {
    Bowl(int marker) {
        System.out.println("Bow(" + marker + ")");
    }

    void f1(int marker) {
        System.out.println("f1(" + marker + ")");
    }
}

class Table {
    // It will be initialized first, when this Table object be created in main scope
    static Bowl bowl1 = new Bowl(1);

    //Table Constructor
    Table() {
        System.out.println("Table()");
        bowl2.f1(1);
    }

    void f2(int marker) {
        System.out.println("f2(" + marker + ")");
    }

    static Bowl bowl2 = new Bowl(2); // It will be initialized second
}

class Cupboard {
    Bowl bowl3 = new Bowl(3);
    static Bowl bowl4 = new Bowl(4); // It will be initialized before bowl3

    Cupboard() {
        System.out.println("Cupboard()");
        bowl4.f1(2);
    }

    void f3(int marker) {
        System.out.println("f3(" + marker + ")");
    }

    static Bowl bowl5 = new Bowl(5); // It will be initialized before bowl3
}

public class StaticInitialization {
    public static void main(String[] args) {
        System.out.println("main creating new Cupboard()");
        new Cupboard();
        System.out.println("main creating new Cupboard()");
        new Cupboard();

        table.f2(1);
        cupboard.f3(1);
    }

    static Table table = new Table();
    static Cupboard cupboard = new Cupboard();
}
