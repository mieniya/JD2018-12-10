package by.it.dziomin.calculator.reports;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ReportDispatcher {

    private List<String> fullOperations = new ArrayList<>();
    private List<String> shortOperations = new ArrayList<>();
    private Date dateStart;
    private Date dateEnd;
    private boolean isBuildReport = false;
    private boolean isFullReport = false;


//    public ReportDispatcher() {
////    }

    private Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    private Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public boolean isBuildReport() {
        return isBuildReport;
    }

    private void setFlagBuildReport() {
        isBuildReport = true;
    }

    private boolean isFullReport() {
        return isFullReport;
    }

    private void setFlagFullReport() {
        isFullReport = true;
    }

    public void preDispatch() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Do you want the report in the end of calculation?(yes/no)");
        String str = sc.nextLine();
        if (str.equalsIgnoreCase("yes") || str.equalsIgnoreCase("y")) {
            setFlagBuildReport();
            System.out.println("Do you want the full report?(yes/no)");
            str = sc.nextLine();
            if (str.equalsIgnoreCase("yes")||str.equalsIgnoreCase("y")) {
                setFlagFullReport();
            }
        }
    }

    public void buildReport() {
        ReportType reportType;
        String title;
        List<String> operations;
        if (isFullReport()) {
            reportType = ReportType.LONGTYPE;
            operations =fullOperations;
            title = "Full report";
        } else {
            title = "Short report";
            reportType = ReportType.SHORTTYPE;
            operations =shortOperations;
        }
        ReportBuilder report = new ReportBuilder().buildReportType(reportType).buildTitle(title)
                .buildDateStart(getDateStart()).buildDateEnd(getDateEnd()).buildOperations(operations).build();
        System.out.println(report);
    }


    public void setFullReportOperations(String operation) {
            this.fullOperations.add(operation);
    }

    public void setShortReportOperations(String operation) {
        this.shortOperations.add(operation);
    }
}
