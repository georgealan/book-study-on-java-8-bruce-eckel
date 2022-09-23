package exception_matching;

class Annoyance extends Exception {}
class Sneeze extends Annoyance {}

public class Human {
    public static void main(String[] args) {
        try {
            throw new Sneeze();
        } catch (Sneeze s) {
            System.out.println("Caught Sneeze");
        } catch (Annoyance a) {
            System.out.println("Caught Annoyance");
        }
        // Catch the base type:
        try {
            throw new Sneeze();
        } catch (Annoyance a) {
            System.out.println("Caught Annoyance");
        }
    }
}

/*
The Sneeze exception is caught by the first catch clause it matches, which is the
first one in the sequence. However, if you remove the first catch clause, leaving only
the catch clause for Annoyance, the code still works because it’s catching the base
class of Sneeze. Put another way, catch(Annoyance a) will catch an Annoyance
or any class derived from it. This is useful because if you decide to add more derived
exceptions to a method, the client programmer’s code won’t need changing as long
as the client catches the base-class exceptions.
If you try to "mask" the derived-class exceptions by putting the base-class catch
clause first, like this:

try {
throw new Sneeze();
} catch(Annoyance a) {
// ...
} catch(Sneeze s) {
// ...
}
 */
