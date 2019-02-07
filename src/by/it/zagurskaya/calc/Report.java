package by.it.zagurskaya.calc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Report {
    private static volatile Report instance;

    private String FILENAMESHORT;
    private String FILENAMFULL;

    private Report() {
        FILENAMESHORT = System.getProperty("user.dir")
                + "/src/by/it/zagurskaya/calc/reportshort.txt";
        FILENAMFULL = System.getProperty("user.dir")
                + "/src/by/it/zagurskaya/calc/reportfull.txt";
        report("       Отчет об операциях в учебном проекте \n");
    }

    public static Report getReport() {
        if (instance == null) {
            synchronized (Report.class) {
                if (instance == null)
                    instance = new Report();
            }
        }
        return instance;
    }

    void report(String text) {

        String message = text + "\n";
        synchronized (Report.class) {
            try (
                    BufferedWriter outShort =
                            new BufferedWriter(
                                    new FileWriter(FILENAMESHORT, true)
                            );
                    BufferedWriter outFull =
                            new BufferedWriter(
                                    new FileWriter(FILENAMFULL, true)
                            )
            ) {
                if (message.length()>5 && message.substring(0, 5).equalsIgnoreCase("ERROR")) {
                    outShort.write("ERROR \n");
                    message = message.replaceAll("ERROR:", "");
                    outFull.write(message);
                } else {
                    outShort.write(message);
                    outFull.write(message);
                }
            } catch (IOException|StringIndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
    }
}
