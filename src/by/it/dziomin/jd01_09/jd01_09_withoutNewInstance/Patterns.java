package by.it.dziomin.jd01_09.jd01_09_withoutNewInstance;

class Patterns {

    static final String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    static final String VECTOR = "\\{(" + SCALAR + ",?\\s?)+}";
    static final String MATRIX = "\\{(" + VECTOR + ",?\\s?)+}";

    static final String OPERATION = "(?<=[0-9]\\}*)[+*/-]";

}
