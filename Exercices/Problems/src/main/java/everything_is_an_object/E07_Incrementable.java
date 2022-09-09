package everything_is_an_object;

class StaticText {
    static int i = 0;
}

public class E07_Incrementable {
    static void increment() {
        StaticText.i++;
        System.out.println(StaticText.i);
    }

    public static void main(String[] args) {
        E07_Incrementable ex7 = new E07_Incrementable();
        ex7.increment();
        E07_Incrementable.increment();
        increment();
    }
}

/*
TODO
 ****************** Exercise 7 ******************
 * Turn the Incrementable code fragments into a
 * working program.
 ************************************************
 */
