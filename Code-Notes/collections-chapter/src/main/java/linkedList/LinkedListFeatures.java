package linkedList;

import list.Pet;
import list.PetCreator;
import list.animals.Hamster;
import list.animals.Rat;

import java.util.LinkedList;

/*
LinkedList implements the basic List interface like ArrayList does, but it performs insertion and removal in
the middle of the List more efficiently than ArrayList. However, it is less efficient for random-access operations.

LinkedList adds methods to use it as a stack, a queue or a double-ended queue (deque).
Some of these methods are aliases or slight variations of each other, producing names familiar
for a particular use (Queue, in particular).

• getFirst() and element() are identical—they return the head (first element) of the list without removing it,
and throw NoSuchElementException if the List is empty.  peek() is a slight variation of those two that returns
null if the list is empty.

• removeFirst() and remove() are also identical—they remove and return the head of the list, and throw
NoSuchElementException for an empty list. poll() is a slight variation that returns null  if this list is empty.

• addFirst() inserts an element at the beginning of the list.

• offer() is the same as add() and addLast(). They all add an element to the tail (end) of a list.

• removeLast() removes and returns the last element of the list. Here’s an example that shows the basic similarity
and differences between these features. It doesn’t repeat the behavior that was shown in ListFeatures.java:
 */

public class LinkedListFeatures {
    public static void main(String[] args) {
        LinkedList<Pet> pets = new LinkedList<>(new PetCreator().list(5));
        System.out.println(pets);

        // Identical
        System.out.println("pets.getFirst(): " + pets.getFirst());
        System.out.println("pets.element(): " + pets.element());

        // Only differs in empty-list behavior
        System.out.println("pets.peek() " + pets.peek());

        // Identical, remove and return the first element:
        System.out.println("pets.remove() " + pets.remove());
        System.out.println("pets.removeFirst() " + pets.removeFirst());

        // Only differs in empty-list behavior:
        System.out.println("pets.poll() " + pets.poll());
        System.out.println(pets);

        pets.addFirst(new Rat());
        System.out.println("After addFirst(): " + pets);

        pets.offer(new PetCreator().get());
        System.out.println("After offer() " + pets);

        pets.add(new PetCreator().get());
        System.out.println("After add(): " + pets);

        pets.addLast(new Hamster());
        System.out.println("After addLast() " + pets);
        System.out.println("pets.removeLast(): " + pets.removeLast());
        System.out.println("After removeLast() " + pets);
    }

    /*
    The result of PetCreator.list() is handed to the LinkedList constructor to
    populate it. If you look at the Queue interface, you’ll see the element(), offer(),
    peek(), poll() and remove() methods that were added to LinkedList, so it could
    be a Queue implementation.
     */
}
