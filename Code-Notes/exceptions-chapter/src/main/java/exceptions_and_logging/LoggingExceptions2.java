package exceptions_and_logging;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

// Generating the log message in the exception handler.
public class LoggingExceptions2 {
    private static Logger logger = Logger.getLogger("LoggingException2");

    static void logException(Exception e) {
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }

    public static void main(String[] args) {
        try {
            throw new NullPointerException();
        } catch (NullPointerException e) {
            logException(e);
        }
    }
}
