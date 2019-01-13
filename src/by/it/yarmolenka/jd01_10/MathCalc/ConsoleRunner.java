package by.it.yarmolenka.jd01_10.MathCalc;

import by.it.yarmolenka.jd01_10.MathCalc.Variables.Var;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        String expression;
        Scanner scan = new Scanner(System.in);
        Parcer parcer = new Parcer();
        Printer printer = new Printer();
        while(!(expression=scan.nextLine()).equals("end")){
            Var result = parcer.calc(expression);
            printer.print(result);
        }
    }
}
