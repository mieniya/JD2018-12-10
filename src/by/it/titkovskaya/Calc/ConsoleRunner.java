package by.it.titkovskaya.Calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        String expression;
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        while (!(expression = scanner.nextLine()).equalsIgnoreCase("END")) {
            try {
                Var result = parser.calc(expression);
                printer.print(result);
            } catch (CalcException e) {
                printer.showError(e);
            }
        }
    }
}