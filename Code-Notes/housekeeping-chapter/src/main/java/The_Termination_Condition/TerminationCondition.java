package The_Termination_Condition;


class Book {
    boolean checkedOut = false;

    Book(boolean checkOut) {
        checkedOut = checkOut;
    }

    void checkIn() {
        checkedOut = false;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void finalize() {
        if (checkedOut) {
            System.out.println("Error: checked out");
        }
    }
}

public class TerminationCondition {
    public static void main(String[] args) {
        Book novel = new Book(true);

        novel.checkIn();
        new Book(true);
        System.gc();
    }
}
