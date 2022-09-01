package forin_and_iterators;

import java.util.Map;

/*
System.getenv() returns a Map, entrySet() produces a Set of Map.Entry
elements, and a Set is Iterable so it can be used in a for-in loop.
 */

public class EnvironmentVariables {
    public static void main(String[] args) {
        for (Map.Entry entry : System.getenv().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
