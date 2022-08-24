package iterators;

import list.Pet;
import list.PetCreator;

import java.util.*;

/*
display() contains no information about the type of sequence it is traversing. This
shows the true power of the Iterator: the ability to separate the operation of
traversing a sequence from the underlying structure of that sequence. For this reason,
we sometimes say that iterators unify access to collections.
 */

public class CrossCollectionIteration {
    public static void display(Iterator<Pet> it) {
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

        display(pets.iterator());
        display(petsLL.iterator());
        display(petsHS.iterator());
        display(petsTS.iterator());
    }
}
