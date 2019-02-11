package by.it.titkovskaya.Temp;
/*
//Factory method (VarFactory)

import by.it.titkovskaya.calculator.*;
import by.it.titkovskaya.calculator.internationalization.strings.Programme;

public abstract class VarCreator {

    static Var createVar(String operand) throws CalcException {
        operand = operand.trim().replace("\\s", "");
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        else if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        else if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        else if (Var.vars.containsKey(operand))
            return Var.vars.get(operand);
        throw new CalcException(ResMan.INSTANCE.get(Programme.VARIABLE) + " " + operand + " "
                + ResMan.INSTANCE.get(Programme.NOT_DEFINED));
    }

    public abstract Var factoryMethod(String operand);
}
*/