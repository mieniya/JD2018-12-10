package by.it.agadzhanov.jd01_05;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        double step = (9 - 5.33) / (28 - 1); //шаг для 30 элементов
        double[] a = new double[28];
        int i = 0;
        for (double x = 5.33; x <= 9; x = x + step) {
            a[i] = cbrt(pow(x, 2) + 4.5);
            i++;
        }
        System.out.print("Массив A[]");
        System.out.println();
        InOut.printArray(a, "Z1", 5);
        System.out.println();

        //finding the length of the second array
        int z2Length = 0;
        for (int j = 0; j < a.length; j++) {
            if (a[j] > 3.5)
                z2Length++;
        }

        double[] b = new double[z2Length];

        //constructing the second array
        for (int k = 0; k < b.length; k++) {
            b[k] = a[a.length - b.length + k];
        }
        System.out.println("Массив B[] из элементов массива A > 3.5");
        InOut.printArray(b, "Z2", 5);
        System.out.println();

        //finding geometric average;
        double product = 1;
        for (int m = 0; m < b.length; m++) {
            product = product * b[m];
        }
        double avg = pow(product, 1.0 / b.length);
        System.out.println("Среднее геометрическое чисел массива B=" + avg);
    }

    private static void step2() {
        int[] A=new int[31];
        for (int i = 0; i < A.length; i++) {
            A[i]=(int) (random()*348+103);
        }

        //finding the length of the second array
        int Blength=0;
        for (int j = 0; j < A.length; j++) {
            if (A[j]*0.1>j)
                Blength++;
        }

        double[] B=new double[Blength];

        //constructing the second array
        for (int k = 0; k < B.length; k++) {
            B[k]=A[A.length-B.length+k];
        }
    }
}