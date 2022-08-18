package inner_classes_in_methods_and_scopes;

/*
    Nesting a class within a scope

    The class TrackingSlip is nested inside the scope of an if statement. This does not
    mean that the class is conditionally created—it gets compiled along with everything
    else. However, it’s not available outside the scope where it is defined. Other than that,
    it looks just like an ordinary class.
 */

public class Parcel6 {
    private void internalTracking(boolean b) {
        if (b) {
            class TrackingSlip {
                private String id;

                TrackingSlip(String s) {
                    id = s;
                }

                String getSlip() { return id; }
            }

            TrackingSlip ts = new TrackingSlip("slip");
            String s = ts.getSlip();
        }
        // Can't use it here! Out of scope
        //- TrackingSlip ts = new TrackingSlip("x");
    }

    public void track() { internalTracking(true); }

    public static void main(String[] args) {
        Parcel6 p = new Parcel6();
        p.track();
    }
}
