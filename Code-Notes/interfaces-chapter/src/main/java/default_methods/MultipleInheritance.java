package default_methods;

/*
    Multiple inheritance means a class may inherit characteristics and features from
    more than one parent type.

    When Java was first designed, multiple inheritance in C++ was roundly denigrated.
    Java was strictly a single-inheritance language: You could only inherit from one class
    (or abstract class). You could also implement as many interfaces as you like, but
    before Java 8 an interface carried no baggage—it was only a description of what its
    methods looked like.

    Now, many years later, via default methods, Java has some multiple inheritance.
    Combining interfaces with default methods means you can combine behaviors
    from multiple base types. Because interfaces still don’t allow fields (only static
    fields, which don’t apply), fields can still only come from the single base class or
    abstract class; that is, you cannot have multiple inheritance of state.

    Now we can do something we never could prior to Java 8: combine implementations
    from multiple sources. This works fine as long as all the base-class methods have
    distinct names and argument lists. If not, you get compile-time errors.
 */

interface One {
    default void first() { System.out.println("first"); }
}

interface Two {
    default void second() { System.out.println("second"); }
}

interface Three {
    default void third() { System.out.println("third"); }
}

class MI implements One, Two, Three {}

public class MultipleInheritance {
    public static void main(String[] args) {
        MI mi = new MI();
        mi.first();
        mi.second();
        mi.third();
    }
}
