package by.it.dziomin.сalculator;

import by.it.dziomin.сalculator.vars.Var;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calc(String expression) throws CalcException {
        Pattern pattern = Pattern.compile(Patterns.OPERATION);
        String[] operands = expression.trim().split(Patterns.OPERATION);
        Var one;
        Var two;
        if (operands.length > 1) {
            one = Var.createVar(operands[0]);
            two = Var.createVar(operands[1]);
        } else {
            throw new CalcException("Не определены операнды");
        }

        if (one == null) {
            throw new CalcException("Первый операнд не определен");
        }

        if (two == null) {
            throw new CalcException("Второй операнд не определен");
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
