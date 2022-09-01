package new_feature_records;

import java.util.Map;

/*
New Feature: Records

Once you discover Map, it’s easy to get excited about all the ways you can use it.
However, there’s a hurdle. For a class to be used as a key in a Map (or a Set), you
must carefully define two functions: equals() and hashCode(). These are tricky to
get right and easy to break if you later modify the class, making the use of objects as
keys for Maps and Sets significantly harder than it should be.

JDK 16 finalizes the addition of the record keyword. records define classes designed
to be data transfer objects (also called data carriers). records automatically generate:

• Immutable fields
• A canonical constructor
• An accessor method for each element
• equals()
• hashCode()
• toString()
 */
record Employee(String name, int id) {}

public class BasicRecord {
    public static void main(String[] args) {
        var bob = new Employee("Bob Dobbs", 11);
        var dot = new Employee("Dorothy Gale", 91);

        // Bob.id = 12; // Error: id has private access in Employee

        System.out.println(bob.name()); // Accessor
        System.out.println(bob.id()); // Accessor
        System.out.println(bob); // toString()

        // Employees work as the key in a map:
        var map = Map.of(bob, "A", dot, "B");
        System.out.println(map);
    }

    /*
    If you later decide to add, subtract or change one of the fields in your record, Java
    ensures that the result will still work properly. This changeability is one of the things
    that makes records so valuable.
     */
}
