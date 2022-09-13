package intermediate_operations;

/*
The peek() operation is intended as an aid to debugging. It allows you to view stream
objects without modifying them:
 */
public class Peeking {
    public static void main(String[] args) throws Exception {
        FileToWords.stream("src/main/resources/Cheese.dat")
                .skip(21)
                .limit(4)
                .map(w -> w + " ")
                .peek(System.out::print)
                .map(String::toUpperCase)
                .peek(System.out::print)
                .map(String::toLowerCase)
                .forEach(System.out::print);
    }
}
