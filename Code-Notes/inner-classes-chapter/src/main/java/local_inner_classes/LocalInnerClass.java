package local_inner_classes;

/*

 */

interface Counter {
    int next();
}

public class LocalInnerClass {
    private int count = 0;

    Counter getCounter(final String name) {
        // A local inner class:
        class LocalCounter implements Counter {
            LocalCounter() {
                // Local inner can have a constructor
                System.out.println("LocalCounter()");
            }

            @Override
            public int next() {
                System.out.print(name); // Access local final
                return count++;
            }
        }
        return new LocalCounter();
    }

    // Repeat, but with an anonymous inner class:
    Counter getCounter2(final String name) {
        return new Counter() {
            // Anonymous inner class cannot have a named
            // constructor, only an instance initializer:
            {
                System.out.println("Counter()");
            }

            @Override
            public int next() {
                System.out.print(name); // Access local final
                return count++;
            }
        };
    }

    public static void main(String[] args) {
        LocalInnerClass lic = new LocalInnerClass();

        Counter
            c1 = lic.getCounter("Local inner "),
            c2 = lic.getCounter2("Anonymous inner ");

        for (int i = 0;  i < 5; i++) {
            System.out.println(c1.next());
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(c2.next());
        }
    }

    /*
        Counter returns the next value in a sequence. It is implemented as both a local
        inner class (LocalCounter) and an anonymous inner class (the return value of
        getCounter2()), each with the same behaviors and capabilities. The name of the
        local inner class is not accessible outside the method. A local inner class allows a
        named constructor and/or an overloaded constructor, while an anonymous inner
        class can only use instance initialization.

        Note that a local inner class allows you to make more than one object of that class,
        whereas an anonymous inner class is typically used to return a single instance of that
        class.
     */
}

// TODO Continue in page 403 - New Chapter Collections
