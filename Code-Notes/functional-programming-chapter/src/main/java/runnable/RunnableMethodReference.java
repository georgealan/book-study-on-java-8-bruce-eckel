package runnable;

/*
The Runnable interface is part of java.lang, so no import is necessary. It also
conforms to the special single-method interface format: Its method run() takes no
arguments and has no return value. We can therefore use a lambda expression or a
method reference as a Runnable:
 */

class Go {
    static void go() {
        System.out.println("Go::go()");
    }
}

public class RunnableMethodReference {
    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous");
            }
        }).start();

        new Thread(
            () -> System.out.println("Lambda")
        ).start();

        new Thread(Go::go).start();
    }
    /*
    A Thread object takes a Runnable as its constructor argument, and has a method
    start() which calls run(). Notice that only the anonymous inner class is required
    to have a method named run().
     */
}
