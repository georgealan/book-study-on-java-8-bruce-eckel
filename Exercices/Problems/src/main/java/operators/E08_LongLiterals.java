package operators;

public class E08_LongLiterals {
    public static void main(String[] args) {
        long hex1 = 0x22212C;
        long hex2 = 0x3f;
        long bin1 = 101111;
        long bin2 = 111111;

        String hexToBin1 = convertToBinary(hex1);
        String hexToBin2 = convertToBinary(hex2);
        System.out.println(hexToBin1 + " | " + hexToBin2);

        String binToHex1 = convertToHexaDecimal(bin1);
        String binToHex2 = convertToHexaDecimal(bin2);
        System.out.println(binToHex1 + " | " + binToHex2);
    }

    static String convertToBinary(long hex) {
        return Long.toBinaryString(hex);
    }

    static String convertToHexaDecimal(long bin) {
        return Long.toHexString(bin);
    }
}

/*
TODO
 ****************** Exercise 8 *****************
 * Show that hex and octal notations work with long
 * values. Use Long.toBinaryString() to display
 * the results.
 ***********************************************
 */

