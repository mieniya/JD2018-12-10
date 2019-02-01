package by.it.a_khmelev.calc_v4_with_multioperation_and_tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parcer {
    private List<String> operands;
    private List<String> operation;
    private HashMap<String,Integer> prior=new HashMap<String, Integer>(){
        {
            this.put("=",0);
            this.put("+",1);
            this.put("-",1);
            this.put("*",2);
            this.put("/",2);
        }
    };

    Var calc(String expression) throws CalcException {
        Pattern oper = Pattern.compile(Patterns.OPERATION);
        String[] mas = expression.trim().split(Patterns.OPERATION);
        operands = new ArrayList<>(Arrays.asList(mas));
        operation=new ArrayList<>();

        Matcher matcher = oper.matcher(expression);
        while (matcher.find()) {
            operation.add(matcher.group());
        }

        while (operation.size()>0){
            int indexOperation=getIndexOperation();
            String one=operands.remove(indexOperation);
            String op=operation.remove(indexOperation);
            String two=operands.remove(indexOperation);
            String result=oneOperation(one,op,two);
            operands.add(indexOperation,result);
        }
        return Var.createVar(operands.get(0));

    }

    private int getIndexOperation() {
        int res=-1;
        int p=-1;
        for (int i = 0; i < operation.size(); i++) {
            String op = operation.get(i);
            if (p < prior.get(op)) {
                res=i;
                p=prior.get(op);
            }
        }
        return res;
    }

    private String oneOperation(String strOne, String operation, String strTwo) throws CalcException {
        Var two = Var.createVar(strTwo);
        if (operation.equals("=")) {
            Var.saveVar(strOne, two);
            return two.toString();
        }

        Var one = Var.createVar(strOne);
        if (one == null || two == null) {
            System.err.println("Операция " + operation + " невозможна");
            return null;
        }
        switch (operation) {
            case "+":
                return one.add(two).toString();
            case "-":
                return one.sub(two).toString();
            case "*":
                return one.mul(two).toString();
            case "/":
                return one.div(two).toString();
        }

        return null;
    }
}
