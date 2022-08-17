package sealed_classes_and_interfaces;

/*
You can discover the permitted subclasses at runtime using getPermittedSubclasses()

The most compelling use of sealed classes and interfaces will be seen at the end of
the Enumerations chapter where the new pattern matching feature is introduced.
 */

sealed class Color permits Red, Green, Blue {}
final class Red extends Color {}
final class Green extends Color {}
final class Blue extends Color {}

public class PermittedSubclasses {
    public static void main(String[] args) {
        for (var p: Color.class.getPermittedSubclasses()) {
            System.out.println(p.getSimpleName());
        }
    }
}

/*
It is tempting to decide that interfaces are good, and therefore always choose
interfaces over concrete classes. Almost anytime you create a class, you can instead
create an interface and a factory.

Many people have fallen to this temptation, creating interfaces and factories whenever
it’s possible. The logic seems to be that you might use a different implementation,
so always add that abstraction. It has become a kind of premature design optimization.

Any abstraction should be motivated by a real need. Interfaces should be something
you refactor to when necessary, rather than installing the extra level of indirection
everywhere, along with the extra complexity. That extra complexity is significant,
and if you make someone work through that complexity only to realize that you’ve
added interfaces “just in case” and for no compelling reason—well, if I see such a
design I begin questioning all the other designs this particular person has done.

An appropriate guideline is to prefer classes to interfaces. Start with classes, and if it
becomes clear that interfaces are necessary, refactor. Interfaces are a great tool, but
they can easily be overused.
 */
