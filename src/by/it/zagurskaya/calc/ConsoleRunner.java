package by.it.zagurskaya.calc;

import java.util.Map;
import java.util.Scanner;


public class ConsoleRunner {

    public static final String PRINTVAR = "printvar";
    public static final String END = "end";

    public static void main(String[] args) {
        String expression;
        Scanner scanner = new Scanner(System.in);
        Parcer parcer = new Parcer();
        Printer printer = new Printer();
        while (!(expression = scanner.nextLine()).equals(END)) {
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
        }
    }
}
