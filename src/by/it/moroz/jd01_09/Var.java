package by.it.moroz.jd01_09;

public abstract class Var implements Operation {

    public static Var createVar(String operand) {
        if(operand.matches(Patterns.SCALAR)) return new Scalar(operand);
        if(operand.matches(Patterns.VECTOR)) return new Vector(operand);
        if(operand.matches(Patterns.MATRIX)) return new Matrix(operand);
        //TODO Replace on errors
        System.err.println("Переменная "+operand+" неопределена.");
        return null;
    }

    @Override
    public Var add(Var other) {
        System.out.println("Сложение "+this+" на "+other+" невозможно.");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Вычитание "+this+" на "+other+" невозможно.");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Умножение "+this+" на "+other+" невозможно.");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Деление "+this+" на "+other+" невозможно.");
        return null;
    }

}
