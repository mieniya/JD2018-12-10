package by.it.dziomin.jd01_10.calculatorWithoutNewInstance;

public class Patterns {

    public static final String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    public static final String VECTOR = "\\{(" + SCALAR + ",?\\s?)+}";
    public static final String MATRIX = "\\{(" + VECTOR + ",?\\s?)+}";
    static final String OPERATION = "(?<=[0-9]\\}*)[+*/-]";

}
