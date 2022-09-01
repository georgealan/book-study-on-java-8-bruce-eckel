package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/*
Upcasting to a Queue from a LinkedList

A queue is typically a first-in-first-out (FIFO) collection. That is, you put things in
at one end and pull them out at the other, and the order you put them in is the
same order they come out. Queues are commonly used as a way to reliably transfer
objects from one area of a program to another. Queues are especially important
in Concurrent Programming, because they safely transfer objects from one task to
another.

LinkedList implements the Queue interface with methods to support queue behavior,
so a LinkedList can be used as a Queue implementation. By upcasting a
LinkedList to a Queue, this example uses the Queue-specific methods in the Queue
interface:
 */

public class QueueDemo {
    public static void printQ(Queue queue) {
        while (queue.peek() != null) {
            System.out.printf(queue.remove() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Random rand = new Random(47);

        for (int i = 0; i < 10; i++) {
            queue.offer(rand.nextInt(i + 10));
        }
        printQ(queue);

        Queue<Character> qc = new LinkedList<>();

        for (char c : "Brontosaurus".toCharArray()) {
            qc.offer(c);
        }
        printQ(qc);
    }

    /*
    offer() is a Queue-specific method that inserts an element at the tail of the queue if
    it can, or returns false. Both peek() and element() return the head of the queue
    without removing it, but peek() returns null if the queue is empty and element()
    throws NoSuchElementException. Both poll() and remove() remove and return
    the head of the queue, but poll() returns null if the queue is empty, while remove()
    throws NoSuchElementException.

    Autoboxing automatically converts the int result of nextInt() into the Integer
    object required by queue, and the char c into the Character object required by
    qc. The Queue interface narrows access to the methods of LinkedList so only the
    appropriate methods are available, and you are thus less tempted to use LinkedList
    methods (here, you can actually cast queue back to a LinkedList, but you are at
    least discouraged from doing so).

    The Queue-specific methods provide complete and standalone functionality. That is,
    you can have a usable Queue without any of the methods in Collection, from which
    it is inherited.
     */
}
