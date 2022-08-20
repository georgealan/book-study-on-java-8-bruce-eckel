package inner_classes_in_methods_and_scopes;

import inner_classes_and_upcasting.Destination;

/*
    Using "instance initialization" to perform construction on an anonymous inner class

    Anonymous inner classes are somewhat limited compared to regular inheritance,
    because they can either extend a class or implement an interface, but not both. And
    if you do implement an interface, you can only implement one.
 */

public class Parcel10 {
    public Destination destination(final String dest, final float price) {
        return new Destination() {
            private int cost;

            // Instance initialization for each object, you can have only one of this per inner-class
            {
                cost = Math.round(price);
                if (cost > 100) System.out.println("Over budget!");
            }

            /*
            Inside the instance initializer you see code that couldn’t be executed as part of a
            field initializer (that is, the if statement). So in effect, an instance initializer is the
            constructor for an anonymous inner class. However, it’s limited; you can’t overload
            instance initializers, so you can have only one of these constructors.
             */

            private String label = dest;

            @Override
            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel10 p = new Parcel10();
        Destination d = p.destination("Japan", 101.395F);
    }
}
