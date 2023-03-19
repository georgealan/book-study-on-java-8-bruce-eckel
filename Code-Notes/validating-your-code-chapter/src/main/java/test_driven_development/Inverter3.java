package test_driven_development;

import static java.lang.Character.*;

public class Inverter3 implements StringInverter {

    @Override
    public String invert(String str) {
        if (str.length() > 30) {
            throw new RuntimeException("argument to long");
        }
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            result += isUpperCase(c) ? toLowerCase(c) : toUpperCase(c);
        }
        return result;
    }
}
