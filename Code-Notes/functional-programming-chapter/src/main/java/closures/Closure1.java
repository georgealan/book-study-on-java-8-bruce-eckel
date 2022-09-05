package closures;

import java.util.function.IntSupplier;

/*
Consider a more complex lambda, one that uses variables outside its function scope.
What happens when you return that function? That is, what does it reference for
those outside variables when you call the function? It becomes quite challenging if
the language doesn’t automatically solve this problem. Languages that do solve it are
said to support closures, or to be lexically scoped (the term variable capture is also
used). Java 8 provides limited, but reasonable, closure support.

First, here’s a method to return a function that accesses an object field and a method
argument:
 */
public class Closure1 {
    int i;
    IntSupplier makeFun(int x) {
        return () -> x + i++;
    }

    /*
    Under further consideration, this use of i isn’t that big of a challenge, because the
    object is likely to exist after you call makeFun()—indeed, the garbage collector almost
    certainly preserves an object with extant functions tied back to it this way.
     */
}
