package guava_assertions;

import com.google.common.base.*;
import static com.google.common.base.Verify.*;

public class GuavaAssertions {
    public static void main(String[] args) {
        verify(2 + 2 == 4);

        try {
            verify(1 + 2 == 4);
        } catch (VerifyException e) {
            System.out.println(e);
        }

        try {
            verify(1 + 2 == 4, "Bad math");
        } catch (VerifyException e) {
            System.out.println(e.getMessage());
        }

        try {
            verify(1 + 2 == 4, "Bad math: %s", "not 4");
        } catch (VerifyException e) {
            System.out.println(e.getMessage());
        }

        String s = "";
        s = verifyNotNull(s);
        s = null;

        try {
            verifyNotNull(s);
        } catch (VerifyException e) {
            System.out.println(e.getMessage());
        }

        try {
            verifyNotNull(s, "Shouldn't be null: %s", "arg s");
        } catch (VerifyException e) {
            System.out.println(e.getMessage());
        }
    }
}
