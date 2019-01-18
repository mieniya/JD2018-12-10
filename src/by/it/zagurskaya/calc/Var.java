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

    public static Var createVar(String operand) {
        operand = operand.trim();
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        if (vars.containsKey(operand))
                return vars.get(operand);
        System.err.println("ПЕременная не опредеклена");
        return null;
    }

//    static Var createVar (String strVar){
//        if (strVar.matches(Patterns.SCALAR))
//            return new Scalar(strVar);
//        else
//        if (strVar.matches(Patterns.VECTOR))
//            return new Vector(strVar);
//        else
//        if (strVar.matches(Patterns.MATRIX))
//            return new Matrix(strVar);
//        else
//            if (vars.containsKey(strVar))
//                return vars.get(strVar);
//        //return null;
//        return Var;
//    }

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


}