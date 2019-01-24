package by.it.skosirskiy.jd01_13;


import java.util.Scanner;

public class TaskB {



    public static void main(String[] args)   {

        Scanner scanner= new Scanner(System.in);
        String str;
        double sum = 0;



            while (!(str = scanner.next()).equals("END")) {
                try {

                double value = Double.valueOf(str);
                System.out.println("Введенное число: " + value);

                sum= sum+value;
                if(sum<0) throw new ArithmeticException();
                else System.out.println("Корень из сумм: " + Math.sqrt(sum));
                }
                catch (NumberFormatException e){
                    System.out.println("NumberFormatException");
                    StackTraceElement[] stackTrace = e.getStackTrace();
                    for (StackTraceElement element : stackTrace) {
                        if(TaskB.class.getName().equals(element.getClassName())){
                            String name= e.getClass().getName();
                            String className = element.getClassName();
                            int number = element.getLineNumber();
                            System.out.printf(" name: %s\n"+"class: %s\n"+" line: %s\n", name, className, number);
                        }

                    }

                }
                catch (ArithmeticException e){

                    StackTraceElement[] stackTrace = e.getStackTrace();
                    for (StackTraceElement element : stackTrace) {
                        if(TaskB.class.getName().equals(element.getClassName())){
                            String name= e.getClass().getName();
                            String className = element.getClassName();
                            int number = element.getLineNumber();
                            System.out.printf("name: %s\n"+"class: %s\n"+"line: %s\n", name, className, number);
                        }

                    }

                }
            }



    }


}
