package by.it.yarmolenka.jd01_09;


import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        String expression;
        Scanner sc = new Scanner(System.in);
        Parcer parcer = new Parcer();
        Printer printer = new Printer();
        while(!(expression=sc.nextLine()).equals("end")){
            Var result = parcer.calc(expression);
            printer.print(result);
        }
    }
}
