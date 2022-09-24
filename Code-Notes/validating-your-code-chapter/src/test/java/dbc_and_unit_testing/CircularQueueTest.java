package dbc_and_unit_testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircularQueueTest {
    private CircularQueue queue = new CircularQueue(10);
    private int i = 0;

    @BeforeEach
    public void initialize() {
        while (i < 5) { // Pre-load with some data
            queue.put(Integer.toString(i++));
        }
    }

    // Support methods:
    private void showFullness() {
        assertTrue(queue.full());
        assertFalse(queue.empty());
        System.out.println(queue.dump());
    }

    private void showEmptiness() {
        assertFalse(queue.full());
        assertTrue(queue.empty());
        System.out.println(queue.dump());
    }

    @Test
    @DisplayName("Test Full")
    public void full() {
        System.out.println("testFull");
        System.out.println(queue.dump());
        System.out.println(queue.get());
        System.out.println(queue.get());

        while (!queue.full()) {
            queue.put(Integer.toString(i++));
        }

        String message = "";

        try {
            queue.put("");
        } catch (CircularQueueException e) {
            message = e.getMessage();
            System.out.println(message);
        }

        assertEquals(message, "put() into full CircularQueue");
        showFullness();
    }

    @Test
    @DisplayName("Test Empty")
    public void empty() {
        System.out.println("testEmpty");
        while (!queue.empty()) {
            System.out.println(queue.get());
        }
        String message = "";

        try {
            queue.get();
        } catch (CircularQueueException e) {
            message = e.getMessage();
            System.out.println(message);
        }
        assertEquals(message, "get() from empty CircularQueue");
        showEmptiness();
    }

    @Test
    @DisplayName("Test null put")
    public void nullPut() {
        System.out.println("testNullPut");
        String message = "";
        try {
            queue.put(null);
        } catch (CircularQueueException e) {
            message = e.getMessage();
            System.out.println(message);
        }
        assertEquals(message, "put() null item");
    }

    @Test
    @DisplayName("Test Circularity")
    public void circularity() {
        System.out.println("testCircularity");
        while (!queue.full()) {
            queue.put(Integer.toString(i++));
        }
        showFullness();
        assertTrue(queue.isWrapped());
        while (!queue.empty()) {
            System.out.println(queue.get());
        }
        showEmptiness();
        while (!queue.full()) {
            queue.put(Integer.toString(i++));
        }
        showFullness();
        while (!queue.empty()) {
            System.out.println(queue.get());
        }
        showEmptiness();
    }
}
