package by.it.yarmolenka.MathCalc;

import by.it.yarmolenka.MathCalc.ReportCalc.*;
import by.it.yarmolenka.MathCalc.ReportCalc.Report;
import by.it.yarmolenka.MathCalc.Strings.*;
import by.it.yarmolenka.MathCalc.Variables.Var;

import java.io.*;
import java.util.Date;
import java.util.List;

public class ConsoleRunner {
    public static void main(String[] args) throws IOException {
        Date start = new Date();
        String expression;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Parcer parcer = new Parcer();
        Printer printer = new Printer();
        Translator translator = Translator.INSTANCE;
        Var.loadVarsFromFile();
        LABEL:
        while (true) {
            System.out.println(translator.get(Message.INPUT));
            expression = reader.readLine();
            switch (expression) {
                case Exit.END:
                    break LABEL;
                case Language.RU:
                    translator.setLocale(Language.RU, Country.RU);
                    System.out.println(translator.get(Message.LANGUAGE));
                    continue;
                case Language.BE:
                    translator.setLocale(Language.BE, Country.BY);
                    System.out.println(translator.get(Message.LANGUAGE));
                    continue;
                case Language.EN:
                    translator.setLocale(Language.EN, Country.US);
                    System.out.println(translator.get(Message.LANGUAGE));
                    continue;
                default:
                    try {
                        expression = expression.trim();
                        Var result = parcer.calc(expression);
                        printer.print(result);
                    } catch (CalcException e) {
                        printer.showError(e);
                    }
            }
        }
        Date finish = new Date();
        Reporter reporter = new Reporter();
        ReportBuilder builder = new ShortReportBuilder();
        reporter.setReportBuilder(builder);
        Log log = Log.getLog();
        List<String> list = log.getLogList();
        reporter.constructReport(start, finish, list, translator);
        Report report = reporter.getReport();
        System.out.println(report);
        Var.saveVarsToFile();
    }
}