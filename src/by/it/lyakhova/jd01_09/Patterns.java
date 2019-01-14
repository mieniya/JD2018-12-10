package by.it.lyakhova.jd01_09;

public class Patterns {

    private Patterns(){

    }

    static final String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    static final String VECTOR = "\\{("+SCALAR+",?\\s?)+}";
    static final String MATRIX = "\\{("+VECTOR+",?\\S?)+}";
    static final String OPERATION = "[+*/-]";


}
