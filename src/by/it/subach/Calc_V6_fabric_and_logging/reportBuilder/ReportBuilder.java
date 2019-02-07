package by.it.subach.Calc_V6_fabric_and_logging.reportBuilder;

public interface ReportBuilder {

    void printHeader();
    void printStartUseTime();
    void printEndUseTime();
    void printOperations(String operation, String result);
    void printExceptions(String exception);
}
