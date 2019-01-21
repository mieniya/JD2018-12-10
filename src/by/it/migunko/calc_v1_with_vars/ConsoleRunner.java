package by.it.migunko.calc_v1_with_vars;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        String expression;
        Scanner scanner = new Scanner(System.in);
        Parcer parcer=new Parcer();
        Printer printer=new Printer();

        while (!(expression = scanner.nextLine()).equalsIgnoreCase("END")) {
            Var result=parcer.calc(expression);
            printer.print(result);
        }
    }
}

