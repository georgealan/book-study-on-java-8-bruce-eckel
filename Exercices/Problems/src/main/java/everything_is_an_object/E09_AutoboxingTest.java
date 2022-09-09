package everything_is_an_object;

public class E09_AutoboxingTest {
    public static void main(String[] args) {
        Integer in = 50;
        int i = in;
        System.out.println("The value of int is: " + i);

        Byte bty = 1;
        byte by = bty;
        System.out.println("The value of byte is: " + by);

        Short sh = 1;
        short s = sh;
        System.out.println("The value of short is: " + s);

        Long lg = 10000L;
        long l = lg;
        System.out.println("The value of long is: " + l);

        Double db = 25.4;
        double d = db;
        System.out.println("The value of double is: " + d);

        Character chr = 'A';
        char ch = chr;
        System.out.println("The value of char is: " + ch);

        Float fl = 29.8f;
        float f = fl;
        System.out.println("The value of float is: " + f);

        Boolean bol = false;
        boolean b = bol;
        System.out.println("The value of boolean is: " + b);
    }
}

/*
TODO
 ****************** Exercise 9 ******************
 * Write a program to demonstrate that
 * autoboxing works for all the primitive types
 * and their wrappers.
 ************************************************
 */
