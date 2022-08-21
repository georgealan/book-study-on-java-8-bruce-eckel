package inner_classes_and_control_frameworks;

/*
    This class initializes the system and adds all the appropriate events. The Restart
    event is repeatedly run, and it loads the eventList into the GreenhouseControls
    object each time.

    It’s more flexible to read the events from a file instead of hard-coding them.
    This example moves you toward an appreciation of the value of inner classes,
    especially when used within a control framework.
 */

public class GreenhouseController {
    public static void main(String[] args) {
        GreenhouseControls gc = new GreenhouseControls();

        // Instead of using code, you could parse configuration information from a text file:
        gc.addEvent(gc.new Bell(900));

        Event[] eventList = {
            gc.new ThermostatNight(0),
            gc.new LightOn(200),
            gc.new LightOff(400),
            gc.new WaterOn(600),
            gc.new WaterOff(800),
            gc.new ThermostatDay(1400)
        };
        gc.addEvent(gc.new Restart(2000, eventList));
        gc.addEvent(new GreenhouseControls.Terminate(5000));
        gc.run();
    }
}
