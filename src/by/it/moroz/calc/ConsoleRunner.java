package by.it.moroz.calc;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {

        ResMan resMan = ResMan.INSTANCE;
        String input;
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();

        Var.loadVarFromFile();

        while (!(input = scanner.nextLine()).equalsIgnoreCase("end")) {
            String result;
            if (input.equalsIgnoreCase("printvar")) {
                System.out.println(resMan.getMessage(Message.PRINT));
                Var.printVar();
            } else if (input.equalsIgnoreCase("sortvar")) {
                System.out.println(resMan.getMessage(Message.SORT));
                Var.sortVar();
            } else if (input.equalsIgnoreCase("ru")) resMan.setLocale("ru", "RU");
            else if(input.equalsIgnoreCase("be")) resMan.setLocale("be", "BY");
            else if(input.equalsIgnoreCase("en")) resMan.setLocale(Locale.getDefault());
            else try {
                result = parser.calc(input);
                printer.print(result);

            } catch (CalcException calcException) {
                printer.showError(calcException);
            }
        }
        Var.saveVarToFile();
    }
}
