package inner_classes_in_methods_and_scopes;

/*
A class defined within a method.

This example shows the creation of an entire class within the scope of a method
(instead of the scope of another class). This is called a local inner class

 */

import inner_classes_and_upcasting.Destination;

public class Parcel5 {
    /*
        The class PDestination is part of destination() rather than being part of
        Parcel5. Therefore, PDestination cannot be accessed outside of destination().
        The upcasting in the return statement means nothing comes out of destination()
        except a reference to a Destination interface. The fact that the name of the class
        PDestination is placed inside destination() doesn’t mean PDestination is not
        a valid object once destination() returns.

        You can use the class identifier PDestination for an inner class inside each class in
        the same subdirectory without a name clash.
     */
    public Destination destination(String s) {

        final class PDestination implements Destination {
            private String label;

            private PDestination(String whereTo) {
                label = whereTo;
            }

            @Override
            public String readLabel() { return label; }
        }
        return new PDestination(s);
    }

    public static void main(String[] args) {
        Parcel5 p = new Parcel5();
        Destination d = p.destination("Japan");
    }

}
