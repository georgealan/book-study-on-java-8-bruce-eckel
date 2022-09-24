package dbc_and_unit_testing;

import java.util.Arrays;

public class CircularQueue {
    private Object[] data;
    private int in = 0; // Next available storage space, indicates the place in the array where the next object goes.
    private int out = 0; // Next gettable object, indicates where the next object comes from.

    // The wrapped flag means in has gone "around the circle" and is now coming up from behind out.
    private boolean wrapped = false; // Has it wrapped around the circular queue?

    public CircularQueue(int size) {
        data = new Object[size];
        // Must be true after construction:
        assert invariant();
    }

    public boolean empty() {
        return !wrapped && in == out;
    }

    public boolean full() {
        return wrapped && in == out;
    }

    public boolean isWrapped() { return wrapped; }

    public void put(Object item) {
        precondition(item != null, "put() null item");
        precondition(!full(), "put() into full CircularQueue");
        assert invariant();
        data[in++] = item;

        if (in >= data.length) {
            in = 0;
            wrapped = true;
        }
        assert invariant();
    }

    public Object get() {
        precondition(!empty(), "get() from empty CircularQueue");
        assert invariant();
        Object returnValue = data[out];
        data[out] = null;
        out++;

        if (out >= data.length) {
            out = 0;
            wrapped = false;
        }
        assert postcondition(returnValue != null, "Nullitem in CircularQueue");
        assert invariant();
        return returnValue;
    }

    // Design-by-Contract support methods:
    private static void precondition(boolean condition, String message) {
        if (!condition) throw new CircularQueueException(message);
    }

    private static boolean postcondition(boolean condition, String message) {
        if (!condition) throw new CircularQueueException(message);
        return true;
    }

    private boolean invariant() {
        // Guarantee that no null values are in the region of 'data' that holds objects:
        for (int i = out; i != in; i = (i + 1) % data.length) {
            if (data[i] == null) {
                throw new CircularQueueException("Null in CircularQueue");
            }
        }

        if (full()) { return true; }

        for (int i = in; i != out; i = (i + 1) % data.length){
            if (data[i] != null) {
                throw new CircularQueueException("non-null outside of CircularQueue range: " + dump());
            }
        }
        return true;
    }

    public String dump() {
        return "in = " + in +
                ", out = " + out +
                ", full() = " + full() +
                ", empty() = " + empty() +
                ", CircularQueue = " + Arrays.asList(data);
    }
}
