package by.it.zagurskaya.calc;

import java.util.Map;
import java.util.Scanner;


public class ConsoleRunner {

    public static final String PRINTVAR = "printvar";
    public static final String END = "end";

    public static void main(String[] args) throws CalcException {
//        public static void main(String[] args) throws CalcException {
        String expression;
        Scanner scanner = new Scanner(System.in);
        Parcer parcer = new Parcer();
        Printer printer = new Printer();
        while (!(expression = scanner.nextLine()).equals(END)) {
            try {

                if (expression.contains(PRINTVAR)) {
                    //набор соотношений
                    Map<String, Var> varMap = Var.getVars();
                    // итерирование по набору(коллекции) отношений(соотношение) клю-значение из Map
                    for (Map.Entry<String, Var> varEntry : varMap.entrySet()) {
                        System.out.print(varEntry.getKey() + "=");
                        printer.print(varEntry.getValue());
                    }
                } else {
                    Var result = parcer.calc(expression);
                    printer.print(result);
                }
            } catch ( CalcException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
