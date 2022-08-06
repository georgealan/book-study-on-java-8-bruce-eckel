package static_methods_in_interfaces;

/*
    Java 8 adds the ability to include static methods inside interfaces. This allows
    you to include utilities that logically belong to that interface. These are typically
    methods that manipulate that interface, as with runOps(), or general-purpose tools
    like show()

    runOps() is an example of the Template Method design pattern, described in the
    Patterns chapter. runOps() uses a variable argument list, so we can pass as many
    Operation arguments as we want and run them in order, as seen in main()
 */

interface Operation {
    void execute();

    static void runOps(Operation... ops) {
        for (Operation op : ops) {
            op.execute();
        }
    }

    static void show(String msg) {
        System.out.println(msg);
    }
}

class Heat implements Operation {
    @Override
    public void execute() {
        Operation.show("Heat");
    }
}

public class MetalWork {
    public static void main(String[] args) {
        Operation twist = new Operation() {
            @Override
            public void execute() {
                Operation.show("Twist");
            }
        };

        Operation.runOps(
            new Heat(),                     // [1]
            new Operation() {               // [2]
                @Override
                public void execute() {
                    Operation.show("Hammer");
                }
            },
            twist::execute,                        // [3]
            () -> Operation.show("Anneal")    // [4]
        );
    }
}

/*
    Here you see the different ways to create an Operation:
    • [1]: A regular class Heat.
    • [2]: An anonymous class.
    • [3]: A method reference.
    • [4]: A Lambda expression—which requires the least amount of code.

    This feature is an improvement, because it allows you to keep static methods in
    more appropriate places.
 */
