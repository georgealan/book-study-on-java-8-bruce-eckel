package constructors;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InputFile {
    private BufferedReader in;

    public InputFile(String fname) throws Exception {
        try {
            in = new BufferedReader(new FileReader(fname));
            // Other code that might throw exceptions
        } catch (FileNotFoundException e) {
            System.out.println("Could not open" + fname);
            /* Wasn't open, so don't close it
            If the FileReader constructor is unsuccessful, it throws a FileNotFoundException.
            This is the one case when you don’t close the file, because it wasn’t successfully opened.
             */
            throw e;
        } catch (Exception e) {
            // All other exceptions must close it
            try {
                in.close();
            } catch (IOException e2) {
                System.out.println("in.close() unsuccessful");
            }
            throw e; // Rethrow
        } finally {
            /* Don't close it here!!!
            In this example, the finally clause is definitely not the place to close() the file
            because that would close it every time the constructor completed. We want the file
            to be open for the useful lifetime of the InputFile object.
             */
        }
    }

    public String getLine() {
        String s;
        try {
            s = in.readLine();
        } catch (IOException e) {
            throw new RuntimeException("readLine() failed");
        }
        return s;
        /*
        In this situation, the getLine() method converts the exception to a RuntimeException to indicate a
        programming error.
         */
    }

    public void dispose() {
        try {
            in.close();
            System.out.println("dispose() successful");
        } catch (IOException e2) {
            throw new RuntimeException("inClose() failed");
        }
    }
}

/*
It's a particularly thorny case, because the file is opened (with all
the possible exceptions from that), then it is left open for the lifetime of the object.
Each call to getLine() can cause an exception, and so can dispose(). This is a
good example only because it shows how messy things can be. It also demonstrates
that you should try your best not to design your code that way (of course, you often
get into situations when it’s not your choice how the code is designed, so you must
still understand it).
 */
