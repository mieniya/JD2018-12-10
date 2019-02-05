package by.it.zagurskaya.calc;

//public class Var extends Object{
//  public Var(){
//     super();// контруктор предка
//    }
//}

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {
    private static Map<String, Var> vars = new HashMap<>();

    public static Map<String, Var> getVars() {
        return vars;
    }

    static Var saveVar(String name, Var var){
        vars.put(name,var);
        return var;
    }

    public static Var createVar(String operand) throws CalcException {
        operand = operand.trim();
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        if (vars.containsKey(operand))
                return vars.get(operand);
//        throw new CalcException("Переменная не определена" + operand);//notDefined
        throw new CalcException(Localmessages.NOTDEFINED + operand);//notDefined
    }

    @Override
    public Var add(Var other) throws CalcException {
//        throw new CalcException("Сложение " + this + "на" + other + "невозможно");//addition on impossible
        throw new CalcException(Localmessages.ADDITION + this + Localmessages.ON + other + Localmessages.IMPOSSIBLE);//addition on impossible
    }

    @Override
    public Var sub(Var other) throws CalcException {
//        throw new CalcException("Вычитание " + this + "на" + other + "невозможно");//subtraction on impossible
        throw new CalcException(Localmessages.SUBTRACTION + this + Localmessages.ON + other + Localmessages.IMPOSSIBLE);//subtraction on impossible

    }

    @Override
    public Var div(Var other) throws CalcException {
//        throw new CalcException("Деление " + this + "на" + other + "невозможно");//division on impossible
        throw new CalcException(Localmessages.DIVISION + this + Localmessages.ON + other + Localmessages.IMPOSSIBLE);//division on impossible

    }

    @Override
    public Var mul(Var other) throws CalcException {
//        throw new CalcException("Умножение " + this + "на" + other + "невозможно"); //multiplication on impossible
        throw new CalcException(Localmessages.MULTIPLICATION+ this + Localmessages.ON + other + Localmessages.IMPOSSIBLE); //multiplication on impossible

    }

    @Override
    public String toString() {

//        return "непонятная переменная";
        return Localmessages.NOTDEFINED;
    }//notDefined


}