package creating_inner_classes;

/*
More typically, an outer class has a method that returns a reference to an inner class,
as seen in the to() and contents() methods:
 */

public class Parcel2 {
    class Contents {
        private int i = 11;
        public int value() { return i; }
    }

    class Destination {
        private String label;
        Destination(String whereTo) {
            label = whereTo;
        }
        String readLabel() { return label; }
    }

    public Destination to(String s) {
        return new Destination(s);
    }

    public Contents contents() {
        return new Contents();
    }

    public void ship(String dest) {
        Contents c = new Contents();
        Destination d = to(dest);
        System.out.println(d.readLabel());
    }

    public static void main(String[] args) {
        Parcel2 p = new Parcel2();
        p.ship("Tasmania");
        Parcel2 q = new Parcel2();

        // Defining references to inner classes:
        Parcel2.Contents c = q.contents();
        Parcel2.Destination d = q.to("Borneo");
        /*
        To make an object of the inner class anywhere except from within a non-static
        method of the outer class, you must specify the type of that object as OuterClass-
        Name.InnerClassName, as seen in main().
         */
    }
}
