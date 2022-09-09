package everything_is_an_object;

class Earth {
    static int wather = 100;
    int grass = 50;
    protected int lands = 10;
    private int minerals = 1000;
    final int gold = 8000;

    int getMinerals() {
        return this.minerals++;
    }
}

public class E08_StaticTest {
    public static void main(String[] args) {
        Earth e1 = new Earth();
        Earth e2 = new Earth();

        System.out.println("Static members:");
        System.out.println(e1.wather + " == " + e2.wather);
        e1.wather++;
        System.out.println(e1.wather + " == " + e2.wather + "\n");

        System.out.println("Public members");
        System.out.println(e1.grass + " == " + e2.grass);
        e1.grass++;
        System.out.println(e1.grass + " != " + e2.grass + "\n");

        System.out.println("Protected members");
        System.out.println(e1.lands + " == " + e2.lands);
        e1.lands++;
        System.out.println(e1.lands + " != " + e2.lands + "\n");

        System.out.println("Private members");
        System.out.println(e1.getMinerals() + " == " + e2.getMinerals());
        e1.getMinerals();
        System.out.println(e1.getMinerals() + " != " + e2.getMinerals() + "\n");

        System.out.println("Final members, aren't incrementable");
        System.out.println(e1.gold + " == " + e2.gold);
    }
}

/*
TODO
 ****************** Exercise 8 ******************
 * Write a program to demonstrate that no
 * matter how many objects you create of a
 * particular class, there is only one instance
 * of a particular static field in that class.
 ************************************************
 */
