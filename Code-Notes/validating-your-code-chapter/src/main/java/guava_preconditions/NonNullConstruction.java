package guava_preconditions;

import static com.google.common.base.Preconditions.*;

public class NonNullConstruction {
    private Integer n;
    private String s;

    // Here’s how to use it in a constructor to prevent object construction containing null values:
    NonNullConstruction(Integer n, String s) {
        this.n = checkNotNull(n);
        this.s = checkNotNull(s);
    }

    public static void main(String[] args) {
        NonNullConstruction nnc = new NonNullConstruction(3, "Trousers");
        NonNullConstruction nnc2 = new NonNullConstruction(3,  null);
    }
}
