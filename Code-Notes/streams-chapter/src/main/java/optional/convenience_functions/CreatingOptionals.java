package optional.convenience_functions;

import java.util.Optional;

/*
When you’re writing your own code that produces Optionals, there are three static methods you can use:

• empty(): Produces an Optional with nothing inside.
• of(value): If you already know that value is not null, use this to wrap it in an Optional.
• ofNullable(value): Use this if you don’t know that value is not null.
It automatically produces Optional.empty if value is null, and otherwise wraps value inside an Optional.

You can see how these work:
 */
public class CreatingOptionals {
    static void test(String testName, Optional<String> opt) {
        System.out.println(" === " + testName + " === ");
        System.out.println(opt.orElse("Null"));
    }

    public static void main(String[] args) {
        test("empty", Optional.empty());
        test("of", Optional.of("Howdy"));
        try {
            test("of", Optional.of(null));
        } catch (Exception e) {
            System.out.println(e);
        }
        test("ofNullable", Optional.ofNullable("Hi"));
        test("ofNullable", Optional.ofNullable(null));
    }
}
/*
If we try to create an Optional by passing null to of(), it blows up. ofNullable()
handles null gracefully, so it seems the safest one to use.
 */
