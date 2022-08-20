package inner_classes_in_methods_and_scopes;

import inner_classes_and_upcasting.Contents;

// Expanded version of Parcel7.java
public class Parcel7b {

    // In the anonymous inner class, Contents is created with a zero-argument constructor.
    class MyContents implements Contents {
        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }

    public Contents contents() {
        return new MyContents();
    }

    public static void main(String[] args) {
        Parcel7b p = new Parcel7b();
        Contents c = p.contents();
    }
}
