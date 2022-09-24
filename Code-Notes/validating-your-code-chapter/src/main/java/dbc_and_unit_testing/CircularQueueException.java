package dbc_and_unit_testing;

// This is used to report errors with the CircularQueue class
public class CircularQueueException extends RuntimeException {
    public CircularQueueException(String why) {
        super(why);
    }
}
