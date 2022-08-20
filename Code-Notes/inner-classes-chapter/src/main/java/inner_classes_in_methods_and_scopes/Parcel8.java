package inner_classes_in_methods_and_scopes;

public class Parcel8 {
    public Wrapping wrapping(int x) {
        // Base constructor call:
        return new Wrapping(x) { // [1]
            @Override public int value() {
                return super.value() * 47;
            }
        }; // [2]
    }

    public static void main(String[] args) {
        Parcel8 p = new Parcel8();
        Wrapping w = p.wrapping(10);
    }

    /*
        • [1] You pass the appropriate argument to the base-class constructor.
        • [2] The semicolon at the end of an anonymous inner class doesn’t mark the end
        of the class body. Instead, it marks the end of the expression that happens to
        contain the anonymous class. Thus, it’s identical to the way the semicolon is
        used everywhere else.
     */
}

