package catching_any_exception;

public class ExceptionsMethods {
    public static void main(String[] args) {
        try {
            throw new Exception("My Exception");
        } catch (Exception e) {
            System.out.println("Caught Exception");
            System.out.println("getMessage():" + e.getMessage());
            System.out.println("getLocalizedMessage():" + e.getLocalizedMessage());
            System.out.println("toString():" + e);
            System.out.println("printStackTrace():");
            e.printStackTrace(System.out);
        }
    }
}
