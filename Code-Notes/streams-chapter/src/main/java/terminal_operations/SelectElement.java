package terminal_operations;

import static terminal_operations.RandInts.rands;

public class SelectElement {
    public static void main(String[] args) {
        System.out.println(rands().findFirst().getAsInt());
        System.out.println(rands().parallel().findFirst().getAsInt());
        System.out.println(rands().findAny().getAsInt());
        System.out.println(rands().parallel().findAny().getAsInt());
    }
}

/*
• findFirst(): returns an Optional containing the first element of the stream,
or Optional.empty if the stream has no elements.

• findAny(): returns an Optional containing some element of the stream, or
Optional.empty if the stream has no elements.

findFirst() will always select the first element in the stream, whether or not the
stream is parallel(). For a non-parallel() stream, findAny() chooses the first
element (although from the definition it has the option to choose any element). In this
example, making the stream parallel() introduces the possibility that findAny()
chooses other than the first element.
 */
