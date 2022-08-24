package new_feature_type_inference_generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Local Variable Type Inference which was
added to JDK 10/11. Conveniently, this feature also works to simplify definitions
involving generics. So our definition of an ArrayList<Apple> can be written in an
even cleaner fashion:
 */

class Apple {}

public class GenericTypeInference {
    void old() {
        ArrayList<Apple> apples = new ArrayList<>();
    }

    void modern() {
        var apples = new ArrayList<Apple>();
    }

    void pitFall() {
        var apples = new ArrayList<>();
        apples.add(new Apple());
        apples.get(0); // Comes back as plain Object.
    }

    /*
    Replacing the diamond syntax in existing code might produce a problem in some
    places, as seen in pitFall(). Simply replacing ArrayList<Apple> on the left side
    in old() with var in pitFall() successfully compiles. The <> becomes <Object>,
    which is not what we want but there’s no complaint by the compiler. We can
    successfully add an Apple to the ArrayList. But at some other point in the code
    when you fetch elements out of apples, they come back as ordinary Objects rather
    than specific Apples. You’ll probably find the problem from the compiler messages,
    but it might cause challenges to discover the issue when dealing with complicated
    code bases.
     */
}
