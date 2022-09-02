package method_references;

interface Callable {                            // [1]
    void call(String s);
}

class Describe {
    void show(String msg) {                     // [2]
        System.out.println(msg);
    }
}

public class MethodReferences {
    static void hello(String name) {            // [3]
        System.out.println("Hello, " + name);
    }

    static class Description {
        String about;
        Description(String desc) { about = desc; }

        void help(String msg) {                // [4]
            System.out.println(about + " " + msg);
        }
    }

    static class Helper {
        static void assist(String msg) {       // [5]
            System.out.println(msg);
        }
    }

    public static void main(String[] args) {
        Describe  d = new Describe();
        Callable c = d::show;                  // [6]
        c.call("call()");                    // [7]

        c = MethodReferences::hello;           // [8]
        c.call("Bob");

        c = new Description("valuable")::help; // [9]
        c.call("information");

        c = Helper::assist;                   // [10]
        c.call("Help!");
    }

/*
• [1] We start out with a single-method interface (again, you’ll soon learn the importance of this).
• [2] The signature (argument types and return type) of show() conforms to the
signature of Callable’s call().
• [3] hello() is also signature-conformant to call().
• [4] … as is help(), a non-static method within a static inner class.
• [5] assist() is a static method inside a static inner class.
• [6] We assign a method reference for the Describe object to a Callable which doesn’t have a show() method
but rather a call() method. However, Java seems fine with this seemingly-odd assignment, because the method
reference is signature-conformant to Callable’s call() method.
• [7] We can now invoke show() by calling call(), because Java maps call() onto show().
• [8] This is a static method reference.
• [9] This is another version of [6]: a method reference for a method attached to
a live object, which is sometimes called a bound method reference.
• [10] Finally, getting a method reference for a static method of a static inner
class looks just like the outer-class version at [8].
 */
}
