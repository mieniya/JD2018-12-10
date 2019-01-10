package by.it.migunko.jd01_09;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String expression;

        Parcer parcer = new Parcer();
        Printer printer = new Printer();

        while (!(expression = scan.nextLine()).equals("end")){
            Var result = parcer.calc(expression);
            printer.print(result);
        }
    }
}

