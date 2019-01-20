package by.it.zagurskaya.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {

        if (Math.random()>0.5)
            new HashMap<String, String>(null);
        else
            Integer.parseInt("привет");
    } catch (NullPointerException | NumberFormatException e) {
            String name = e.getClass().getName();
           // System.out.printf(" name: %s\n", name);

            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element: stackTrace){
                if (element.getMethodName().equals("main")) {
                    String className = element.getClassName();
                    Integer lineNamber = element.getLineNumber();
                    System.out.printf("name: %s\n"+"class: %s\n"+"line: %s\n", name, className, lineNamber);
                    break;
                }
               // System.out.println(" element "+element);
            }

//            System.out.flush();
//            e.printStackTrace(System.out);
            //e.printStackTrace();
        }
    }
}
