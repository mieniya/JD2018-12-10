package by.it.migunko.calc_tests;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    private static Map<String, Integer> priorityMap = new HashMap<>() {
        {
            this.put("=", 0);
            this.put("+", 1);
            this.put("-", 1);
            this.put("*", 2);
            this.put("/", 2);
        }
    };

    private List<String> operations;
    private List<String> operands;

    private int getNumberOp() {
        int pos = -1;
        int level = -1;
        for (int i = 0; i < operations.size(); i++) {
            String currentOp = operations.get(i);
            if (level < priorityMap.get(currentOp)) {
                level = priorityMap.get(currentOp);
                pos = i;
            }
        }
        return pos;
    }

    String getLetters(String expression) {
        Pattern patternL = Pattern.compile(Patterns.LETTERS);
        Matcher matcherL = patternL.matcher(expression);
        while (matcherL.find()) {
            return (matcherL.group());
        }
        return null;
    }

    private Var oneOperation(String left, String op, String right) throws CalcException {
        Var two = Var.createVar(right);
        if (op.equals("=")) {
            return Var.saveVar(left, two);
        }
        Var one = Var.createVar(left);
        if (one == null || two == null)
            throw new CalcException(
                    "невозможно обработать");

        switch (op) {
            case "+":
                return one.add(two);
            case "-":
                return one.sub(two);
            case "*":
                return one.mul(two);
            case "/":
                return one.div(two);
        }
        throw new CalcException(
                "нет такой операцции");
    }

    Var calc(String expression) throws CalcException {
        Pattern pattern = Pattern.compile(Patterns.BRACKETS);
        Matcher matcher = pattern.matcher(expression);
        while (matcher.find()) {
            String st = matcher.group();
            String str = st.replace("(", "").replace(")", "");
            expression = expression.replace(st, calc(str).toString());
            matcher = pattern.matcher(expression);
        }
        operands = new ArrayList<>(
                Arrays.asList(expression.split(Patterns.OPERATION))
        );
        Pattern patternOp = Pattern.compile(Patterns.OPERATION);
        Matcher matcherOp = patternOp.matcher(expression);
        operations = new ArrayList<>();
        while (matcherOp.find()) {
            operations.add(matcherOp.group());
        }
        Var res = Var.createVar(expression);
        while (operations.size() > 0) {
            int num = getNumberOp();
            String left = operands.remove(num);
            String op = operations.remove(num);
            String right = operands.get(num);
            res = oneOperation(left, op, right);
            operands.set(num, res.toString());
        }
        return res;
    }
}
