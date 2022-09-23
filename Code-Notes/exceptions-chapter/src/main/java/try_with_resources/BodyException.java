package try_with_resources;

class Third extends Reporter {}

/*
If no constructors throw exceptions but you might get them in the body of the try,
you are again forced to provide a catch clause:
 */
public class BodyException {
    public static void main(String[] args) {
        try (
            First f = new First();
            Second s2 = new Second();
        ) {
            System.out.println("In body");
            Third t = new Third();
            new SecondExcept();
            System.out.println("The end of the body");
        } catch (CE e) {
            System.out.println("Caught: " + e);
        }
    }
}
/*
Notice that the Third object never gets cleaned up. That’s because it was not created
inside the resource specification header, so it is not guarded. This is important,
because Java provides no guidance here in the form of warnings or errors, so a
mistake like this can easily slip through. Indeed, if you rely on some of the integrated
development environments to automatically rewrite code to use try-with-resources,
they will (at the time of this writing) typically only guard the first object they come
across, and miss the rest.
 */
