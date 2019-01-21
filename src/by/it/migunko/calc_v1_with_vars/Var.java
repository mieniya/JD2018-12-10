package by.it.migunko.calc_v1_with_vars;

import java.util.HashMap;
import java.util.Map;
abstract class Var implements Operation {
    static Map<String, Var> vars = new HashMap<>();
    @Override
    public Var add(Var other) {
        System.out.println("Сложение "+this+" и "+other +" невозможно.");
        return null;
    }

    @Override
    public Var sub(Var other) {
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
    static Var saveVar (String name, Var var){
        vars.put(name, var);
        return var;
    }

    static Var createVar(String operand) {
        operand=operand.trim();
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        else if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        else if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        else if (vars.containsKey(operand))
            return vars.get(operand);
        System.err.println("Переменная "+operand+" не определена");
        return null;
    }


}


