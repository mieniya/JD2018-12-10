package by.it.lyakhova.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try{
            if (Math.random()>0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (NullPointerException | NumberFormatException e){
            String name = e.getClass().getName();

            //System.out.flush(); - очизает буфер
            StackTraceElement[] stackTrace = e.getStackTrace();
            String className = "none";
            Integer lineNumber = -1;
            for (StackTraceElement element :
                    stackTrace) {
                if(element.getMethodName().equals("main")){
                    className = element.getClassName();
                    lineNumber = element.getLineNumber();
                }
               /* System.out.println("element: " + element);element: java.util.HashMap.putMapEntries(HashMap.java:501)
                                                            element: java.util.HashMap.<init>(HashMap.java:490)
                                                            element: by.it.lyakhova.jd01_13.TaskA.main(TaskA.java:9)*/
            }

            System.out.printf("name: %s\n" +
                                "class: %s\n" +
                                "line: %s\n",
                                name, className, lineNumber);
            /*e.printStackTrace();java.lang.NullPointerException
                                at java.util.HashMap.putMapEntries(HashMap.java:501)
                                at java.util.HashMap.<init>(HashMap.java:490)
                                at by.it.lyakhova.jd01_13.TaskA.main(TaskA.java:9)*/

            //e.printStackTrace(System.out);
        }

    }
}
