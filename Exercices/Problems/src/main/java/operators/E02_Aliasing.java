package operators;

class Account {
    float ammount;
}

public class E02_Aliasing {
    public static void main(String[] args) {
        Account c1 = new Account();
        Account c2 = new Account();

        c1.ammount = 52.75F;
        c2.ammount = 185.93F;

        System.out.println("Values without changes:");
        System.out.println("c1.ammount: " + c1.ammount + " c2.ammount: " + c2.ammount + "\n");

        System.out.println("Attributing c1 to c2 \n");
        c1 = c2;

        System.out.println("Values after attributing c1 to c2:");
        System.out.println("c1.ammount: " + c1.ammount + " c2.ammount: " + c2.ammount + "\n");

        System.out.println("Modifying c1, change to 759.8 \n");
        c1.ammount = 759.8f;

        System.out.println("Values after change c1 to 759.8:");
        System.out.println("c1.ammount: " + c1.ammount + " c2.ammount: " + c2.ammount + "\n");
    }

}

/*
TODO
 ****************** Exercise 2 *****************
 * Create a class containing a float and use it to
 * demonstrate aliasing.
 ***********************************************
 */
