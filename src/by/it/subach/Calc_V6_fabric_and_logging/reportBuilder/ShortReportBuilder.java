package by.it.subach.Calc_V6_fabric_and_logging.reportBuilder;


import by.it.subach.Calc_V6_fabric_and_logging.Logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ShortReportBuilder implements ReportBuilder{

    StringBuilder shortReport = new StringBuilder();
    String header = "Short report";
    Date date = new Date();
    Logger logger = Logger.getLogger();


    @Override
    public void printHeader() {
        shortReport.append(header).append("\n\n");
        logger.log(header);
    }

    @Override
    public void printStartUseTime() {
        Date date = new Date();
        DateFormat df = SimpleDateFormat.getDateInstance(DateFormat.SHORT);
        String str = "Start use: ";
        shortReport.append(str).append(df.format(date)).append("\n");
        logger.log(str);
    }

    @Override
    public void printEndUseTime() {
        Date date = new Date();
        DateFormat df = SimpleDateFormat.getDateInstance(DateFormat.SHORT);
        String str = "Finish use: ";
        shortReport.append(str).append(df.format(date)).append("\n");
        logger.log(str);

    }

    @Override
    public void printOperations(String operation, String result) {

    }

    @Override
    public void printExceptions(String exception) {

    }
}
