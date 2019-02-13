package by.it.dziomin.calculator;


import by.it.dziomin.calculator.reports.ReportDispatcher;
import by.it.dziomin.calculator.vars.Var;

import java.util.Date;
import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input;
        Printer printer = new Printer();
        Parser pars = new Parser();
        Var var;
        ReportDispatcher reportDispatcher = new ReportDispatcher();
        reportDispatcher.preDispatch();
        reportDispatcher.setDateStart(new Date());


        while (!(input = sc.nextLine()).equalsIgnoreCase("END")) {
            reportDispatcher.setFullReportOperations(input);
            reportDispatcher.setShortReportOperations(input);
            try {
                var = pars.calc(input);
                if (var != null) {
                    printer.print(var);
                    reportDispatcher.setFullReportOperations(var.toString());
                    reportDispatcher.setShortReportOperations(var.toString());
                }
            } catch (CalcException e) {
                reportDispatcher.setFullReportOperations(e.getMsg());
                reportDispatcher.setShortReportOperations(e.getShortMsg());
                printer.print(e.getMsg());
            }
        }

        if (reportDispatcher.isBuildReport()) {
            reportDispatcher.setDateEnd(new Date());
            reportDispatcher.buildReport();
        }

    }
}


