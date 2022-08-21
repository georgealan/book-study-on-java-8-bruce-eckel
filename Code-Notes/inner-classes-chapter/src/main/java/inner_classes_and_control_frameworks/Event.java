package inner_classes_and_control_frameworks;

import java.time.Duration;
import java.time.Instant;

public abstract class Event {
    private Instant eventTime;
    protected final Duration delayTime;

    // The constructor captures the time in milliseconds (measured from the time of creation of the object)
    public Event(long millisecondDelay) {
        delayTime = Duration.ofMillis(millisecondDelay);
        start();
    }

    public void start() { // Allows restarting
        eventTime = Instant.now().plus(delayTime);
    }

    public boolean ready() {
        return Instant.now().isAfter(eventTime);
    }

    public abstract void action();
}
