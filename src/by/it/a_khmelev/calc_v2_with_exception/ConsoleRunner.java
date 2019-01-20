package by.it.a_khmelev.calc_v2_with_exception;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        String expression;
        Scanner scanner = new Scanner(System.in);
        Parcer parcer=new Parcer();
        Printer printer=new Printer();

        while (!(expression = scanner.nextLine()).equalsIgnoreCase("END")) {
            Var result= null;
            try {
                result = parcer.calc(expression);
                printer.print(result);
            } catch (CalcException e) {
                printer.showError(e);
            }
        }
    }
}