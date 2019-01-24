package by.it.skosirskiy.Calc;

import by.it.skosirskiy.Calc.Parcer;

import java.io.*;
import java.util.*;

abstract class Var implements Operation {

    private static String operand = System.getProperty("user.dir") + "" +
            "/src/by/it/skosirskiy/Calc/" +
            "operand.txt";

    private static HashMap<String,Var> vars=  new HashMap<>();


    public static void printvar(){
        System.out.println(vars);
    }
    public static void sortvar(){
        TreeMap<String, Var> treeMap = new TreeMap<>(vars);
        System.out.println(treeMap);
    }

    static Var createVar(String operand) throws CalcException{
        operand=operand.trim().replace("\\s+","");
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        else if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        else if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        else if (vars.containsKey(operand)) return vars.get(operand);

        throw new CalcException("Невозможно создать "+operand);

    }

    static void saveVar(String nameVar, Var value) {
        vars.put(nameVar, value);
    }
    static void saveVarToFile() {
        try (
                BufferedWriter out =
                        new BufferedWriter(
                                new FileWriter(operand, true)
                        )
        ) {
            for (Map.Entry<String, by.it.skosirskiy.Calc.Var> entry : vars.entrySet()) {
                out.write(String.format("%s=%s\n", entry.getKey(), entry.getValue()));
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    static void loadVarFromFile() {
        if (!new File(operand).exists()) return;

        Parcer parcer = new Parcer();
        try (BufferedReader reader = new BufferedReader(
                new FileReader(operand)
        )) {
            for (; ; ) {
                String s = reader.readLine();
                if (s == null)
                    return;
                parcer.calc(s);

            }
        } catch (IOException | by.it.skosirskiy.Calc.CalcException e) {
            e.printStackTrace();
        }

    }


    @Override
    public Var add(Var other) throws CalcException  {
        throw new CalcException("Операция сложения "+this+"+"+other+"невозможна");

    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Операция вычитания "+this+"-"+other+"невозможна");

    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Операция умножения "+this+"*"+other+"невозможна");

    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Операция деления "+this+"/"+other+"невозможна");

    }
}
