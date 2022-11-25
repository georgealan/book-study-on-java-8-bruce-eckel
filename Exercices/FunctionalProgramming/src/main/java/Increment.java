import java.util.function.BiFunction;
import java.util.function.Function;

public class Increment {

    static Function<Integer, Integer>
    increment = t -> t + 1,
    multiply = t -> t * 50,
    divide = t -> t / 2,
    incrementAndMultiply = increment.andThen(multiply).andThen(divide);

    static BiFunction<Integer, Integer, Integer> printMultiplicationTable = (t, u) -> t * u;

    public static void main(String[] args) {
        System.out.println(incrementAndMultiply.apply(4));

        System.out.println("Print Multiplication Table until 10");
        for (int i = 1; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                System.out.println(i + " * " + j + " = " + printMultiplicationTable.apply(i, j));
            }
            System.out.println();
        }

    }
}
