package terminal_operations;

import intermediate_operations.FileToWords;

import static terminal_operations.RandInts.rands;

/*
• count(): The number of elements in this stream.
• max(Comparator): The "maximum" element of this stream as determined by the Comparator.
• min(Comparator): The "minimum" element of this stream as determined by the Comparator.
Strings have a predefined Comparator, which simplifies our example:
 */

public class Informational {
    public static void main(String[] args) throws Exception {
        System.out.println(FileToWords.stream("src/main/resources/Cheese.dat").count());

        System.out.println(FileToWords.stream("src/main/resources/Cheese.dat")
                .min(String.CASE_INSENSITIVE_ORDER)
                .orElse("NONE"));

        System.out.println(FileToWords.stream("src/main/resources/Cheese.dat")
                .max(String.CASE_INSENSITIVE_ORDER)
                .orElse("NONE"));


        // Information for Numeric Streams
        /*
        • average(): The usual meaning.
        • max() & min(): These don’t need a Comparator because they work on numeric streams.
        • sum(): Add up the values in the stream.
        • summaryStatistics(): Produces potentially useful data. It’s not quite clear why they felt the need
        for this one because you can produce all the data yourself with the direct methods.
         */
        System.out.println("\nInformation for Numeric Streams");
        System.out.println(rands().average().getAsDouble());
        System.out.println(rands().max().getAsInt());
        System.out.println(rands().min().getAsInt());
        System.out.println(rands().sum());
        System.out.println(rands().summaryStatistics());

        // The same operations are available for LongStreams and DoubleStreams.
    }
}
