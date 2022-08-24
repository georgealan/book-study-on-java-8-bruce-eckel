package adding_groups_of_elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
It’s also possible to use the output of Arrays.asList() directly, as a List, but the
underlying representation is an array, which cannot be resized. Trying to add() or
remove() elements in such a list attempts to change the size of the underlying array.
You’ll get an "Unsupported Operation" runtime error:
 */

class Snow {}
class Powder extends Snow {}
class Light extends Powder {}
class Heavy extends Powder {}
class Crusty extends Snow {}
class Slush extends Snow {}

public class AsListInference {
    public static void main(String[] args) {
        List<Snow> snows1 = Arrays.asList(
            new Crusty(),
            new Slush(),
            new Powder()
        );
        // Code below cause Exceptions:
        //snows1.add(new Heavy()); // Exception
        //snows1.remove(0); // Exception

        List<Snow> snows2 = Arrays.asList(
            new Light(),
            new Heavy()
        );
        // Code below cause Exceptions:
        //snows2.add(new Slush()); // Exception
        //snows2.remove(0); // Exception

        List<Snow> snows3 = new ArrayList<>();
        Collections.addAll(
            snows3,
            new Light(),
            new Heavy(),
            new Powder()
        );
        snows3.add(new Crusty());
        snows3.remove(0);

        // Hint with explicit type argument specification:
        List<Snow> snows4 = Arrays.<Snow>asList(
            new Light(),
            new Heavy(),
            new Slush()
        );
        // Code below cause Exceptions:
        //snows4.add(new Powder()); // Exception
        //snows4.remove(0); // Exception
    }

    /*
    In snow4, notice the "hint" in the middle of Arrays.asList(), to tell the compiler
    the target type for the List produced by Arrays.asList(). This is called an explicit
    type argument specification.
     */
}
