package try_with_resources;

class CE extends Exception {}

class SecondExcept extends Reporter {
    SecondExcept() throws CE {
        super();
        throw new CE();
    }
}

public class ConstructorException {
    public static void main(String[] args) {
        try (
            First f = new First();
            SecondExcept s = new SecondExcept();
            Second s2 = new Second() // Isn't created because the SecondExcept throws an exception
        ) {
            System.out.println("In body");
        } catch (CE e) {
            System.out.println("Caught: " + e);
        }
    }
}

/*
Now there are three objects defined in the resource specification header, and
the middle one throws an exception. Because of this, the compiler forces us to
have a catch clause to catch the constructor exception. This means the resource
specification header is actually enclosed by the try block.

As expected, First is created without incident, and SecondExcept throws an
exception during creation. Notice that close() is not called for SecondExcept,
because if your constructor fails you can’t assume you can do anything safely with
that object, including close it. Because of the exception from SecondExcept, the
Second object s2 is never created, so it is not cleaned up.
 */
