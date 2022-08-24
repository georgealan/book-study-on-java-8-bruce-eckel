package iterators;

import list.Pet;
import list.PetCreator;

import java.util.Iterator;
import java.util.List;

/*
The concept of an Iterator (another design pattern) achieves this abstraction. An
iterator is an object that moves through a sequence and selects each object in that
sequence without the client programmer knowing or caring about the underlying
structure of that sequence. In addition, an iterator is usually what’s called a
lightweight object: one that’s cheap to create. For that reason, you’ll often find
seemingly strange constraints for iterators; for example, the Java Iterator can move
in only one direction. There’s not much you can do with an Iterator except:

    1. Ask a Collection to hand you an Iterator using a method called iterator().
    That Iterator is ready to return the first element in the sequence.
    2. Get the next object in the sequence with next().
    3. See if there are any more objects in the sequence with hasNext().
    4. Remove the last element returned by the iterator with remove().
 */

public class SimpleIteration {
    public static void main(String[] args) {
        List<Pet> pets = new PetCreator().list(12);
        Iterator<Pet> it = pets.iterator();

        while (it.hasNext()) {
            Pet p = it.next();
            System.out.println(p.id() + ":" + p + " ");
        }
        System.out.println();

        // A simpler approach, when possible:
        for (Pet p : pets) {
            System.out.println(p.id() + ":" + p + " ");
        }
        System.out.println();

        // An iterator can also remove elements
        it = pets.iterator();
        for (int i = 0; i < 6; i++) {
            it.next();
            it.remove();
        }
        System.out.println(pets);
    }

    /*
    With an Iterator, you don’t worry about the number of elements in the collection.
    That’s taken care of for you by hasNext() and next().

    If you’re moving forward through the List and not trying to modify the List object
    itself, you see that the for-in syntax is more succinct.

    An Iterator can also remove the last element produced by next(), which means
    you must call next() before you call remove().
     */
}
