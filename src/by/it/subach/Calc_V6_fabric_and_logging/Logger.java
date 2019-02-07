package by.it.subach.Calc_V6_fabric_and_logging;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Logger {

    private static volatile Logger instance;

    private final String FILENAME;

    private Logger() {
        FILENAME = System.getProperty("user.dir") + "/src/by/it/subach/Calc_V6_fabric_and_logging/log.txt";
    }

    public static Logger getLogger() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null)
                    instance = new Logger();
            }
        }
        return instance;
    }

    public void log(String text) {
        Date date = new Date();
        DateFormat df = SimpleDateFormat.getDateTimeInstance(2, 2);
        String message = String.format("%s %s\n", df.format(date), text);
        synchronized (Logger.class) {

            try (
                    BufferedWriter out =
                            new BufferedWriter(
                                    new FileWriter(FILENAME, true)
                            )
            ) {

                out.write(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
