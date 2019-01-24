package by.it.kushnerov.calc;


abstract class Var implements Operation {

    @Override
    public Var add(Var other) throws CalcExeption {
        throw new CalcExeption("Сложение "+this+" и "+other +" невозможно.");
    }

    @Override
    public Var sub(Var other) throws CalcExeption {
        System.out.println("Вычитание "+this+" и "+other +" невозможно.");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Умножение "+this+" и "+other +" невозможно.");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Деление "+this+" и "+other +" невозможно.");
        return null;
    }

    @Override
    public String toString() {
        return "Какая-то непонятная переменная";
    }

    static Var createVar(String operand) throws CalcExeption{
        operand=operand.trim();
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        else if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        else if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        throw new CalcExeption("Переменная "+operand+" не определена");
    }
}
