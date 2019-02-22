package by.it.lyakhova.jd03_01;

public class Runner {

    public static void main(String[] args) {
        new Connect();
        C_reset.deleteTables();
        C_reset.deleteSchema();
        C_init.addSchema();
        C_init.addTables();
        C_init.addData();

    }
}
