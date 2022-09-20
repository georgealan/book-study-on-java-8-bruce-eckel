package performing_cleanup_with_finally;

class OnOffException1 extends Exception {}
class OnOffException2 extends Exception {}

public class OnOffSwitch {
    private static Switch sw = new Switch();
    private static Switch sw2 = new Switch();
    public static void f() throws OnOffException1, OnOffException2 {}

    public static void main(String[] args) {
        System.out.println("block try without finally");
        try {
            sw.on();

            // Code that can throw exceptions.
            f();
            sw.off();
        } catch (OnOffException1 e) {
            System.out.println("OnOffException1");
            sw.off();
        } catch (OnOffException2 e) {
            System.out.println("OnOffException2");
            sw.off();
        }
        System.out.println();
/*
The goal here is to make sure the switch is off when main() completes, so sw.off()
is placed at the end of the try block and at the end of each exception handler. But
an exception might be thrown that isn’t caught here, so sw.off() would be missed.
However, with finally you can place the cleanup code from a try block in just one
place:
 */
        // WITH FINALLY
        System.out.println("block try with finally");
        try {
            sw2.on();
            // Code that can throw exceptions
            OnOffSwitch.f();
        } catch (OnOffException1 e) {
            System.out.println("OnOffException1");
        } catch (OnOffException2 e) {
            System.out.println("OnOffException2");
        } finally {
            sw2.off(); // Here sw.off() is guaranteed to run no matter what happens.
        }


    }
}

