package by.it.zagurskaya.jd01_09;

//public class Var extends Object{
//  public Var(){
//     super();// контруктор предка
//    }
//}

abstract class Var implements by.it.zagurskaya.jd01_09.Operation {
    @Override
    public Var add(Var other) {
        System.out.println("Сложение " + this + "на" + other + "невозможно");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Вычитание " + this + "на" + other + "невозможно");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Деление " + this + "на" + other + "невозможно");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Умножение " + this + "на" + other + "невозможно");
        return null;
    }

    @Override
    public String toString() {
        return "непонятная переменная";
    }

    public static Var createVar(String operand) {
        operand = operand.trim();
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        System.err.println("ПЕременная не опредеклена");
        return null;
    }
}