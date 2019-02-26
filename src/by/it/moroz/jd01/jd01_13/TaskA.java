package by.it.moroz.jd01.jd01_13;

import java.util.HashMap;

public class TaskA {

    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (NullPointerException | NumberFormatException e){
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                if(element.getMethodName().equals("main")){
                    String name = e.getClass().getName();
                    String className  = element.getClassName();
                    int line = element.getLineNumber();
                    System.out.printf("name: %s\n", name);
                    System.out.printf("class: %s\n", className);
                    System.out.printf("line: %d\n", line);
                }
            }

        }
    }
}
