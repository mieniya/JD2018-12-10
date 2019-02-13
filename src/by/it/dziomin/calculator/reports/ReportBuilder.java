package by.it.dziomin.calculator.reports;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class ReportBuilder {
    private ReportType reportType;
    private String title;
    private Date dateStart;
    private Date dateEnd;
    private List<String> operations;

    ReportBuilder buildReportType(ReportType reportType) {
        this.reportType = reportType;
        return this;
    }

    ReportBuilder buildTitle(String title) {
        this.title = title;
        return this;
    }

    ReportBuilder buildDateStart(Date dateStart) {
        this.dateStart = dateStart;
        return this;
    }

    ReportBuilder buildDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
        return this;
    }

    ReportBuilder buildOperations(List<String> operations) {
        this.operations = operations;
        return this;
    }

    ReportBuilder build() {
        Report report = new Report();
        report.setReportType(reportType);
        report.setTitle();
        report.setDateStart(dateStart);
        report.setDateEnd(dateEnd);
        report.setOperations(operations);
        return this;
    }

    @Override
    public String toString() {
        DateFormat dstart;
        DateFormat dend;
        if (reportType == ReportType.LONGTYPE) {
            dstart = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL);
            dend = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL);
        } else {
           dstart = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
           dend = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT);
        }

        return "Report:" +
                "\n\"" + title + "\"" +
                "\nstarting time=" + dstart.format(dateStart.getTime()) +
                "\ncurrent time=" + dend.format(dateEnd.getTime()) +
                "\noperations=" + operations;
    }

}
