package by.it.subach.Calc_V6_fabric_and_logging;

import by.it.subach.Calc_V6_fabric_and_logging.localization.TranslateManager;
import by.it.subach.Calc_V6_fabric_and_logging.reportBuilder.ShortReportBuilder;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        String expression;
        Scanner scanner = new Scanner(System.in);
        Parcer parcer = new Parcer();
        Printer printer = new Printer();

        TranslateManager tm = TranslateManager.INSTANCE;

        ShortReportBuilder srb = new ShortReportBuilder();
        srb.printHeader();
        Var.loadVarFromFile();
        while (!(expression = scanner.nextLine()).equalsIgnoreCase("end")) {

            if (expression.equalsIgnoreCase("ru")) {
                tm.setLocale("ru", "RU");
                System.out.println("Сообщения об ошибках на русском языке");
            } else if (expression.equalsIgnoreCase("be")) {
                tm.setLocale("be", "BY");
                System.out.println("Паведамленнi аб памылках на беларускай мове");
            } else if (expression.equalsIgnoreCase("en")) {
                tm.setLocale("en", "US");
                System.out.println("Error messages an english");
            } else {
                String result;
                try {
                    result = parcer.calc(expression);
                    printer.print(result);
                } catch (CalcException e) {
                    printer.showError(e);
                }
            }
        }
        srb.printEndUseTime();
        Var.saveVarToFile();
    }
}
