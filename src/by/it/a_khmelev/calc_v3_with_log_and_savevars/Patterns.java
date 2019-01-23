package by.it.a_khmelev.calc_v3_with_log_and_savevars;

class Patterns {

    private Patterns() {
    }

    static final String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    static final String VECTOR = "\\{(" + SCALAR + ",?\\s?)+}";
    static final String MATRIX = "\\{(" + VECTOR + ",?\\s?)+}";
    static final String OPERATION = "[=+*/-]";

}
