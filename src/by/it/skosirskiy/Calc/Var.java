package by.it.skosirskiy.Calc;

import java.util.*;

abstract class Var implements Operation {



    private static HashMap<String,Var> vars=  new HashMap<>();
    static Var saveVar(String name, Var var){
        vars.put(name, var);
        return var;
    }

    public static void printvar(){
        System.out.println(vars);
    }
    public static void sortvar(){
        TreeMap<String, Var> treeMap = new TreeMap<>(vars);
        System.out.println(treeMap);
    }

    static Var createVar(String operand) throws CalcException{
        operand=operand.trim().replace("\\s+","");
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        else if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        else if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        else if (vars.containsKey(operand)) return vars.get(operand);

        throw new CalcException("Невозможно создать "+operand);

    }


    @Override
    public Var add(Var other) throws CalcException  {
        throw new CalcException("Операция сложения "+this+"+"+other+"невозможна");

    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Операция вычитания "+this+"-"+other+"невозможна");

    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Операция умножения "+this+"*"+other+"невозможна");

    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Операция деления "+this+"/"+other+"невозможна");

    }
}
