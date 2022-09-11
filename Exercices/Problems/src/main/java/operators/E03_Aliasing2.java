package operators;

class Integral {
    float f;
}

public class E03_Aliasing2 {
    static void changeFloat(Integral ac) { ac.f = 2.5f; }

    public static void main(String[] args) {
        Integral x = new Integral();
        x.f = 58.7f;
        System.out.println("1: x.f: " + x.f);
        changeFloat(x);
        System.out.println("2: x.f: " + x.f);
    }
}
