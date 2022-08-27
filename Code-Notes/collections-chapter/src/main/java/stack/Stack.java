package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
This introduces the simplest possible example of a class definition using generics. The
<T> after the class name tells the compiler this is a parameterized type, and that the
type parameter—which is substituted with a real type when the class is used—is T.

Basically, this says, "We’re defining a Stack that holds objects of type T." The Stack
is implemented using an ArrayDeque, which also holds type T. Notice that push()
takes an object of type T, while peek() and pop() return an object of type T. The
peek() method provides you with the top element without removing it from the top
of the stack, while pop() removes and returns the top element.

If you want only stack behavior, inheritance is inappropriate here because that
would produce a class with all the rest of the ArrayDeque methods (you’ll see in
the Appendix: Collection Topics that this very mistake was made by the Java 1.0
designers when they created java.util.Stack). Using composition, we choose
which methods to expose and how to name them.
 */

public class Stack<T> {
    private Deque<T> storage = new ArrayDeque<>();
    public void push(T v) { storage.push(v); }
    public T peek() { return storage.peek(); }
    public T pop() { return storage.pop(); }
    public boolean isEmpty() { return storage.isEmpty(); }
    @Override public String toString() {
        return storage.toString();
    }
}
