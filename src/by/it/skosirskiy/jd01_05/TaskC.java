package by.it.skosirskiy.jd01_05;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        step1();
        step2();
    }
    private static void step1() {
        int maxElemnt=40;
        int minElement=20;
        double min=5.33;
        double max=9;
        double step=0;
        int count=0;
        double proiz=1;
        double sredneegeo;
        int element=(int)(random()*(minElement+1)+(maxElemnt-minElement));

       double[] array = new double[element];
        step=(max-min)/element;

        do {
            min=min+step;
            array[count]=random()*(min+1)+(max-min);
            count++;
        } while (min<=max);



        System.out.println("Массив 1");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%2s%3d%4s%8f", " A[", i, "] =", array[i]);
            i++;
            if(i%5==0) System.out.println();
            i--;
        }
        System.out.println();
        count=0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]>3.5) count++;

        }
        double[] newArray= new double[count];
        count=0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]>3.5) {
               newArray[count]=array[i];
               count++;
            }
        }

        System.out.println("Массив 2");
        for (int i = 0; i < newArray.length; i++) {
            System.out.printf("%2s%3d%4s%8f", " A[", i, "] =", newArray[i]);
            i++;
            if(i%5==0) System.out.println();
            i--;
        }
        for (int i = 0; i < newArray.length; i++) {
            proiz=proiz*newArray[i];
        }
        sredneegeo=proiz/newArray.length;
        System.out.println();
        System.out.printf("%20s%20f", "Среднее геометрическое:",proiz);
    }




    private static void step2() {
    }


}
