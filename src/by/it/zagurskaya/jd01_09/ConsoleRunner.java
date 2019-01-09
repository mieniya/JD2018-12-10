package by.it.zagurskaya.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        String expression;
        Scanner scanner = new Scanner(System.in);
        Parcer parcer=new Parcer();
        Printer printer=new Printer();
        while (!(expression = scanner.nextLine()).equals("end")) {
            Var result=parcer.calc(expression);
            printer.print(result);
        }

    }
}