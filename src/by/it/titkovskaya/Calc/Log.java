package by.it.titkovskaya.Calc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Log {

    private static String filename = System.getProperty("user.dir")+""+
            "/src/by/it/titkovskaya/Calc/"+
            "log.txt";

    private Log(){
    }

    static void toLog(String logLine){
        try (BufferedWriter out = new BufferedWriter(new FileWriter(filename, true))) {
            out.write(logLine);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
