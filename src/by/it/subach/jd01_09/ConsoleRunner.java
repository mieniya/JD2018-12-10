package by.it.subach.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {
    private static void print(Var var){
        System.out.println(var);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression;
        Parcer parcer = new Parcer();
        Printer printer = new Printer();

        while(!(expression = scanner.nextLine()).equals("end")){
            Var result = parcer.calc(expression);
            printer.print(result);
        }
    }
}
