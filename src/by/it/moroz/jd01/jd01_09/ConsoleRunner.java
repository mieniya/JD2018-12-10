package by.it.moroz.jd01.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input;
        Parser parser = new Parser();
        Printer printer = new Printer();
        while (!(input=scanner.nextLine().toLowerCase()).equals("end")){
            Var result = parser.calc(input);
            printer.print(result);
        }
    }
}
