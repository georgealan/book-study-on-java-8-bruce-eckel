package lambda_expressions;

interface Book {
    String bookName(String name);
    String author(String author, int age);
    int pagesNumber(int pagesNumber);
    /*
    When have more than one method signatures in an interface, and they can't be overriden
    lambda expressions don't work. (I don't know now, I'll study more for find a way)
     */
}

interface Category {
    String category(String categoryName);
}

public class LambdaPractice1 {
    static int number = 28;

    static Category cat1 = (cat) -> cat + "Programming Books";

    public static void main(String[] args) {
        System.out.println(cat1.category("This book belong to: "));

    }
}
