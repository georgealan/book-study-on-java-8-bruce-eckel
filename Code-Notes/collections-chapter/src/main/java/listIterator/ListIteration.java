package listIterator;

/*
ListIterator is a more powerful subtype of Iterator that is produced only by
List classes. While Iterator can only move forward, ListIterator is bidirectional.
It can produce indices of the next and previous elements relative to where
the iterator is pointing in the list, and it can replace the last element it visited using
the set() method.

You can produce a ListIterator that points to the beginning
of the List by calling listIterator(), and you can also create a ListIterator
that starts out pointing to an index n in the list by calling listIterator(n). Here’s
demonstration of these abilities:
 */

import list.Pet;
import list.PetCreator;

import java.util.List;
import java.util.ListIterator;

public class ListIteration {
    public static void main(String[] args) {
        List<Pet> pets = new PetCreator().list(8);
        ListIterator<Pet> it = pets.listIterator();

        while (it.hasNext()) {
            System.out.println(it.next() +
                ", " + it.nextIndex() +
                ", " + it.previousIndex() + "; ");
        }
        System.out.println();

        // Backwards
        while (it.hasPrevious()) {
            System.out.println(it.previous().id() + " ");
        }
        System.out.println();
        System.out.println(pets);
        it = pets.listIterator(3);

        while (it.hasNext()) {
            it.next();
            it.set(new PetCreator().get());
            //The PetCreator.get() method is used to replace all the Pet objects in the List from location 3 onward.
        }
        System.out.println(pets);
    }
}
