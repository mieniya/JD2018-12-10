package by.it.yarmolenka.jd01_10.MathCalc.Variables;

import by.it.yarmolenka.jd01_10.MathCalc.Patterns;

public abstract class Var {
    public Var() {}

    public Var(String s){
        System.out.println("Неизвестная переменная " + s);
    }

    public static Var createVar(String s){
        s=s.trim();
        if (s.matches(Patterns.SCALAR)) return new Scalar(s);
        if (s.matches(Patterns.VECTOR)) return new Vector(s);
        if (s.matches(Patterns.MATRIX)) return new Matrix(s);
        System.out.println("Переменная " + s + " не определена");
        return null;
    }

    @Override
    public String toString(){
        return "Переменная";
    }
}
