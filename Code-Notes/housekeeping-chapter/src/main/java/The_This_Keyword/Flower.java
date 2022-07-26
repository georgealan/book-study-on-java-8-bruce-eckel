package The_This_Keyword;

public class Flower {
    int petalCount = 0;
    String s = "Initial Value";

    // Constructors overrided
    Flower(int petals) {
        petalCount = petals;
        System.out.println("Constructor w/ int arg only, petalCount= " + petalCount);
    }

    Flower(String ss) {
        System.out.println("Constructor w/ String arg only, s = " + ss);
        s = ss;
    }

    Flower(String s, int petals) {
        this(petals);
        this.s = s;
        /* Because the name of the argument s and the name of the member data s are the same,there’s an ambiguity.
        You can resolve it using this.s, to say that you’re referring to the member data. */
        System.out.println("String & int args");
    }

    Flower() {
        this("hi", 47);
        System.out.println("Zero-argument constructor");
    }

    void printPetalCount() {
        /*
            Here the compiler won’t let you call a constructor from inside
            any method other than a constructor.
         */
        System.out.println("petalCount = " + petalCount + " s = " + s);
    }

    public static void main(String[] args) {
        Flower x = new Flower();
        x.printPetalCount();
    }
}
