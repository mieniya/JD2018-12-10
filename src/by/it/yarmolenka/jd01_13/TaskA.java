package by.it.yarmolenka.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (NumberFormatException | NullPointerException e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (stackTraceElement.getMethodName().equals("main")) {
                    System.out.printf(" name: %s\nclass: %s\n line: %d", e.getClass().getName(), stackTraceElement.getClassName(), stackTraceElement.getLineNumber());
                }
            }
        }
    }
}
