package by.it.dziomin.jd01_10.calculatorWithoutNewInstance;

import by.it.dziomin.jd01_10.calculatorWithoutNewInstance.vars.Var;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calc(String expression) {
        Pattern pattern = Pattern.compile(Patterns.OPERATION);
        String[] operands = expression.trim().split(Patterns.OPERATION);
        Var one;
        Var two;
        if (operands.length > 1) {
            one = Var.createVar(operands[0]);
            two = Var.createVar(operands[1]);
        } else {
//            System.out.println("Операция " + expression + " не возможна");
            return null;
        }
        //TODO replace exception
        if (one == null || two == null) {
            System.out.println("Операция " + expression + " не возможна");
            return null;
        }
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()) {
            String operation = matcher.group();
            switch (operation) {
                case "+":
                    return one.add(two);
                case "-":
                    return one.sub(two);
                case "*":
                    return one.mul(two);
                case "/":
                    return one.div(two);
            }
        }
        return null;
    }
}
