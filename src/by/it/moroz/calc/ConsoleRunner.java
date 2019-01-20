package by.it.moroz.calc;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input;
        Parser parser = new Parser();
        Printer printer = new Printer();
        while (!(input=scanner.nextLine().toLowerCase()).equals("end")){
            Var result = null;
            try {
                result = parser.calc(input);
            } catch (CalcExeption calcExeption) {
                calcExeption.printStackTrace();
            }
            printer.print(result);
        }
    }
}
