package inner_classes_in_methods_and_scopes;

/*
    Returning an instance of an anonymous inner class
 */

import inner_classes_and_upcasting.Contents;

public class Parcel7 {
    /*
        The contents() method combines the creation of the return value with the
        definition of the class that represents that return value. In addition, the class has
        no name—it’s anonymous. It looks as if you’re creating a Contents object, But
        then, before you get to the semicolon, you say, But wait, I think I’ll slip in a class
        definition.
     */
    public Contents contents() {
        return new Contents() { // Insert class definition
            private int i = 11;
            @Override
            public int value() {
                return i;
            }
        }; // Here semicolon is required
        /*
            The semicolon at the end of an anonymous inner class doesn’t mark the end
            of the class body. Instead, it marks the end of the expression that happens to
            contain the anonymous class. Thus, it’s identical to the way the semicolon is
            used everywhere else.
         */
    }

    public static void main(String[] args) {
        Parcel7 p = new Parcel7();
        Contents c = p.contents();
    }
}
