package everything_is_an_object;

public class E01_DefaultInitialization {
    int number;
    char letter;

    public E01_DefaultInitialization() {
        System.out.println("number = " + number);
        System.out.println("letter = [" + letter + "]" );
    }

    public static void main(String[] args) {
        new E01_DefaultInitialization();
    }
}

/*
TODO
 ****************** Exercise 1 *****************
 * Create a class containing an int and a char
 * that are not initialized. Print their values
 * to verify that Java performs default
 * initialization.
 **********************************************
 */
