package high_order_functions;

import java.util.function.Function;

class One {}
class Two {}

/*
To consume a function, the consuming method must describe the function type
correctly in its argument list:
 */
public class ConsumeFunction {
    static Two consume(Function<One,Two> oneTwo) {
        return oneTwo.apply(new One());
    }

    public static void main(String[] args) {
        Two two = consume(one -> new Two());
    }
}
