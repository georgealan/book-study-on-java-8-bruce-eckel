package sealed_classes_and_interfaces;

/*
If all subclasses are defined in the same file, you don’t need the permits clause
 */

sealed class Shape {}

final class Circle extends Shape {}
final class Triangle extends Shape {}


//Hierarchy control

sealed class Bottom permits Level1 {}
sealed class Level1 extends Bottom permits Level2 {}
sealed class Level2 extends Level1 permits Level3 {}
final class Level3 extends Level2 {}

/*
    Note that a sealed class must have at least one subclass.
    A sealed base class cannot prevent the use of a non-sealed subclass, so you can
    always open things back up:
 */

sealed class Super permits Sub1, Sub2 {}
final class Sub1 extends Super {}
non-sealed class Sub2 extends Super {}
class Any1 extends Sub2 {}
class Any2 extends Sub2 {}

/*
Sub2 allows any number of subclasses so it seems like it releases control of the types
you can create. However, you strictly limit the immediate subclasses of the sealed
class Super. That is, Super still only allows the direct subclasses Sub1 and Sub2.

JDK 16 records can also be used as sealed implementations of interfaces. Because
records are implicitly final they do not need to be preceded by the final keyword
 */

sealed interface Employee permits CLevel, Programmer {}
record CLevel(String type) implements Employee {}
record Programmer(String experience) implements Employee {}

/*
The compiler prevents you from downcasting to illegal types from within a sealed hierarchy:
 */

sealed interface II permits JJ {}
final class JJ implements II {}
class Something {}

class CheckedDowncast {
    public void f() {
        II i = new JJ();
        JJ j = (JJ)i;

        //Something s = (Something)i;
        // Error: Imcompatible types: II cannot be converted to Something.
    }
}


