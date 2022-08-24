package iterators;

import list.Pet;
import list.PetCreator;

import java.util.*;

/*
We can produce a cleaner version of the previous example "CrossCollectionIteration"
by using the Iterable interface, which describes "anything that can produce an Iterator":
 */

public class CrossCollectionIteration2 {
    public static void display(Iterable<Pet> ip) {
        Iterator<Pet> it = ip.iterator();

        while (it.hasNext()) {
            Pet p = it.next();
            System.out.println(p.id() + ":" + p + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Pet> pets = new PetCreator().list(8);
        LinkedList<Pet> petsLL = new LinkedList<>(pets);
        HashSet<Pet> petsHS = new HashSet<>(pets);
        TreeSet<Pet> petsTS = new TreeSet<>(pets);

        // All the classes are Iterable, so now the calls to display() are notably simpler.
        display(pets);
        display(petsLL);
        display(petsHS);
        display(petsTS);
    }
}
