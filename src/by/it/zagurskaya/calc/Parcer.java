package by.it.zagurskaya.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parcer {
    Var calc(String expression) {
        Pattern oper = Pattern.compile(Patterns.OPERATION);
        String[] operands = expression.trim().split(Patterns.OPERATION);
        Var two = Var.createVar(operands[1]);
        if (expression.contains("=")) {
            return Var.saveVar(operands[0], two);
        }
        Var one = Var.createVar(operands[0]);
        if (one == null || two == null) {
            System.err.println("Операция " + expression + " невозможна");
            return null;
        }
        Matcher matcher = oper.matcher(expression);
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
