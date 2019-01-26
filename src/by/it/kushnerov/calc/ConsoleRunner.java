package by.it.kushnerov.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) throws CalcExeption {
        String expression;
        Scanner scanner = new Scanner(System.in);
        Parcer parcer = new Parcer();
        Printer printer = new Printer();
        while (!(expression = scanner.nextLine()).equals("END")) {
            Var result = parcer.calc(expression);
            printer.print(result);
        }
    }
}