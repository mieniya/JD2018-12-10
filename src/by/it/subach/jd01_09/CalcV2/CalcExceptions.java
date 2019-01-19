package by.it.subach.jd01_09.CalcV2;

public class CalcExceptions extends Exception {
    public CalcExceptions() {
        super();
    }

    public CalcExceptions(String message) {
        super("ERROR: " + message);
    }

    public CalcExceptions(String message, Throwable cause) {
        super("ERROR: " + message, cause);
    }

    public CalcExceptions(Throwable cause) {
        super(cause);
    }
}
