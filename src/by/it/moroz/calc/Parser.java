package by.it.moroz.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calc(String input) throws CalcExeption {

        Pattern oper = Pattern.compile(Patterns.OPERATION);
        String[] operands = input.trim().split(Patterns.OPERATION);
        Var two = Var.createVar(operands[1]);
        Matcher matcher = oper.matcher(input);
        String operation = null;
        if (matcher.find()) {
            operation = matcher.group();
        }
        if (operation.equals("=")) {
            Var.saveVar(operands[0], two);
            return two;
        }

        Var one = Var.createVar(operands[0]);
        if (one == null || two == null) {
            System.err.println("Операция " + input + " невозможна.");
            return null;
        }
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
        return null;
    }
}
