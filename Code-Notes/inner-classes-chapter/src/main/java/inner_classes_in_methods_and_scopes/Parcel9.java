package inner_classes_in_methods_and_scopes;

import inner_classes_and_upcasting.Destination;

public class Parcel9 {
    // Argument must be final or effectively final to use within the anonymous inner class.

    /*
        If you’re defining an anonymous inner class and must use an object that’s defined
        outside the anonymous inner class, the compiler requires that the argument reference
        be final or “effectively final” (that is, it’s never changed after initialization, so it can
        be treated as if it is final), as you see in the argument to destination(). Here you
        can leave off the final without a problem, but it’s usually better to include it as a
        reminder.

        As long as you’re assigning a field, the approach in this example is fine. But what if
        you must perform some constructor-like activity? You can’t have a named constructor
        in an anonymous class (because there’s no name).
     */
    public Destination destination(final String dest) {
        return new Destination() {
            private String label = dest;

            @Override
            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel9 p = new Parcel9();
        Destination d = p.destination("Japan");
    }
}
