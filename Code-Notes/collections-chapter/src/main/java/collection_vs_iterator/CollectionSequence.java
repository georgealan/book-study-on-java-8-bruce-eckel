package collection_vs_iterator;

import list.Pet;
import list.PetCreator;

import java.util.AbstractCollection;
import java.util.Iterator;

public class CollectionSequence extends AbstractCollection<Pet> {
    private Pet[] pets = new PetCreator().array(8);

    @Override
    public int size() {
        return pets.length;
    }

    @Override
    public Iterator<Pet> iterator() {
        // Anonymous inner class
        return new Iterator<Pet>() {  // [1]
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < pets.length;
            }

            @Override
            public Pet next() {
                return pets[index++];
            }

            @Override
            public void remove() { // Not implemented remove() is an "optional operation,"
                // Here, it’s not necessary to implement it, and calling it throws an exception.
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        CollectionSequence c = new CollectionSequence();
        InterfaceVsIterator.display(c);
        InterfaceVsIterator.display(c.iterator());
    }

    /*
    [1] Because iterator() returns Iterator<Pet>, you might think that the anonymous inner class definition
    could use the diamond syntax and Java could infer the type. But that doesn’t work; the type inference
    is still quite limited.

     */
}
