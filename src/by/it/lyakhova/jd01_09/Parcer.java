package by.it.lyakhova.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parcer {
    public Var calc(String expression) {
        //2+3
        //(1,2,3)*(4,5,6)
        //((1,2).(3,4))*(5,6)

        Pattern oper = Pattern.compile(Patterns.OPERATION);
        String[] operands = expression.trim().split(Patterns.OPERATION);
        Var one = Var.createVar(operands[0]);
        Var two = Var.createVar(operands[1]);
        if (one==null || two==null){
            System.err.println("Операция"+ expression+ "невозиожна");
            return null;
        }
        Matcher matcher = oper.matcher(expression);
        if (matcher.find()){
            String operation = matcher.group();
            switch (operation){
                case "+": return one.add(two);
                case "-": return one.sub(two);
                case "/": return one.div(two);
                case "*": return one.mul(two);
            }
        }

        return null;
    }
}
