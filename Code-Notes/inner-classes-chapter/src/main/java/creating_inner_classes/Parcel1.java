package creating_inner_classes;

/*
You create an inner class just as you’d expect—by placing the class definition inside a surrounding class.

 */

public class Parcel1 {
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

    /*
    When used inside ship(), these inner classes look just like ordinary classes. The only
    apparent difference is that the names are nested within Parcel1.
     */
    public void ship(String dest) {
        Contents c = new Contents();
        Destination d = new Destination(dest);
        System.out.println(d.readLabel());
    }

    public static void main(String[] args) {
        Parcel1 p = new Parcel1();
        p.ship("Tasmania");
    }
}
