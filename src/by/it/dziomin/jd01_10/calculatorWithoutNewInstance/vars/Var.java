package by.it.dziomin.jd01_10.calculatorWithoutNewInstance.vars;

import by.it.dziomin.jd01_10.calculatorWithoutNewInstance.Patterns;
import by.it.dziomin.jd01_10.calculatorWithoutNewInstance.interfaces.*;

public abstract class Var implements IVar, IAdd, IDiv, IMul, ISub {

    public abstract String toString();

    public boolean isScalar() {
        return false;
    }

    public boolean isVector() {
        return false;
    }

    public boolean isMatrix() {
        return false;
    }


    @Override
    public Var add(Var other) {
        new Error("Сложение невозможно");
        return null;
    }

    @Override
    public Var sub(Var other) {
        new Error("Вычитание невозможно");
        return null;
    }

    @Override
    public Var mul(Var other) {
        new Error("Умножение невозможно");
        return null;
    }

    @Override
    public Var div(Var other) {
        new Error("Деление невозможно");
        return null;
    }

    public static Var createVar(String operand) {
        operand = operand.trim();
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);

        return null;
    }
}
