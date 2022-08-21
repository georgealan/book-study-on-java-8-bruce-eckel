package inner_classes_and_control_frameworks;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    // A class from Java util to hold Event objects
    private List<Event> eventList = new ArrayList<>();
    public void addEvent(Event c) { eventList.add(c); }

    public void run() {
        while (eventList.size() > 0) {
            // Make a copy so you're not modifying the list while you're selecting the elements in it:
            for (Event e : new ArrayList<>(eventList)) {
                if (e.ready()) {
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);
                }
            }
        }
    }
}
