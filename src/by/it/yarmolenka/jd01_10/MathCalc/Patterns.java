package by.it.yarmolenka.jd01_10.MathCalc;

public class Patterns {

    private Patterns() {
    }

    public static final String SCALAR = "-?[0-9]+(.[0-9]+)?";
    public static final String VECTOR = "\\{(" + SCALAR + ",?\\s?)+}";
    public static final String MATRIX = "\\{(" + VECTOR + ",?\\s?)+}";
    public static final String OPERATION = "[+*/-]";
}
