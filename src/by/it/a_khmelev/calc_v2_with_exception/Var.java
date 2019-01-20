package by.it.a_khmelev.calc_v2_with_exception;


import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    static Map<String, Var> vars = new HashMap<>();

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Сложение " + this + " и " + other + " невозможно.");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        System.out.println("Вычитание " + this + " и " + other + " невозможно.");
        return null;
    }

    @Override
    public Var mul(Var other) throws CalcException {
        System.out.println("Умножение " + this + " и " + other + " невозможно.");
        return null;
    }

    @Override
    public Var div(Var other) throws CalcException {
        System.out.println("Деление " + this + " и " + other + " невозможно.");
        return null;
    }

    @Override
    public String toString() {
        return "Какая-то непонятная переменная";
    }

    static Var createVar(String operand) throws CalcException {
        operand = operand.trim();
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        else if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        else if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        else if (vars.containsKey(operand))
            return vars.get(operand);
        throw new CalcException("Переменная " + operand + " не определена");
    }

    static void saveVar(String nameVar, Var value) {
        vars.put(nameVar, value);
    }
}
