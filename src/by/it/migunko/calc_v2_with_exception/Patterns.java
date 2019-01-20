package by.it.migunko.calc_v2_with_exception;

class Patterns {
    private Patterns() {
    }

    static final String SCALAR="-?[0-9]+(\\.[0-9]+)?";
    static final String VECTOR="\\{("+SCALAR+",?\\s?)+}";
    static final String MATRIX="\\{("+VECTOR+",?\\s?)+}";
    static final String OPERATION="[+*/-]";

}
