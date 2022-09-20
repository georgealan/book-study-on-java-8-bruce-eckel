package performing_cleanup_with_finally;

/*
Because a finally clause is always executed, it’s possible to return from multiple
points within a method and still guarantee that important cleanup is performed:
 */
public class MultipleReturns {
    public static void f(int i) {
        System.out.println("Initialization that requires cleanup");
        try {
            System.out.println("Point 1");
            if (i == 1) return;
            System.out.println("Point 2");
            if (i == 2) return;
            System.out.println("Point 3");
            if (i == 3) return;
            System.out.println("End");
            return;
        } finally {
            System.out.println("Performing cleanup");
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 4; i++) {
            f(i);
        }
    }
    // The output shows it doesn’t matter where you return, the finally clause always runs.
}
