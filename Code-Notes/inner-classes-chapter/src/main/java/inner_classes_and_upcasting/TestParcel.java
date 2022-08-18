package inner_classes_and_upcasting;

class Parcel4 {
    /*
        In Parcel4, the inner class PContents is private, so nothing but Parcel4 can
        access it. Normal (non-inner) classes cannot be made private or protected; they
        can only be given public or package access.
     */
    private class PContents implements Contents {
        private int i = 11;

        @Override
        public int value() { return i; }
    }

    /*
        PDestination is protected, so it can only be accessed by Parcel4, classes in the
        same package (because protected also gives package access), and the inheritors of
        Parcel4. This means the client programmer has restricted knowledge and access
        to these members. In fact, you can’t even downcast to a private inner class (or a
        protected inner class unless you’re an inheritor), because you can’t access the name,
        as you see in class TestParcel.
     */
    protected final class PDestination implements Destination {
        private String label;
        private PDestination(String whereTo) {
            label = whereTo;
        }

        @Override
        public String readLabel() { return label; }
    }

    public Destination destination(String s) {
        return new PDestination(s);
    }

    public Contents contents() {
        return new PContents();
    }
}

public class TestParcel {
    public static void main(String[] args) {
        Parcel4 p = new Parcel4();
        Contents c = p.contents(); // you can’t access the name
        Destination d = p.destination("Japan"); // you can’t access the name

        // Illegal -- can't access private class:
        //Parcel4.PContents pc = p.new PContents();
    }

    /*
        private inner classes provide a way for the class designer to completely prevent
        any type-coding dependencies and to completely hide details about implementation.
        In addition, extension of an interface is useless from the client programmer’s
        perspective because the client programmer cannot access any additional methods
        that aren’t part of the public interface. This also provides an opportunity for the
        Java compiler to generate more efficient code.
     */
}
