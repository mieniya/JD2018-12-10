package by.it.yarmolenka.jd01_10.MathCalc;

import by.it.yarmolenka.jd01_10.MathCalc.Operations.*;
import by.it.yarmolenka.jd01_10.MathCalc.Variables.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parcer {
    Var calc(String expression) {
        Pattern cal = Pattern.compile(Patterns.OPERATION);
        String[] split = expression.trim().split(Patterns.OPERATION);
        Var one = Var.createVar(split[0]);
        Var two = Var.createVar(split[1]);
        if (one == null || two == null){
            System.out.println("операция " + expression + " невозможна");
            return null;
        }
        Matcher m = cal.matcher(expression);
        if (m.find()){
            String operation = m.group();
            switch (operation){
                case "+": return Add.addVarVar(one, two);
//                case "-": return one.sub(two);
//                case "*": return one.mul(two);
//                case "/": return one.div(two);
            }
        }
        return null;
    }
}
