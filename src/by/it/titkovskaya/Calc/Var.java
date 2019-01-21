package by.it.titkovskaya.Calc;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

abstract class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();

    static Var createVar(String operand) throws CalcException {
        operand = operand.trim().replace("\\s", "");
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

    public static void showVar() {
        for (Map.Entry<String, Var> varEntry : vars.entrySet()) {
            System.out.println(varEntry.getKey()+"="+varEntry.getValue());
        }
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Сложение " + this + " и " + other + " невозможно");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Вычитание " + this + " и " + other + " невозможно");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Умножение " + this + " на " + other + " невозможно");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Деление " + this + " на " + other + " невозможно");
    }

    @Override
    public String toString() {
        return "Какая-то непонятная переменная";
    }

}
