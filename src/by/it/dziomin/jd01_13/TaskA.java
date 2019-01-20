package by.it.dziomin.jd01_13;

import java.util.HashMap;

public class TaskA {


    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (NumberFormatException | NullPointerException e) {
            handleException(e, TaskA.class.getCanonicalName());
        }
    }

    static void handleException(Exception e, String cl) {
        StackTraceElement[] stackTrace = e.getStackTrace();
        String className = "";
        int lineNumber = 0;
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (stackTraceElement.getClassName().equals(cl)) {
                className = stackTraceElement.getClassName();
                lineNumber = stackTraceElement.getLineNumber();
                break;
            }
        }

        System.out.printf("name: %s\n" +
                "class: %s\n" +
                "line: %d\n", e, className, lineNumber);
    }
}
