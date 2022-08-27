package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
A stack is a "last-in, first-out" (LIFO) collection. It’s sometimes called a pushdown
stack, because whatever you "push" on the stack last is the first item you can "pop"
off of the stack. An often-used analogy is cafeteria trays in a spring-loaded holder—
the last ones that go in are the first ones that come out.

Java 1.0 came with a Stack class that turned out to be badly designed (for backward
compatibility, we are forever stuck with old design mistakes in Java). Java 6 added
ArrayDeque, with methods that directly implement stack functionality:
 */

public class StackTest {
    public static void main(String[] args) {
        Deque<String> stack = new ArrayDeque<>();

        for (String s : "My dog has fleas".split(" ")) {
            stack.push(s);
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop() + " ");
        }
    }

    /*
    Even though it acts in all ways as a stack, we must still declare it as a Deque.
     */
}
