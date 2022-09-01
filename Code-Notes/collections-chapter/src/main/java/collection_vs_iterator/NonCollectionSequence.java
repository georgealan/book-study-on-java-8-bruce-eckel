package collection_vs_iterator;

import list.Pet;
import list.PetCreator;

import java.util.Iterator;

/*
This example shows that if you implement Collection, you also implement iterator(),
and just implementing iterator() alone requires only slightly less effort
than inheriting from AbstractCollection. However, if your class already inherits
from another class, you cannot also inherit from AbstractCollection. In that case,
to implement Collection you’d have to implement all the methods in the interface.
Here it’s much easier to inherit and add the ability to create an iterator:
 */

class PetSequence {
    protected Pet[] pets = new PetCreator().array(8);
}

public class NonCollectionSequence extends PetSequence {
    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
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
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        NonCollectionSequence nc = new NonCollectionSequence();
        InterfaceVsIterator.display(nc.iterator());
    }
}
