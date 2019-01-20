package by.it.titkovskaya.Calc;

public class CalcException extends Exception {

    public CalcException() {
        super();
    }

    public CalcException(String message) {
        System.out.println("ERROR: " + message);
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR: " + message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }
}
