package by.it.titkovskaya.calc.reportBuilder;

import by.it.titkovskaya.calc.ConsoleRunner;
import by.it.titkovskaya.calc.ResMan;
import by.it.titkovskaya.calc.internationalization.strings.Service;

import java.text.DateFormat;
import java.util.LinkedList;

public class BriefReportBuilder extends ReportBuilder{

    private static LinkedList<String> operationsAndErrorsInfo = new LinkedList<>();


    public void addInfo(String info){
        operationsAndErrorsInfo.addLast(info);
    }

    @Override
    void buildOutputFileName() {
        report.setFileName(System.getProperty("user.dir")+""+
                "/src/by/it/titkovskaya/calc/reportBuilder/BriefReport.txt");
    }

    @Override
    void buildTitle() {
        report.setTitle(ResMan.INSTANCE.get(Service.BRIEF_REPORT));
    }

    @Override
    void buildStartTime() {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, ResMan.INSTANCE.getLocale());
        report.setStartTime(dateFormat.format(ConsoleRunner.timeStart));
    }

    @Override
    void buildOperationsAndErrorsInfo() {
        StringBuilder infoBuilder = new StringBuilder();
        for (String info : operationsAndErrorsInfo) {
            infoBuilder.append(info).append("\n");
        }
        report.setOperationsAndErrorsInfo(infoBuilder.toString());
    }

    @Override
    void buildFinishTime() {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, ResMan.INSTANCE.getLocale());
        report.setFinishTime(dateFormat.format(ConsoleRunner.timeFinish));
    }

}
