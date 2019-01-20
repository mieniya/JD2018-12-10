package by.it.yarmolenka.MathCalc_v1_severalCalcuations_singleBrackets_Exceptions.Variables;

import by.it.yarmolenka.MathCalc_v1_severalCalcuations_singleBrackets_Exceptions.CalcException;
import by.it.yarmolenka.MathCalc_v1_severalCalcuations_singleBrackets_Exceptions.Patterns;

import java.util.TreeMap;

public abstract class Var {
    private static TreeMap<String, Var> list = new TreeMap<>();

    public Var() {}

    public Var(String s){
        System.out.println("Неизвестная переменная " + s);
    }

    public static Var createVar(String s) throws CalcException {
        s=s.trim();
        if (list.containsKey(s)) return list.get(s);
        if (s.matches(Patterns.SCALAR)) return new Scalar(s);
        if (s.matches(Patterns.VECTOR)) return new Vector(s);
        if (s.matches(Patterns.MATRIX)) return new Matrix(s);
        throw new CalcException("не знаю переменную " + s);
    }

    public static void addVar(String s, Var two) {
        list.put(s, two);
    }

    public static Var getVariable(String s) {
        return list.get(s);
    }

    @Override
    public String toString(){
        return "Переменная";
    }
}
