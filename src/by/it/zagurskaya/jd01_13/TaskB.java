package by.it.zagurskaya.jd01_13;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        String expression;
        Scanner scanner = new Scanner(System.in);
        Map<Double, Double> varMap = new HashMap<>();

        double sumNumberExpression = 0;

        while (!(expression = scanner.nextLine()).equalsIgnoreCase("end")) {
            try {
                double numberExpression = Double.parseDouble(expression);
                sumNumberExpression = sumNumberExpression + numberExpression;
                if (sumNumberExpression < 0) {
                    throw new ArithmeticException();
                }
                varMap.putAll(numberAndSqrtSumToMap(numberExpression, Math.sqrt(sumNumberExpression)));
            } catch (NumberFormatException | ArithmeticException e) {
                printException(e);
            }
        }
        mapPrint(varMap);
    }

    static void mapPrint(Map<Double, Double> map) {
        for (Map.Entry<Double, Double> e : map.entrySet()) {
            System.out.printf("число %s, корень из числа %s\n", e.getKey(), e.getValue());
        }
    }

    static Map<Double, Double> numberAndSqrtSumToMap(Double number, Double sum) {
        Map<Double, Double> varMap = new HashMap<>();
        varMap.put(number, sum);
        return varMap;
    }

    static void printException(Exception e) {
        String name = e.getClass().getName();
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement element : stackTrace) {
            if (element.getMethodName().equals("main")) {
                String className = element.getClassName();
                Integer lineNumber = element.getLineNumber();
                System.out.printf("name: %s\n" + "class: %s\n" + "line: %s\n", name, className, lineNumber);
                break;
            }
        }
    }

}
