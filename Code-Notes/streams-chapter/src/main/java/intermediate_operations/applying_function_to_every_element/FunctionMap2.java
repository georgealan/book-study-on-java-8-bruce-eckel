package intermediate_operations.applying_function_to_every_element;

import java.util.stream.Stream;

class Numbered {
    final int n;
    Numbered(int n) { this.n = n; }
    @Override public String toString() {
        return "Numbered(" + n + ")";
    }
}

public class FunctionMap2 {
    public static void main(String[] args) {
        Stream.of(1, 5, 7, 9, 11, 13)
                .map(Numbered::new)
                .forEach(System.out::println);

        // We take ints and turn them into Numbered's using the constructor Numbered::new.
    }
}
