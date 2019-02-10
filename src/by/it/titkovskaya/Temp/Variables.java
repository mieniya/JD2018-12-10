package by.it.titkovskaya.Temp;
/*
import by.it.titkovskaya.calc.CalcException;
import by.it.titkovskaya.calc.Parser;
import by.it.titkovskaya.calc.Var;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Variables {

    private static Map<String, Var> vars = new HashMap<>();

    private static String varsFile = System.getProperty("user.dir") + ""
            + "/src/by/it/titkovskaya/calc/"
            + "vars.txt";

    static void saveVar(String nameVar, Var value) {
        vars.put(nameVar, value);
    }

    static void showVar() {
        for (Map.Entry<String, Var> varEntry : vars.entrySet()) {
            System.out.println(varEntry.getKey() + "=" + varEntry.getValue());
        }
    }

    static void showSortVar() {
        Map<String, Var> sortVars = new TreeMap<>(vars);
        for (Map.Entry<String, Var> varEntry : sortVars.entrySet()) {
            System.out.println(varEntry.getKey() + "=" + varEntry.getValue());
        }
    }

    static void saveVarToFile() {
        try (BufferedWriter out =
                     new BufferedWriter(
                             new FileWriter(varsFile, true))) {
            for (Map.Entry<String, Var> entry : vars.entrySet()) {
                out.write(String.format("%s=%s\n", entry.getKey(), entry.getValue()));
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void loadVarFromFile() {
        if (!new File(varsFile).exists()) return;
        Parser parser = new Parser();
        try (BufferedReader reader = new BufferedReader(new FileReader(varsFile))) {
            for (; ; ) {
                String s = reader.readLine();
                if (s == null)
                    return;
                parser.calc(s);
            }
        } catch (IOException | CalcException e) {
            e.printStackTrace();
        }
    }


}
*/