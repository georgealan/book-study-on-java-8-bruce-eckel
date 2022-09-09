package everything_is_an_object;

public class E10_ShowArgs {
    static String[] txt = {"A", "B", "C"};
    static String[] txt2 = {"A", "B"};

    public static void main(String[] args) {
        //args = txt;
        args = txt2;

        if (args.length < 3) {
            System.err.println("Need 3 arguments, please don't be foolish buddy!");
            System.exit(1);
        }

        System.out.println(args[0]);
        System.out.println(args[1]);
        System.out.println(args[2]);
    }

}

/*
TODO
 ****************** Exercise 10 ****************
 * Write a program that prints three arguments
 * taken from the command line.
 * You'll need to index into the command-line
 * array of Strings.
 ***********************************************
 */
