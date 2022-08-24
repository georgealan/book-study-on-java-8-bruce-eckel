package generics_and_typesafe_collections;

import java.util.ArrayList;

/*
    applying predefined generic classes is reasonably straightforward.
    For example, to define an ArrayList intended to hold Apple objects, you say
    ArrayList<Apple> instead of just ArrayList. The angle brackets surround the type
    parameter(s) (there might be more than one), which specify the type(s) that can be
    held by that instance of the collection.

    With generics, you’re prevented, at compile time, from putting the wrong type of
    object into a collection. Here’s the example again, using generics:
 */

public class AppleAndOrangesWithGenerics {

    public static void main(String[] args) {

        /*
        On the right-hand side of the definition for apples, you see new ArrayList<>().
        This is sometimes called the "diamond syntax" because of the <>. Before Java 7, you
        had to, in effect, duplicate the type declaration on both sides
         */
        ArrayList<Apple> apples = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            apples.add(new Apple());
        }

        // Compile time error:
        //apples.add(new Orange());

        /*
        With generics, the cast is not necessary when fetching items from the List. The
        List knows what type it holds so it does the cast for you when you call get(). Thus,
        with generics you not only know that the compiler will check the type of object you
        put into a collection, but you also get cleaner syntax when using the objects in the
        collection.
         */
        for (Apple apple : apples) {
            System.out.println(apple.id());
        }
    }
}
