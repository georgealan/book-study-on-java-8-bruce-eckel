package Static_Data_Initialization;

class Mug {
    Mug(int marker) {
        System.out.println("Mug(" + marker +  ")");
    }
}

public class NonStaticInstanceInitialization {

    Mug mug1;
    Mug mug2;
    {
        mug1 = new Mug(1);
        mug2 = new Mug(2);
        System.out.println("mug1 & mug2 initialized");
    }

    NonStaticInstanceInitialization() {
        System.out.println("NonStaticInstanceInitialization()");
    }
    NonStaticInstanceInitialization(int i) {
        System.out.println("NonStaticInstanceInitialization(int)");
    }

    public static void main(String[] args) {
        System.out.println("Inside Main");
        new NonStaticInstanceInitialization();

        System.out.println("new Mugs() completed");
        new NonStaticInstanceInitialization(1);

        System.out.println("new Mugs(1) completed");
    }
}
