package by.it.titkovskaya.Calc;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

abstract class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();

    private static String varsFile = System.getProperty("user.dir") + ""
            + "/src/by/it/titkovskaya/Calc/"
            + "vars.txt";

    static Var createVar(String operand) throws CalcException {
        operand = operand.trim().replace("\\s", "");
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        else if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        else if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        else if (vars.containsKey(operand))
            return vars.get(operand);
        throw new CalcException("Переменная " + operand + " не определена");
    }

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

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Сложение " + this + " и " + other + " невозможно");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Вычитание " + this + " и " + other + " невозможно");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Умножение " + this + " на " + other + " невозможно");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Деление " + this + " на " + other + " невозможно");
    }

    @Override
    public String toString() {
        return "Какая-то непонятная переменная";
    }

}
