package by.it.moroz.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
     Var calc(String input) {

         Pattern oper = Pattern.compile(Patterns.OPERATION);
         String[] operands = input.split(Patterns.OPERATION);
         Var one = Var.createVar(operands[0]);
         Var two = Var.createVar(operands[1]);

         if (one==null || two==null){
             System.err.println("Операция "+input+" невозможна.");
             return null;
         }
         Matcher matcher = oper.matcher(input);
         if(matcher.find()){
             String operation = matcher.group();

             switch (operation){
                 case "+" : return one.add(two);
                 case "-" : return one.sub(two);
                 case "*" : return one.mul(two);
                 case "/" : return one.div(two);
             }
         }
        return null;
    }
}
