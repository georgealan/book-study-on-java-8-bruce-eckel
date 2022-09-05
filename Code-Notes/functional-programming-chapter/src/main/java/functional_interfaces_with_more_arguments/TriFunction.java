package functional_interfaces_with_more_arguments;

/*
The interfaces in java.util.function are limited. There’s a BiFunction, but it
stops there. What if you need an interface for three-argument functions? Those
interfaces are fairly straightforward, so it’s easy to look at the Java library source
code and make our own:
 */

@FunctionalInterface
public interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}
