package by.it.titkovskaya.Calculator;

import by.it.titkovskaya.Calculator.Interfaces.*;


abstract public class Var implements Operation, Addition, Subtraction, Multiplication, Division {

    static Var createVar(String operand) {
        operand = operand.trim().replace("\\s", "");
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        System.err.println("Переменная " + operand + " не определена");
        return null;
    }

    @Override
    public Var add(Var other) {
        System.out.println("Сложение " + this + " и " + other + " невозможно");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Вычитание " + this + " и " + other + " невозможно");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Умножение " + this + " на " + other + " невозможно");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Деление " + this + " на " + other + " невозможно");
        return null;
    }

    @Override
    public Var add(Var... other) {
        System.out.print("Сложение " + this + " и ");
        for (Var element : other) {
            System.out.print(element + " ");
        }
        System.out.println("невозможно");
        return null;
    }

    @Override
    public Var sub(Var... other) {
        System.out.print("Вычитание " + this + " и ");
        for (Var element : other) {
            System.out.print(element + " ");
        }
        System.out.println("невозможно");
        return null;
    }

    @Override
    public Var mul(Var... other) {
        System.out.print("Умножение " + this + " и ");
        for (Var element : other) {
            System.out.print(element + " ");
        }
        System.out.println("невозможно");
        return null;
    }

    @Override
    public Var div(Var... other) {
        System.out.print("Деление " + this + " и ");
        for (Var element : other) {
            System.out.print(element + " ");
        }
        System.out.println("невозможно");
        return null;
    }

    @Override
    public String toString() {
        return "Непонятная переменная";
    }

}
