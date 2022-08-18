package creating_inner_classes;

/*
So far, it appears that inner classes are just a name-hiding and code organization scheme, helpful but not that
compelling. However, there’s another twist. When you create an inner class, an object of that inner class contains
an implicit link to the enclosing object that made it. Through this link, it can access the members of that
enclosing object, without any special qualifications. In addition, inner classes have access rights to all
the elements in the enclosing class.
 */

// Holds a sequence of Objects
interface Selector {
    boolean end();
    Object current();
    void next();
}

/*
The Sequence is a fixed-sized array of Object with a class wrapped around it. You call add() to add a new Object
to the end of the sequence (if there’s room left). To fetch each of the objects in a Sequence.
 */
public class Sequence {
    private Object[] items;
    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(Object x) {
        if (next < items.length) {
            items[next++] = x;
        }
    }

/*
Here, the SequenceSelector is a private class that provides Selector functionality. In main(), you see the creation
of a Sequence, followed by the addition of a number of String objects. Then, a Selector is produced with a call to
selector(), and this is used to move through the Sequence and select each item.

At first, the creation of SequenceSelector looks like just another inner class. But examine it closely. Note that
each of the methods—end(), current(), and next()— refers to items, a reference that isn’t part of SequenceSelector,
but is instead a private field in the enclosing class. However, the inner class can access methods and fields from
the enclosing class as if it owned them. This turns out to be very convenient, as you see in the preceding example.


 */
    private class SequenceSelector implements Selector {
        private int i = 0;

        @Override
        public boolean end() {
            return i == items.length; // items reference, that isn't part of that class.
        }

        @Override
        public Object current() {
            return items[i]; // items reference, that isn't part of that class.
        }

        @Override
        public void next() {
            if (i < items.length) i++; // items reference, that isn't part of that class.
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);

        for (int i = 0; i < 10; i++) {
            sequence.add(Integer.toString(i));
        }

        Selector selector = sequence.selector();

        while (!selector.end()) {
            System.out.println(selector.current() + " ");
            selector.next();
        }
    }
}
