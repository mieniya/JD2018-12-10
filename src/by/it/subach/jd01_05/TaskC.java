package by.it.subach.jd01_05;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
//        step1();
        step2();
    }

    public static void step1() {

        int n = (int) (random() * ((40 - 20) + 1)) + 20;
        System.out.println(n);
        double[] arrayA = new double[n];
        double step = (9 - 5.33) / (n - 1);

        int i = 0;
        int count = 0;      //для значений больше 3,5
        for (double x = 5.33; x <= 9; x += step) {
            arrayA[i] = cbrt(pow(x, 2) + 4.5);
            if (arrayA[i] > 3.5) {
                count++;
            }
            i++;
        }

        for (int j = 0; j < arrayA.length; j++) {
            System.out.printf("%s[ %-2d] = %-10.9f   ", "A", j, arrayA[j]);
            if ((j + 1) % 5 == 0) {
                System.out.println();
            }
        }

//        создаем новый массив со значениями больше 3,5 и вычисляем среднее геометрическое
        double average = 1;
        double[] arrayB = new double[count];
        for (int j = 0, k = 0; j < arrayA.length; j++) {
            if (arrayA[j] > 3.5) {
                arrayB[k] = arrayA[j];
                average *= arrayB[k];
                k++;
            }
        }

        System.out.println("\n\nМассив В с элементами > 3.5");
        for (int j = 0; j < arrayB.length; j++) {
            System.out.printf("%s[ %-2d] = %-10.9f   ", "B", j, arrayB[j]);
            if ((j + 1) % 5 == 0) {
                System.out.println();
            }
        }

        System.out.println("\nСреднее геометрическое = " + pow(average, 1.0 / arrayB.length));
    }

    public static void step2() {
        int n = (int) (random() * ((40 - 30) + 1)) + 30;
        System.out.println(n);
        int[] arrayA = new int[n];

        int counterB = 0;
        for (int i = 0; i < arrayA.length; i++) {
            arrayA[i] = (int) (random() * ((450 - 103) + 1)) + 103;
            if (arrayA[i] * 0.1 > i) {
                counterB++;
            }
        }

        System.out.println("Array A");
        Out.printArrayA(arrayA, "A", 5);

        int [] arrayB = new int [counterB];

//          fill arrayB
        for (int i = 0, j = 0; i < arrayA.length; i++) {
            if(arrayA[i] * 0.1 > i){
                arrayB[j] = arrayA[i];
                j++;
            }
        }

        Helper.sort(arrayB);

        System.out.println("\n Array B");
        Out.printArrayB(arrayB, "B",  2);




    }

}
