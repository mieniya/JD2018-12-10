package by.it.moroz.calc;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input;
        Parser parser = new Parser();
        Printer printer = new Printer();
        Var.loadVarFromFile();
        while (!(input = scanner.nextLine().toLowerCase()).equals("end")) {
            if (input.equalsIgnoreCase("printvar")) {
                System.out.println("Список переменных:");
                Var.printVar();
            } else if (input.equalsIgnoreCase("sortvar")) {
                System.out.println("Отсортированный список переменных:");
                Var.sortVar();
            } else try {
                Var result = parser.calc(input);
                printer.print(result);

            } catch (CalcException calcException) {
                printer.showError(calcException);
            }
        }
        Var.saveVarToFile();
    }
}
