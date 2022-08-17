package sealed_classes_and_interfaces;

/*
JDK 17 finalizes the introduction of sealed classes and interfaces, so the base class or interface can constrain
what classes can be derived from it. This allows you to model a fixed set of kinds of values

Here, there can be no subclasses other than D1 and D2. Thus, you can ensure that any code you write will only
ever need to consider D1 and D2.

Subclasses of a sealed class must be modified by one of:
• final: No further subclasses are allowed.
• sealed: A sealed set of subclasses are allowed.
• non-sealed: A new keyword that allows inheritance by unknown subclasses.
sealed subclasses maintain strict control of the hierarchy

 */

sealed class Base permits D1, D2 {

}
