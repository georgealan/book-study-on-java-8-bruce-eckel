package map;

import list.Pet;
import list.animals.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Maps, like arrays and Collections, can easily be expanded to multiple dimensions;
you make a Map whose values are Maps (and the values of those Maps can be
other collections, even other Maps). Thus, it’s easy to combine collections to quickly
produce powerful data structures. For example, suppose you are keeping track of
people who have multiple pets—all you need is a Map<Person, List<Pet>>:
 */

public class MapOfList {
    public static final Map<Person, List<? extends Pet>> petPeople = new HashMap<>();

    static {
        petPeople.put(new Person("Dawn"),
            Arrays.asList(
                new Cymric("Molly"),
                new Mutt("Spot")
            ));

        petPeople.put(new Person("Kate"),
            Arrays.asList(
                new Cat("Shackleton"),
                new Cat("Elsie May"),
                new Dog("Margret")
            ));

        petPeople.put(new Person("Marilyn"),
            Arrays.asList(
               new Pug("Louie aka Louis Snorkelstein Dupree"),
               new Cat("Stanford"),
               new Cat("Pinkola")
            ));

        petPeople.put(new Person("Luke"),
            Arrays.asList(
               new Rat("Fuzzy"),
               new Rat("Fizzy")
            ));

        petPeople.put(new Person("Isaac"),
            Arrays.asList(
                new Rat("Freckly")
            ));
    }

    public static void main(String[] args) {
        System.out.println("People: " + petPeople.keySet());
        System.out.println("Pets: " + petPeople.values());

        for (Person person : petPeople.keySet()) {
            System.out.println(person + " has:");
            for (Pet pet : petPeople.get(person)) {
                System.out.println("    " + pet);
            }
        }
    }

    /*
    A Map can return a Set of its keys, a Collection of its values, or a Set of its pairs.
    The keySet() method produces a Set of all the keys in petPeople, used in the for-in
    statement to iterate through the Map.
     */
}
