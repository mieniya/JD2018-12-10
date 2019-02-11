package by.it.dziomin.calculator.reports;

import java.util.Date;
import java.util.List;

public class Report {

    private ReportType reportType;
    private String title;
    private Date dateStart;
    private Date dateEnd;
    private List<String> operations;

    void setReportType(ReportType reportType) {
        this.reportType = reportType;
    }

    void setTitle() {
        this.title = "Full report";
    }

    void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    void setOperations(List<String> operations) {
        this.operations = operations;
    }

    @Override
    public String toString() {
        return "Report{" +
                "reportType=" + reportType +
                ", title='" + title + '\'' +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                ", operations=" + operations +
                '}';
    }
}

