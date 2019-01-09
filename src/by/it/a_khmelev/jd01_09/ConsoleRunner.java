package by.it.a_khmelev.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {
    private static void print(Var var){
        System.out.println(var);
    }

    public static void main(String[] args) {
        String expression;
        Scanner scanner = new Scanner(System.in);
        Parcer parcer=new Parcer();
        Printer printer=new Printer();

        while (!(expression = scanner.nextLine()).equals("END")) {
            Var result=parcer.calc(expression);
            printer.print(result);
        }

    }
}