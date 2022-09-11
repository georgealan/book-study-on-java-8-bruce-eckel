package operators;

public class E09_MinMaxExponents {
    static Float floatMin = Float.MIN_VALUE;
    static Float floatMax = Float.MAX_VALUE;

    static Double doubleMin = Double.MIN_VALUE;
    static Double doubleMax = Double.MAX_VALUE;

    static Integer integerMin = Integer.MIN_VALUE;
    static Integer integerMax = Integer.MAX_VALUE;

    static Long longMin = Long.MIN_VALUE;
    static Long longMax = Long.MAX_VALUE;

    public static void main(String[] args) {
        System.out.println("Float Min and Max: " + floatMin + " | " + floatMax);
        System.out.println("Double Min and Max: " + doubleMin + " | " + doubleMax);
        System.out.println("Integer Min and Max: " + integerMin + " | " + integerMax);
        System.out.println("Long Min and Max: " + longMin + " | " + longMax);
    }
}

/*
TODO
 ****************** Exercise 9 *****************
 * Display the largest and smallest numbers for
 * both float and double exponential notation.
 ***********************************************
 */
